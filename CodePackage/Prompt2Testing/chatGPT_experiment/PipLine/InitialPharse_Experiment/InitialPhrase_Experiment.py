# -*- coding: utf-8 -*-
import torch
torch.cuda.set_device(1)
import shutil
import subprocess
import openai
import pandas as pd
import os
import re
import json
import time
import tiktoken
from tqdm import tqdm
import traceback
from transformers import GenerationConfig, LlamaForCausalLM, LlamaTokenizer
from transformers import AutoTokenizer, AutoModelForCausalLM, LlamaForCausalLM
current_dir = os.path.dirname(__file__) #./PipLine

Promt2Testing_PATH = os.path.normpath(os.path.join(current_dir, '../../../'))
# 访问路径
Result_PATH = os.path.join(Promt2Testing_PATH, "chatGPT_experiment",'Result')
testedRepo_PATH = os.path.join(Promt2Testing_PATH, "repo_get",'approachValidation_repo')


model = "CodeFuse"
log_file = 'codeFuse_no_inten_LOGINFO.txt'

Intention_TAG = "no_" not in log_file

# contain_intention 是用来ChatGPTtester.py的输入文件
# no_intention 是ChatGPT直接生成的code.
# Intention_TAG = False  # False is no intention, True is intention
if Intention_TAG:
    dir_Name = 'Contain_intention'
else:
    dir_Name = "No_intention"


if "WizardCoder" == model:
    sub_save_dir = "WizardCoder"
    model_name =  "WizardLM/WizardCoder-15B-V1.0"

    problem_prompt = (
    "Below is an instruction that describes a task. "
    "Write a response that appropriately completes the request.\n\n"
    "### Instruction:\n{instruction}\n\n### Response:")
elif "CodeLlama" == model:
    sub_save_dir = "CodeLlama"
    model_name = "/home/zqc/Test_Completion/CodeLlama-34b-Instruct-hf"

    B_INST, E_INST = "[INST]", "[/INST]"
    B_SYS, E_SYS = "<<SYS>>\n", "\n<</SYS>>\n\n"

    system_prompt = '''
    You are a helpful, respectful and honest assistant with a deep knowledge of code and software design. Always answer as helpfully as possible, while being safe. Your answers should not include any harmful, unethical, racist, sexist, toxic, dangerous, or illegal content. Please ensure that your responses are socially unbiased and positive in nature.
    If a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct. If you don't know the answer to a question, please don't share false information.
    '''
    system_prompt = f"{B_SYS}{system_prompt}{E_SYS}"
    problem_prompt = (system_prompt + "[INST] {instruction} [/INST]")

elif "CodeFuse" == model:
    sub_save_dir = "CodeFuse"
    model_name = "/home/zqc/Test_Completion/CodeFuse-CodeLlama-34B"

    HUMAN_ROLE_START_TAG = "<|role_start|>human<|role_end|>"
    BOT_ROLE_START_TAG = "<|role_start|>bot<|role_end|>"
    problem_prompt = (HUMAN_ROLE_START_TAG + "{instruction}" + BOT_ROLE_START_TAG)



original_java_PATH = os.path.join(current_dir,dir_Name,sub_save_dir, 'original_java')
LogINFO_PATH = os.path.join(current_dir, dir_Name, sub_save_dir,'LogINFO')
Surefire_reports_dest_path = os.path.join(current_dir, dir_Name,sub_save_dir,'Surefire_reports')
GeneratedTest_PATH = os.path.join(current_dir,dir_Name,sub_save_dir,'GeneratedTest')
MetricOut_Path = os.path.join(current_dir,dir_Name, sub_save_dir,'result_1.json')



tokenizer = AutoTokenizer.from_pretrained(model_name, use_fast=False)
model = AutoModelForCausalLM.from_pretrained(
    model_name, low_cpu_mem_usage=True, torch_dtype=torch.float16).cuda()


     
                                
def generate(prompt):
    input_ids = tokenizer([prompt]).input_ids
    output_ids = model.generate(
        torch.as_tensor(input_ids).cuda(), max_new_tokens=1024, max_length=2048, repetition_penalty=1.2) # do_sample=False, temperature=0.2, 
    output_ids = output_ids[0][len(input_ids[0]) :]
    outputs = tokenizer.decode(output_ids, skip_special_tokens=True).strip()
    return outputs



# 利用 chat-gpt 生成 intention
def intention_unit(ask_intention_prompt):

    # role = "I want you to play the role of a professional who infers method intention."
    # instruction = role + '\n\n' + ask_intention_prompt
    prompt = problem_prompt.format(instruction=ask_intention_prompt)
    intentions = generate(prompt)
    intention = re.split('(?<=[.!?]) +', intentions)[0]
    return intentions

# 利用 chat-gpt生成 test method
def method_pred_unit(ask_test_method_prompt):
    role = "I want you to play the role of a professional who writes Java test method for the Focal method. The following is the Class, Focal method and Import information."
    instruction = role + '\n\n' + ask_test_method_prompt
    prompt = problem_prompt.format(instruction=instruction)
    
    
    generated_content = generate(prompt)
    test_method = return_code(generated_content).replace("```","")
    return test_method

# 从 chat-gpt 生成的内容中提取 code
def return_code(generated_content):
    generated_content = '\n'.join([line for line in generated_content.split('\n') if "Below is " not in line])
    generated_content = generated_content.replace("java\r\n","").replace("...","").replace("java\n","").replace("Java\n","")
    code_list = []
    # find code
    pattern = r"```(.*?)```(?![\w\d])"
    matches = re.findall(pattern, generated_content, re.DOTALL)
    for match in matches:
        code_list.append(match.strip())
    if len(code_list) == 0 and ("}\n}" in generated_content or "}\n\n}" in generated_content):
        if "}\n}" in generated_content:
            Pos = generated_content.rfind("}\n}")
            Code = generated_content[:Pos+len("}\n}")]
            Code = Code.replace("\nNote:", "// Note:")
            code_list.append(Code)
        elif "}\n\n}" in generated_content:
            Pos = generated_content.rfind("}\n\n}")
            Code = generated_content[:Pos + len("}\n\n}")]
            Code = Code.replace("\nNote:", "// Note:")
            code_list.append(Code)
    if len(code_list)==0: raise ValueError("No Test method generated\n"+generated_content)
    return code_list[0]


def Compile_Test_unit(pro_name, sub_project_name, test_file_name, test_path, Dtest_para, JUNIT_VERSION):
    excute_path = os.path.join(testedRepo_PATH, pro_name)
    os.chdir(excute_path)
    # windows use ["cmd",'/c',...], and Linux doesn't use it.
    if sub_project_name != "":
        mvn_compile = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test-compile', '-Dcheckstyle.skip=true']
        mvn_test = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test', '-Dcheckstyle.skip=true']
        if JUNIT_VERSION == 5:
            mvn_compile = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test-compile', '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']
            mvn_test = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test', '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']

    else:
        mvn_compile = [ 'mvn', f'-Dtest={Dtest_para}', 'test-compile', '-Dcheckstyle.skip=true']
        mvn_test = ['mvn', f'-Dtest={Dtest_para}', 'test', '-Dcheckstyle.skip=true']
        if JUNIT_VERSION == 5:
            mvn_compile = ['mvn', f'-Dtest={Dtest_para}', 'test-compile', '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']
            mvn_test = ['mvn', f'-Dtest={Dtest_para}', 'test', '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']

    write_cont, compile_result, test_result = Compile_Test_sub_unit(mvn_compile, mvn_test, test_path)

    # 未能正确的执行mvn 指令。此时首先需要执行 mvn clean
    if compile_result != 1 and "[ERROR] COMPILATION ERROR :" not in write_cont and "Could not resolve dependenci" in write_cont:
            mvn_install = [ 'mvn', 'clean', 'install']
            mvn_result = subprocess.run(mvn_install, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                         universal_newlines=True)
            if "BUILD SUCCESS" in mvn_result.stdout or "BUILD SUCCESS" in mvn_result.stderr:
                write_cont, compile_result, test_result = Compile_Test_sub_unit(mvn_compile, mvn_test, test_path)
            else:
                # 进入到子目录当中
                target_PATH = os.path.join(excute_path, sub_project_name)
                os.chdir(target_PATH)
                write_cont, compile_success, test_result = Compile_Test_sub_unit(mvn_compile, mvn_test, test_path)
    os.chdir(current_dir)

    if compile_result == 0 and "[ERROR] COMPILATION ERROR :" not in write_cont: raise Exception("Mvn execute failed")
    compile_logInfo_path = os.path.join(LogINFO_PATH, os.path.basename(test_file_name))
    with open(compile_logInfo_path, 'w', encoding='utf-8') as f:
        f.write(write_cont)

    # 处理执行mvn test 保存到 ./target/Surefire_reports/* 当中的信息
    Surefire_reports_dst_file = Surefire_reports_TEST_info(write_cont, test_file_name, Dtest_para)


    return compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file

def Compile_Test_sub_unit(mvn_compile, mvn_test, test_path):
    compile_success, test_success = 0, 0
    compile_result = subprocess.run(mvn_compile, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                    universal_newlines=True)
    write_cont = "original test path: " + test_path + "\n########## Compile INFO ##########\n" + compile_result.stdout + compile_result.stderr

    if "BUILD SUCCESS" in compile_result.stdout or "BUILD SUCCESS" in compile_result.stderr:
        compile_success = 1

        test_result = subprocess.run(mvn_test, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True)
        write_cont = "original test path: " + test_path + "\n########## Compile INFO ##########\n" + compile_result.stdout + compile_result.stderr + \
                     "\n########## Test INFO ##########\n" + test_result.stdout + test_result.stderr

        if "BUILD SUCCESS" in test_result.stdout or "BUILD SUCCESS" in test_result.stderr:
            test_success = 1

    return write_cont, compile_success, test_success

def Surefire_reports_TEST_info(INFO_CONT, test_file_name, Dtest_para):
    # 目前观测到，当顺利执行mvn test 之后，如果 放回的是failure，那么会由一个如下的信息：
    # [ERROR] Please refer to /home/fdse/zhiqiang/python/Promt2Testing/repo_get/testedRepo384/graphhopper_graphhopper/core/target/surefire-reports for the individual test results.
    # 需要将这个信息中的这个文件路径保存移动到 Metric/surefire_reports 路径当中，文件名为 xxx_xxx.xml
    file_name = "TEST-" + os.path.basename(test_file_name).replace(".java", ".xml")
    start_index = INFO_CONT.find("[ERROR] Please refer to ")
    if start_index < 0: return
    start_index = start_index + len("[ERROR] Please refer to ")
    end_index = INFO_CONT.find(" for the individual test results.")
    surefire_reports_PATH = INFO_CONT[start_index:end_index]
    Surefire_reports_dst_file = ""
    if surefire_reports_PATH != "":
        surefire_reports_Name = "TEST-" + Dtest_para + ".xml"
        src_path = os.path.join(surefire_reports_PATH, surefire_reports_Name)

        shutil.copy(src_path, Surefire_reports_dest_path)

        # 将文件重命名， 防止被覆盖
        Surefire_reports_dst_file = os.path.join(Surefire_reports_dest_path, os.path.basename(src_path))
        os.rename(Surefire_reports_dst_file, os.path.join(Surefire_reports_dest_path, file_name))
    return Surefire_reports_dst_file

# store java file into 'Generated'
def file_write(test_method, ori_test_Path, Test_Import_info):
    # 将test_method 当中的 package information和 import information 移除
    test_method_list = test_method.split("\n")
    test_methods = [method for method in test_method_list if "package " not in method and "import " not in method]
    test_method = "\n".join(test_methods)

    # 将 test method当中的comment 去除
    test_method = commentDelete(test_method)


    Out_dir = GeneratedTest_PATH
    # step1: 从path当中抽取package name.
    ori_test_method_name = ori_test_Path.split("###")[-1]
    if "/java/" in ori_test_Path:  package_name = ".".join(ori_test_Path.split("###")[1].split("/java/")[1].split("/")[:-1])
    elif "/java_generated/" in ori_test_Path: package_name = ".".join(ori_test_Path.split("###")[1].split("/java_generated/")[1].split("/")[:-1])
    else: package_name = ""

    # step2: 先确认生成的test method 当中是否存在 class name
    try:
        class_start_idx = test_method.index("class ") + len("class ")
        # 使用切片获取"class"后面的第一个单词
        class_name = test_method[class_start_idx:].split()[0]

        # 如果class_start_idx前面不是"public"，则添加"public"
        if "public" not in test_method[:class_start_idx].strip():
            test_method = "public " + test_method

    except:
        class_name = ""

    # step3： 得到写入文件中的内容
    # 如果生成的内容当中没有包含class的声明
    if len(class_name) == 0:
        file_name = "TTT" + "_" + ori_test_method_name
        write_cont ="package "+package_name+";\n"+ Test_Import_info + "\n" + \
        "// original test path: " + ori_test_Path + "\n" + \
        "public class " + file_name + " {\n" + test_method + "\n}"
    else:
        if ori_test_method_name in class_name:
            file_name = class_name
            write_cont = test_method
        else:
            file_name =  class_name + "_" + ori_test_method_name
            pattern = re.compile(f"(?<![a-zA-Z]){class_name}|{class_name}(?![a-zA-Z])")
            write_code = pattern.sub(file_name, test_method)
            write_cont ="package "+package_name+";\n"+ Test_Import_info + "\n" + \
                "// original test path: " + ori_test_Path + "\n" + \
                write_code
            write_cont = write_cont.replace("\nNote:", "// Note:")

    write_cont = "\n".join([line for line in write_cont.split("\n") if line.strip()])

    # step4: 将内容写入文件当中
    target_PATH = os.path.join(Out_dir, file_name+'.java')
    with open(target_PATH, 'w', encoding='utf-8') as f:
        f.write(write_cont)

    return target_PATH, write_cont, package_name

# 执行test 和 compile
def adhoc_excute(package_name,gen_test_PATH, gen_test_cont, ori_test_Path, testedRepo_PATH, JUNIT_VERSION):

    pro_name = ori_test_Path.split("###")[0]
    sub_project_name = ori_test_Path.split("###")[1].replace(pro_name, "").split("/src/")[0]
    if sub_project_name == "":  # 意味着 没有sub project
        sub_project_name = ""
    else:
        sub_project_name = "." + sub_project_name

    gen_class_name = os.path.basename(gen_test_PATH).replace(".java","")
    ori_class_name = os.path.basename(ori_test_Path.split("###")[1])


    # step1: 将原来的java file 保存 ./PipLine/original_java
    pro_test_path = ori_test_Path.split("###")[1] + ".java"
    ori_PATH = os.path.join(testedRepo_PATH, pro_test_path)
    if not os.path.exists(os.path.join(original_java_PATH, os.path.basename(ori_PATH))): shutil.copy(ori_PATH, original_java_PATH)

    # step2: 将新生成的内容写入项目当中
    Test_to_project(gen_class_name, ori_class_name, gen_test_cont, ori_PATH)

    # step3: 执行 test 和 compile
    compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file = Compile_Test_unit(pro_name, sub_project_name, gen_test_PATH, ori_test_Path, package_name+"."+ori_class_name, JUNIT_VERSION)

    return compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file


# 将 生成的Test java 文件写道project当中
def Test_to_project(gen_class_name, ori_class_name, gen_test_cont, ori_PATH):
    # if "ManfredTremmel_gwt-commons-lang3" and "StringUtilsTest" in ori_PATH: # 针对这个文件，有些依赖信息要加进去
    #     with open("./Depen/StringUtilsTestDepen.txt", 'r', encoding='utf-8') as f:
    #         file_cont = f.read()
    #     pos = gen_test_cont.find(gen_class_name+" {") + len(gen_class_name+" {")
    #     inster_cont = "\n" + file_cont
    #     gen_test_cont = gen_test_cont[:pos] + inster_cont + gen_test_cont[pos:]
    # if "/commons/lang3/time/FastDateParserTest" in ori_PATH:
    #     with open("./Depen/FastDateParserTestDepen.txt", 'r', encoding='utf-8') as f:
    #         file_cont = f.read()
    #     pos = gen_test_cont.find(gen_class_name + " {") + len(gen_class_name + " {")
    #     inster_cont = "\n" + file_cont
    #     gen_test_cont = gen_test_cont[:pos] + inster_cont + gen_test_cont[pos:]
    
    # if "commons/lang3/AnnotationUtilsTest" in ori_PATH:
    #     with open("./Depen/AnnotationUtilsTest.txt", 'r', encoding='utf-8') as f:
    #         file_cont = f.read()
    #     pos = gen_test_cont.find(gen_class_name + " {") + len(gen_class_name + " {")
    #     inster_cont = "\n" + file_cont
    #     gen_test_cont = gen_test_cont[:pos] + inster_cont + gen_test_cont[pos:]

    pattern = re.compile(f"(?<![a-zA-Z]){gen_class_name}|{gen_class_name}(?![a-zA-Z])")
    changed_code = pattern.sub(ori_class_name, gen_test_cont)
    with open(ori_PATH, 'w',  encoding='utf-8') as f:
        f.write(changed_code)


def Contain_intention(PL_Focal_Method,  focal_method_name, ori_test_Path, Test_Import_info, Junit_version):

    # Intention_NL= f'Please tell me the intention of the {focal_method_name} method.'
    Intention_NL = f'Please describe the intention of the {focal_method_name} method in one sentence.'
    ask_intention_prompt = PL_Focal_Method + '\n\n' + Intention_NL
    # obtain the method intention
    Method_intention = intention_unit(ask_intention_prompt)


    Composit_prompt = "// Import information\n" + Test_Import_info + "\n\n// Method intention \n" + Method_intention + "\n\n// Focal Method \n" + PL_Focal_Method +\
            f'\n\nPlease write a test method for the \"{focal_method_name}\" with the given Import information and Method intention (it is crucial). Ensure that the generated test method is complete and self-contained, and must use the JUnit framework'

    print("##################")
    print(Composit_prompt)
    print("##################")
    # generate test method
    Gen_test_method = method_pred_unit(Composit_prompt)
    # store the test_method into `GeneratedTest`
    gen_test_PATH, gen_test_cont, package_name = file_write(Gen_test_method, ori_test_Path, Test_Import_info)

    # return compile/test result, and processed excute_INFO
    compile_result, test_result, proced_compile_INFO, proced_test_INFO = adhoc_excute(package_name, gen_test_PATH,gen_test_cont, ori_test_Path, testedRepo_PATH, Junit_version)

    return compile_result, test_result, gen_test_PATH


def No_intention(PL_Focal_Method,  focal_method_name, ori_test_Path, Test_Import_info, Junit_version):
    # ask_test_method_prompt
    
    Composit_prompt = "// Import information\n" + Test_Import_info + "\n\n" + PL_Focal_Method +  "\n\n" +\
                f'Please write a test method for the {focal_method_name} with the given import information. Ensure that the generated test method is complete and self-contained, and must use the JUnit framework'


    # Composit_prompt = PL_Focal_Method +  "\n\n// Import information\n" + Test_Import_info + "\n\n" + \
    #             f'Please write a test method for the {focal_method_name} with the given import information. Ensure that the generated test method is complete and self-contained, and use the JUnit framework'


    # generate test method
    Gen_test_method = method_pred_unit(Composit_prompt)

    # store the test_method into `GeneratedTest`
    gen_test_PATH, gen_test_cont,package_name = file_write(Gen_test_method, ori_test_Path,Test_Import_info)


    # return compile/test result, and processed excute_INFO
    compile_result, test_result, proced_compile_INFO, proced_test_INFO = adhoc_excute(package_name, gen_test_PATH,gen_test_cont, ori_test_Path, testedRepo_PATH, Junit_version)

    return compile_result, test_result, gen_test_PATH

def commentDelete(code):
    # comment delete
    regex = r"/\*(.|\\n)*?\*/"
    noMultilineComments = re.sub(regex, "", code)

    # remove single line comments (// ...)
    regex = r"//.*"
    non_comment_code = re.sub(regex, "", noMultilineComments)

    pattern = re.compile(r"(?s)/\*.*?\*/|//.*?[\r\n]")  # 匹配 /**...*/ 样式的注释
    codeWithoutComment = pattern.sub("", non_comment_code)  # 去除注释

    return codeWithoutComment

def read_INFO(Json_file_Path):
    # PL_Focal_Method,  focal_method_name, Public_INFO, Class_Name, ori_test_Path, Junit_version
    # PL_Focal_Method: Focal Class; Focal Method;
    # Public_INFO: public method/filed signature
    # Class_Name:

    with open(Json_file_Path, 'r', encoding='utf-8') as f:
        file_cont = json.load(f)

    for cont in tqdm(file_cont):
        Under_test_method = cont['Under_test_method']
        Test_method = cont['Test_method']
        Test_Import_info = Test_method['all_Import_statements']
        Test_Import_info = '\n'.join(filter(lambda x: x.strip(), Test_Import_info.split('\n'))) # 去除空换行符
        Focal_class = Under_test_method['Class_declaration']
        Filed = commentDelete(Under_test_method['Filed'])+"\n"
        constructors = commentDelete(Under_test_method['constructors']) + "\n"
        Focal_Method_Info = commentDelete(Under_test_method["Method_body"])
        PL_Focal_Method = Focal_class +'\n'+ Filed + constructors + '\n' + '//Focal method\n'+ Focal_Method_Info + "\n}"
        PL_Focal_Method = '\n'.join(filter(lambda x: x.strip(), PL_Focal_Method.split('\n')))

        focal_method_name = Under_test_method['Method_statement']
        Junit_version = Under_test_method['Junit_version']
        Class_name = Under_test_method['Class_name']
        Public_INFO = Under_test_method['Class_declaration'] +'\n' + Under_test_method['public_field']+'\n' + Under_test_method['public_method_signature'] + "\n}"
        Public_INFO = '\n'.join(filter(lambda x: x.strip(), Public_INFO.split('\n')))
        project_name = Test_method['project_path'].split("###")[0]
        ori_test_Path = Test_method['project_path']

        # if "\"" + ori_test_Path + "\"" in dealed_cont: continue
        print("Deal:", ori_test_Path)
        # if "ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToByte" not in ori_test_Path: continue
        try:
            excute_path = os.path.join(testedRepo_PATH, project_name)
            os.chdir(excute_path)
            os.system('git commit -m "REPO"')
            os.chdir(current_dir)
            if Intention_TAG: # intention
                compile_result, test_result, Gen_Path = Contain_intention(PL_Focal_Method,  focal_method_name, ori_test_Path, Test_Import_info, Junit_version)
            else:
                compile_result, test_result, Gen_Path = No_intention(PL_Focal_Method, focal_method_name,
                                                                          ori_test_Path, Test_Import_info,
                                                                          Junit_version)
            out_dict = {"original_path": Test_method['project_path'], "generated_path": Gen_Path, "Compile": compile_result, "Test":test_result}
            with open(MetricOut_Path,"a", encoding="utf-8") as f:
                json.dump(out_dict, f,indent=2)
                f.write(",\n")


        except Exception as e:

            traceback.print_exc()

        finally:
            # reset repo status
            excute_path = os.path.join(testedRepo_PATH, project_name)
            os.chdir(excute_path)
            git_command = "git add .&& git stash"
            os.system(git_command)
            print("Reset Success!")
            os.chdir(current_dir)

# 如果文件夹存在先清空文件夹，再创一个。
def boolean(file_path):
    if not os.path.exists(file_path):
        print('Creat floder....')
        os.makedirs(file_path)
    else:
        shutil.rmtree(file_path)
        os.makedirs(file_path)


if __name__ == "__main__":
    import sys
    
    sys.stdout = open(log_file, 'a')
    sys.stderr = open(log_file, 'a')

    boolean(GeneratedTest_PATH)
    boolean(Surefire_reports_dest_path)
    boolean(LogINFO_PATH)
    boolean(original_java_PATH)

    # data pair path
    JSON_FILE_NAME = "ApplicationPick_100.json"
    Json_file_Path = os.path.join(Result_PATH, JSON_FILE_NAME)
    read_INFO(Json_file_Path)





