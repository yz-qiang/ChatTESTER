# -*- coding: utf-8 -*-
import torch
torch.cuda.set_device(4)
import glob
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
from Deal import Compile_Test_INFO
from Deal import FeedbackPrompt

current_dir = os.path.dirname(__file__) #./PipLine
Promt2Testing_PATH = os.path.normpath(os.path.join(current_dir, '../../../'))
applicationValid_100_PATH = os.path.join(Promt2Testing_PATH, 'chatGPT_experiment','Result','ApplicationPick_100.json')


# model_path = "./CodeFuse-CodeLlama-34B"
# log_file = "codeFuse_iterate.txt"


# model_path = "./CodeLlama-34b-Instruct-hf"
# log_file = "llama_iterate.txt"

openai.api_key = "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"
model_path = "gpt-3.5-turbo"
log_file = "gpt_iterate.txt"

# 这里的基于 Cotain_intention 的基础上做 refiner
class ChatGptTester:
    def __init__(self):

        # Path in root
        self.Result_PATH = os.path.join(Promt2Testing_PATH, "chatGPT_experiment", 'Result') # Data pair path
        self.testedRepo_PATH = os.path.join(Promt2Testing_PATH, "repo_get", 'approachValidation_repo') # repo path

        # Path in contain_intention. The result in the folder is from the InitialPhrase_Experiment.py
        if "CodeLlama-34b-Instruct" in model_path:
            self.model_name = 'CodeLlama'  # CodeLlama
        elif "CodeFuse-CodeLlama" in model_path:
            self.model_name = "CodeFuse"
        elif "gpt-3.5-turbo" in  model_path:
            self.model_name = "gpt3"
            
        self.C_GeneratedTest_Path = os.path.join(current_dir,'Contain_intention',self.model_name, 'GeneratedTest')
        self.C_LogINFO_Path = os.path.join(current_dir,'Contain_intention',self.model_name, 'LogINFO')
        self.C_Surefire_reports_Path = os.path.join(current_dir, 'Contain_intention', self.model_name,'Surefire_reports')
        self.pred_1 = os.path.join(current_dir, "Contain_intention", self.model_name, 'result_1.json')

        # Path in iterate.
        dir_Name = "Iterate"
        self.original_java_PATH = os.path.join(current_dir, dir_Name, self.model_name , 'original_java')
        self.LogINFO_PATH = os.path.join(current_dir, dir_Name, self.model_name, 'LogINFO')
        self.Surefire_reports_dest_path = os.path.join(current_dir, dir_Name, self.model_name, 'Surefire_reports')
        self.GeneratedTest_PATH = os.path.join(current_dir, dir_Name, self.model_name, 'GeneratedTest')
        self.RepairProcess = os.path.join(current_dir, dir_Name, self.model_name, 'RepairProcess')
        self.Final_result = os.path.join(current_dir, dir_Name, self.model_name, 'final_result.json')
    
        self.repairCompile_result = os.path.join(current_dir, dir_Name, self.model_name, 'RepairCompile.json')
        self.repairTest_result = os.path.join(current_dir, dir_Name, self.model_name,'RepairTest.json')

        self.boolean(self.original_java_PATH)
        self.boolean(self.LogINFO_PATH)
        self.boolean(self.Surefire_reports_dest_path)
        self.boolean(self.GeneratedTest_PATH)
        self.boolean(self.RepairProcess)

        self.unit_instance = Unit(model_path) # class instance

        self.LoadFile()

    def boolean(self, file_path):
        if not os.path.exists(file_path):
            print('Creat floder....')
            os.makedirs(file_path)
        else:
            shutil.rmtree(file_path)
            os.makedirs(file_path)
    def LoadFile(self):

        # with open(self.repairCompile_result,'r', encoding='utf-8') as f:
        #     dealed_compile = f.read()

        # with open(self.repairTest_result,'r', encoding='utf-8') as f:
        #     dealed_Test = f.read()


        with open(self.pred_1,'r',encoding='utf-8') as f:
            pre_cont = json.load(f)

        self.count = 0
        for con in tqdm(pre_cont):
            generated_path = con['generated_path']
            ori_test_Path = con['original_path']


            self.DriveTest_Info(ori_test_Path) # initial: self.Junit_Version; self.Import_Stat_INFO; self.PL_Focal_Method, self.focal_method_name

            GenJava = os.path.basename(generated_path)
            with open(generated_path,'r', encoding='utf-8') as f:
                FixGencont = f.read()
            compile_logInfo_path = [file for file in glob.glob(self.C_LogINFO_Path + '/*') if os.path.basename(file) == GenJava][0]
            Surefire_reports_dst_file = [file for file in glob.glob(self.C_Surefire_reports_Path + '/*') if GenJava.replace(".java",'.xml') in os.path.basename(file)]
            if len(Surefire_reports_dst_file)  == 0: Surefire_reports_dst_file=['None']

            Compile_result = con['Compile']
            Test_result = con['Test']
            if Compile_result == 1 and Test_result == 1: 
                with open(self.Final_result, "a", encoding="utf-8") as f:
                    json.dump(con, f, indent=2)
                    f.write(",\n")
                continue


            repairTag = ""
            if Compile_result == 0:
                repairTag = "compileRepair"
            elif Compile_result == 1 and Test_result == 0:
                repairTag = "testRepair"

            project_name = ori_test_Path.split("###")[0]
            self.count = self.count +1

            print(f"Deal: {self.count}; repairTag: {repairTag}; ", ori_test_Path)
            try:
                Composit_prompt, proc_compile_list_INFO, proc_test_list_INFO = self.Collect_Info(Compile_result,
                                                                                                 Test_result,
                                                                                                 compile_logInfo_path,
                                                                                                 Surefire_reports_dst_file[0],
                                                                                                 generated_path,
                                                                                                 ori_test_Path)

                if (len(proc_compile_list_INFO) == 0 and len(proc_test_list_INFO) == 0) or len(Composit_prompt) == 0:
                    raise Exception ("No information in proc_compile_list_INFO and proc_test_list_INFO")

                excute_path = os.path.join(self.testedRepo_PATH, project_name)
                os.chdir(excute_path)
                os.system('git commit -m "REPO" > /dev/null')
                os.chdir(current_dir)

                self.IteratePred(repairTag, FixGencont, Composit_prompt, ori_test_Path,os.path.basename(generated_path).replace(".java",""))

            except Exception as e:
                # 这里
                traceback.print_exc()
                print(f"Failed: {self.count}; repairTag: {repairTag}; ", ori_test_Path)

            finally:
                # reset repo status
                excute_path = os.path.join(self.testedRepo_PATH, project_name)
                os.chdir(excute_path)
                git_command = "git add .&& git stash"
                os.system(git_command)
                print("Reset Success!")
                os.chdir(current_dir)



    def DriveTest_Info(self,ori_test_Path):
        with open(applicationValid_100_PATH, 'r', encoding='utf-8') as f:
            data_pair = json.load(f)
        self.Under_test_method_INFO = [data["Under_test_method"] for data in data_pair if data["Test_method"]["project_path"] == ori_test_Path][0]
        self.Junit_version = self.Under_test_method_INFO['Junit_version']


        Focal_class = self.Under_test_method_INFO['Class_declaration']
        Filed = self.unit_instance.commentDelete(self.Under_test_method_INFO['Filed']) + "\n"
        constructors = self.unit_instance.commentDelete(self.Under_test_method_INFO['constructors']) + "\n"
        self.Focal_Method_Info = self.unit_instance.commentDelete(self.Under_test_method_INFO["Method_body"])
        PL_Focal_Method = Focal_class + '\n' + Filed + constructors + '\n' + '//Focal method\n' + self.Focal_Method_Info + "\n}"
        self.PL_Focal_Method = '\n'.join(filter(lambda x: x.strip(), PL_Focal_Method.split('\n')))
        self.focal_method_name = self.Under_test_method_INFO['Method_statement']

        self.Import_Stat_INFO = [data['Test_method']["all_Import_statements"] for data in data_pair if data["Test_method"]["project_path"] == ori_test_Path][0].replace("\n\n","\n")


    def IteratePred(self,repairTag, FixGencont, Composit_prompt, ori_test_Path, fixedClassName):
        TAG = "TEST"
        error_numbers = []
        TotalIter = 0
        iter = 0
        IterCompile, IterTest = 1, 0
        while True:

            print(f'----------------{ori_test_Path}----------------')
            print(Composit_prompt)
            Out_Txtdir = os.path.join(self.RepairProcess,
                                      os.path.basename(ori_test_Path.split("###")[1]) + "_" +
                                      ori_test_Path.split("###")[-1] + "_prompt.txt")
            with open(Out_Txtdir, 'a', encoding='utf-8') as f:
                f.write(
                    f"{TotalIter}-->{IterCompile | IterTest}-->{iter}-->{repairTag}\n" + Composit_prompt + "\n\n########\n\n")
            print(f'-----------------------------------------------')

            TotalIter = TotalIter + 1
            pattern = re.compile(r'//\s*original\s+test\s+path:\s*[\S\s]*?\n')
            Composit_prompt = pattern.sub('', Composit_prompt)

            code_list = self.unit_instance.method_pred_unit(Composit_prompt, True)
            Gen_testMethod = code_list[-1]
            if len(code_list) > 1 and "import " in code_list[0] and "public " not in code_list[0]:
                self.Import_Stat_INFO  = self.Import_Stat_INFO + "\n" + code_list[0]

            gen_test_PATH, gen_test_cont, package_name = self.file_write(Gen_testMethod, ori_test_Path, fixedClassName)
            if not os.path.exists(gen_test_PATH): raise FileNotFoundError("GeneratedTest file does not exist")
          

            # return compile/test result, and processed excute_INFO
            compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file = self.adhoc_excute(gen_test_PATH,
                                                                                                             gen_test_cont,
                                                                                                             ori_test_Path,
                                                                                                             self.testedRepo_PATH,
                                                                                                             self.Junit_version,
                                                                                                             package_name)
            # error number
            with open(compile_logInfo_path, 'r',encoding='utf-8') as f:
                copile_info = f.read()
            number_match = re.search(r'\d+ error', copile_info)
            errors = 0
            if number_match:
                errors = int(number_match.group(0).replace(" error",""))

            if repairTag == "testRepair" and compile_result==0:
                gen_test_PATH, gen_test_cont, package_name = self.file_write(FixGencont, ori_test_Path,fixedClassName)
                IterTest = IterTest + 1

            if repairTag =="compileRepair":
                outDict = {"count":self.count,
                           "original_path":ori_test_Path, "generated_path":gen_test_PATH,
                           "Compile":f"TotalIter:{TotalIter}-->IterCompile:{IterCompile}-->Non_iter:{iter}",
                           "repairTag": repairTag,
                           "Compile_result":compile_result, "Test_result": test_result,
                           "CompileError_number":errors}
                with open(self.repairCompile_result, "a", encoding="utf-8") as f:
                    json.dump(outDict, f, indent=2)
                    f.write(",\n")

                if compile_result == 1 and test_result == 1: 
                    con = {"original_path":ori_test_Path,
                           "generated_path": gen_test_PATH,
                           "Compile": gen_test_PATH,
                           "Test": test_result,
                           "Compile_result":compile_result}
                    with open(self.Final_result, "a", encoding="utf-8") as f:
                        json.dump(con, f, indent=2)
                        f.write(",\n")
                    break

                if compile_result == 0:
                    IterCompile = IterCompile + 1
                    error_numbers.append(errors)
                    if len(error_numbers) >= 2 and error_numbers[-1] >= error_numbers[-2]:
                        iter = iter + 1
                elif compile_result==1 and test_result==0:
                    TAG = "COMPILE>TEST"
                    repairTag = "testRepair"

            if repairTag == "testRepair":
                outDict = {"count":self.count,
                           "original_path": ori_test_Path, "generated_path": gen_test_PATH,
                           "Test": f"TotalIter:{TotalIter}-->IterCompile:{IterTest}-->TAG:{TAG}",
                           "repairTag": repairTag,
                           "Compile_result":compile_result, "Test_result": test_result}

                with open(self.repairTest_result, "a", encoding="utf-8") as f:
                    json.dump(outDict, f, indent=2)
                    f.write(",\n")
                if compile_result == 1 and test_result == 1: 
                    con = {"original_path":ori_test_Path,
                           "generated_path": gen_test_PATH,
                           "Compile": gen_test_PATH,
                           "Test": test_result,
                           "Compile_result":compile_result}
                    with open(self.Final_result, "a", encoding="utf-8") as f:
                        json.dump(con, f, indent=2)
                        f.write(",\n")
                    break
                elif compile_result == 1 and test_result == 0:
                    IterTest = IterTest + 1

            if iter > 3 or IterTest > 5 or TotalIter > 30:
                con = {"original_path":ori_test_Path,
                        "generated_path": gen_test_PATH,
                        "Compile": gen_test_PATH,
                        "Test": test_result,
                        "Compile_result":compile_result}
                with open(self.Final_result, "a", encoding="utf-8") as f:
                    json.dump(con, f, indent=2)
                    f.write(",\n")
                break

            Composit_prompt, proc_compile_list_INFO, proc_test_list_INFO = self.Collect_Info(compile_result,
                                                                                             test_result,
                                                                                             compile_logInfo_path,
                                                                                             Surefire_reports_dst_file,
                                                                                             gen_test_PATH, ori_test_Path)




    def file_write(self, test_method, ori_test_Path, fixedClassName):

        test_method_list = test_method.split("\n")
        test_methods = [method for method in test_method_list if "package " not in method and "import " not in method]
        
        
        ext_import = [method for method in test_method_list if "import " in method and method not in self.Import_Stat_INFO]
        self.Import_Stat_INFO  = self.Import_Stat_INFO + "\n" + "\n".join(ext_import)
        
        test_method = "\n".join(test_methods)
        Out_dir = self.GeneratedTest_PATH
        pattern = re.compile(r'package\s+[\w\.]+\s*;')
        test_method = pattern.sub('', test_method)
        test_method = self.unit_instance.commentDelete(test_method)
        ori_test_method_name = ori_test_Path.split("###")[-1]
        if "/java/" in ori_test_Path:
            package_name = ".".join(ori_test_Path.split("###")[1].split("/java/")[1].split("/")[:-1])
        elif "/java_generated/" in ori_test_Path:
            package_name = ".".join(ori_test_Path.split("###")[1].split("/java_generated/")[1].split("/")[:-1])
        else:
            package_name = ""

        try:
            class_start_idx = test_method.index("class ") + len("class ")
            class_name = test_method[class_start_idx:].split()[0]

            if "public" not in test_method[:class_start_idx].strip():
                test_method = "public " + test_method
        except:
            class_name = ""

        if len(class_name) == 0:
            if len(fixedClassName) == 0:
                file_name = "TTT" + "_" + ori_test_method_name
                write_cont = "package " + package_name + ";\n" + self.Import_Stat_INFO + "\n" +\
                             "// original test path: " + ori_test_Path + "\n" + \
                             "public class " + file_name + " {\n" + test_method + "\n}"

            else:
                file_name = fixedClassName
                write_cont = "package " + package_name + ";\n" + self.Import_Stat_INFO + "\n" +  \
                             "// original test path: " + ori_test_Path + "\n" + \
                             "public class " + file_name + " {\n" + test_method + "\n}"

        else:
            if len(fixedClassName)>0:
                file_name = fixedClassName
                pattern = re.compile(f"(?<![a-zA-Z]){class_name}|{class_name}(?![a-zA-Z])")
                write_code = pattern.sub(file_name, test_method)

                write_cont = "package " + package_name + ";\n"  + self.Import_Stat_INFO + "\n" + \
                             "// original test path: " + ori_test_Path + "\n" + \
                             write_code

            else:
                file_name = class_name + "_" + ori_test_method_name
                pattern = re.compile(f"(?<![a-zA-Z]){class_name}|{class_name}(?![a-zA-Z])")
                write_code = pattern.sub(file_name, test_method)
                write_cont = "package " + package_name + ";\n"  + self.Import_Stat_INFO + "\n" + \
                             "// original test path: " + ori_test_Path + "\n" + \
                             write_code


        write_cont = write_cont.replace("\nNote:", "// Note:")
        write_cont = "\n".join([line for line in write_cont.split("\n") if line.strip()])

        target_PATH = os.path.join(Out_dir, file_name + '.java')
        with open(target_PATH, 'w', encoding='utf-8') as f:
            f.write(write_cont)

        return target_PATH, write_cont, package_name

    def adhoc_excute(self, gen_test_PATH, gen_test_cont, ori_test_Path, testedRepo_PATH, JUNIT_VERSION, package_name):

        pro_name = ori_test_Path.split("###")[0]
        sub_project_name = ori_test_Path.split("###")[1].replace(pro_name, "").split("/src/")[0]
        if sub_project_name == "":
            sub_project_name = ""
        else:
            sub_project_name = "." + sub_project_name


        gen_class_name = os.path.basename(gen_test_PATH).replace(".java", "")
        ori_class_name = os.path.basename(ori_test_Path.split("###")[1])

        pro_test_path = ori_test_Path.split("###")[1] + ".java"
        ori_PATH = os.path.join(testedRepo_PATH, pro_test_path)
        if not os.path.exists(os.path.join(self.original_java_PATH, os.path.basename(ori_PATH))):
            shutil.copy(ori_PATH,self.original_java_PATH)

        # step2
        self.Test_to_project(gen_class_name, ori_class_name, gen_test_cont, ori_PATH)

        # step3
        compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file = self.Compile_Test_unit(pro_name,
                                                                                                         sub_project_name,
                                                                                                         gen_test_PATH,
                                                                                                         ori_test_Path,
                                                                                                         package_name + "." + ori_class_name,
                                                                                                         JUNIT_VERSION)

        proc_compile_list_INFO, proc_test_list_INFO, Composit_prompt = "", "",""

        if compile_result != 1:

            compile_instance = Compile_Test_INFO.CompileInfo(compile_logInfo_path, self.Import_Stat_INFO, self.model_name)
            proc_compile_list_INFO = compile_instance.Call_errorDeal()

            class_instance = FeedbackPrompt.CompilePrompt(proc_compile_list_INFO[0], gen_test_PATH,
                                                          ori_test_Path.split("###")[0])
            Composit_prompt = class_instance.Compile_deal()


        if compile_result == 1 and test_result != 1:
            test_instance = Compile_Test_INFO.TestINFO(Surefire_reports_dst_file, compile_logInfo_path)
            proc_test_list_INFO = test_instance.TetsINFO_deal()
            Method_intention = ""
            class_instance = FeedbackPrompt.TestPrompt(proc_test_list_INFO[0], gen_test_PATH, Method_intention, self.Focal_Method_Info, self.focal_method_name)
            Composit_prompt = class_instance.Test_deal()

        if len(proc_compile_list_INFO) == 0 and len(proc_test_list_INFO) == 0:
            print("No information in proc_compile_list_INFO and proc_test_list_INFO")

        return compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file



    def Collect_Info(self, compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file, gen_test_PATH, ori_test_Path):
        proc_compile_list_INFO, proc_test_list_INFO, Composit_prompt = "", "",""
        if compile_result == 0:
            #Out_dict = {"ERROR_MESSAGE": str, "Class_Name": str, "ERROR_LINE": str}
            compile_instance = Compile_Test_INFO.CompileInfo(compile_logInfo_path, self.Import_Stat_INFO, self.model_name)
            proc_compile_list_INFO = compile_instance.Call_errorDeal()

            # Error_INFO_dict, Gen_Java_File, repo_name
            class_instance = FeedbackPrompt.CompilePrompt(proc_compile_list_INFO[0], gen_test_PATH,
                                                          ori_test_Path.split("###")[0])
            Composit_prompt = class_instance.Compile_deal()


        if compile_result == 1 and test_result == 0:
            # TEST_INFO_dict = {"FILE_NAME":os.path.basename(xml_file_path), "ERROR_MESSAGE":str, "ERROR_LINE":str}
            test_instance = Compile_Test_INFO.TestINFO(Surefire_reports_dst_file, compile_logInfo_path)
            proc_test_list_INFO = test_instance.TetsINFO_deal()
            # self.unit_instance.intention_unit(self.PL_Focal_Method, self.focal_method_name)
            Method_intention = ""
            class_instance = FeedbackPrompt.TestPrompt(proc_test_list_INFO[0], gen_test_PATH, Method_intention, self.Focal_Method_Info, self.focal_method_name)
            Composit_prompt = class_instance.Test_deal()

        if len(proc_compile_list_INFO) == 0 and len(proc_test_list_INFO) == 0:
            print("No information in proc_compile_list_INFO and proc_test_list_INFO")

        return Composit_prompt, proc_compile_list_INFO, proc_test_list_INFO



    def Test_to_project(self, gen_class_name, ori_class_name, gen_test_cont, ori_PATH):
        pattern = re.compile(f"(?<![a-zA-Z]){gen_class_name}|{gen_class_name}(?![a-zA-Z])")
        changed_code = pattern.sub(ori_class_name, gen_test_cont)
        with open(ori_PATH, 'w', encoding='utf-8') as f:
            f.write(changed_code)
        

    def Compile_Test_unit(self, pro_name, sub_project_name, test_file_name, test_path, Dtest_para, JUNIT_VERSION):
        excute_path = os.path.join(self.testedRepo_PATH, pro_name)
        os.chdir(excute_path)
        if sub_project_name != "":
            mvn_compile = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test-compile',
                           '-Dcheckstyle.skip=true']
            mvn_test = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test',
                        '-Dcheckstyle.skip=true']
            if JUNIT_VERSION == 5:
                mvn_compile = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test-compile',
                               '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']
                mvn_test = ['mvn', '-pl', sub_project_name, f'-Dtest={Dtest_para}', 'test',
                            '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']

        else:
            mvn_compile = ['mvn', f'-Dtest={Dtest_para}', 'test-compile', '-Dcheckstyle.skip=true']
            mvn_test = ['mvn', f'-Dtest={Dtest_para}', 'test', '-Dcheckstyle.skip=true']
            if JUNIT_VERSION == 5:
                mvn_compile = ['mvn', f'-Dtest={Dtest_para}', 'test-compile',
                               '-Dtest.engine=junit-jupiter', '-Dcheckstyle.skip=true']
                mvn_test = ['mvn', f'-Dtest={Dtest_para}', 'test', '-Dtest.engine=junit-jupiter',
                            '-Dcheckstyle.skip=true']

        write_cont, compile_result, test_result = self.Compile_Test_sub_unit(mvn_compile, mvn_test, test_path)

        # 未能正确的执行mvn 指令。此时首先需要执行 mvn clean
        if compile_result != 1 and "[ERROR] COMPILATION ERROR :" not in write_cont and "Could not resolve dependenci" in write_cont:
            mvn_install = [ 'mvn', 'clean', 'install']
            mvn_result = subprocess.run(mvn_install, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                        universal_newlines=True)
            if "BUILD SUCCESS" in mvn_result.stdout or "BUILD SUCCESS" in mvn_result.stderr:
                write_cont, compile_result, test_result = self.Compile_Test_sub_unit(mvn_compile, mvn_test, test_path)
            else:
                # 进入到子目录当中
                target_PATH = os.path.join(excute_path, sub_project_name)
                os.chdir(target_PATH)
                write_cont, compile_success, test_result = self.Compile_Test_sub_unit(mvn_compile, mvn_test, test_path)
        os.chdir(current_dir)

        if compile_result == 0 and "[ERROR] COMPILATION ERROR :" not in write_cont: raise Exception(
            "Mvn execute failed")
        compile_logInfo_path = os.path.join(self.LogINFO_PATH, os.path.basename(test_file_name))
        with open(compile_logInfo_path, 'w', encoding='utf-8') as f:
            f.write(write_cont)

        #  execute mvn test and save file to ./target/Surefire_reports/*
        Surefire_reports_dst_file = self.Surefire_reports_TEST_info(write_cont, test_file_name, Dtest_para)

        return compile_result, test_result, compile_logInfo_path, Surefire_reports_dst_file

    def Compile_Test_sub_unit(self, mvn_compile, mvn_test, test_path):
        compile_success, test_success = 0, 0
        compile_result = subprocess.run(mvn_compile, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                        universal_newlines=True)
        write_cont = "original test path: " + test_path + "\n########## Compile INFO ##########\n" + compile_result.stdout + compile_result.stderr

        if "BUILD SUCCESS" in compile_result.stdout or "BUILD SUCCESS" in compile_result.stderr:
            compile_success = 1

            test_result = subprocess.run(mvn_test, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                         universal_newlines=True)
            write_cont = "original test path: " + test_path + "\n########## Compile INFO ##########\n" + compile_result.stdout + compile_result.stderr + \
                         "\n########## Test INFO ##########\n" + test_result.stdout + test_result.stderr

            if "BUILD SUCCESS" in test_result.stdout or "BUILD SUCCESS" in test_result.stderr:
                test_success = 1

        return write_cont, compile_success, test_success

    def Surefire_reports_TEST_info(self, INFO_CONT, test_file_name, Dtest_para):
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
            shutil.copy(src_path, self.Surefire_reports_dest_path)
            Surefire_reports_dst_file = os.path.join(self.Surefire_reports_dest_path, os.path.basename(src_path))
            os.rename(Surefire_reports_dst_file, os.path.join(self.Surefire_reports_dest_path, file_name))
            Surefire_reports_dst_file = os.path.join(self.Surefire_reports_dest_path, file_name)
        return Surefire_reports_dst_file


class Unit:
    def __init__(self, model_path) -> None:
        self.tokenizer = AutoTokenizer.from_pretrained(model_path, use_fast=False)
        self.model = AutoModelForCausalLM.from_pretrained(model_path, low_cpu_mem_usage=True, torch_dtype=torch.float16).cuda()

        if "CodeLlama" in model_path:
            B_INST, E_INST = "[INST]", "[/INST]"
            B_SYS, E_SYS = "<<SYS>>\n", "\n<</SYS>>\n\n"

            system_prompt = '''
            You are a helpful, respectful and honest assistant with a deep knowledge of code and software design. Always answer as helpfully as possible, while being safe. Your answers should not include any harmful, unethical, racist, sexist, toxic, dangerous, or illegal content. Please ensure that your responses are socially unbiased and positive in nature.
            If a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct. If you don't know the answer to a question, please don't share false information.
            '''
            system_prompt = f"{B_SYS}{system_prompt}{E_SYS}"
            self.problem_prompt = (system_prompt + "[INST] {instruction} [/INST]")
        elif "codeFuse" in model_path:
            HUMAN_ROLE_START_TAG = "<|role_start|>human<|role_end|>"
            BOT_ROLE_START_TAG = "<|role_start|>bot<|role_end|>"
            self.problem_prompt = (HUMAN_ROLE_START_TAG + "{instruction}" + BOT_ROLE_START_TAG)


        
    def generate(self, prompt):
        input_ids = self.tokenizer([prompt]).input_ids
        output_ids = self.model.generate(
            torch.as_tensor(input_ids).cuda(), max_new_tokens=1024, max_length = 2048
        )
        output_ids = output_ids[0][len(input_ids[0]) :]
        outputs = self.tokenizer.decode(output_ids, skip_special_tokens=True).strip()
        return outputs

    def method_pred_unit(self, ask_test_method_prompt, repair_TAG):

        if repair_TAG:
            if "gpt-3.5" in model_path:
                response_test = openai.ChatCompletion.create(
                    model=model_path,
                    messages=[
                        {"role": "system",
                         "content": "I want you to play the role of a professional who repairs buggy lines of the test method. Unnecessary import statement can be removed."},
                        {"role": "user", "content": ask_test_method_prompt},
                    ],
                    temperature=0)
                generated_content = response_test.choices[0].message['content']
            else:
                role = "I want you to play the role of a professional who repairs buggy lines of the test method."
                instruction = role + '\n\n' + ask_test_method_prompt
                prompt = self.problem_prompt.format(instruction=instruction)
                generated_content = self.generate(prompt)

        else:
            if "gpt-3.5" in model_path:
                response_test = openai.ChatCompletion.create(
                    model=model_path,
                    messages=[
                        {"role": "system",
                         "content": "I want you to play the role of a professional who writes Java test method."},
                        {"role": "user", "content": ask_test_method_prompt},
                    ],
                    temperature=0)
                generated_content = response_test.choices[0].message['content']

            else:
                role = "I want you to play the role of a professional who writes Java test method for the Focal method. The following is the Class, Focal method and Import information."
                instruction = role + '\n\n' + ask_test_method_prompt
                prompt = self.problem_prompt.format(instruction=instruction)
                generated_content = self.generate(prompt)
        

        test_method = self.return_code(generated_content)
        return test_method



    def return_code(self, gen_cont):
        gen_cont = '\n'.join([line for line in gen_cont.split('\n') if "Below is " not in line])
        gen_cont = gen_cont.replace("(Fixed)","").replace("java\r\n","").replace("...","").replace("java\n","").replace("Java\n","")
        code_list = []
        # find code
        pattern = r"```(.*?)```(?![\w\d])"
        matches = re.findall(pattern, gen_cont, re.DOTALL)
        for match in matches:
            code_list.append(match.strip().replace("```",""))
        if len(code_list) == 0 and ("}\n}" in gen_cont or "}\n\n}" in gen_cont):
            generated_content = gen_cont.split("// Test Method")[-1]
            if "}\n}" in generated_content:
                Pos = generated_content.rfind("}\n}")
                Code = generated_content[:Pos + len("}\n}")]
                Code = Code.replace("\nNote:", "// Note:").replace("```","")
                code_list.append(Code)
            elif "}\n\n}" in generated_content:
                Pos = generated_content.rfind("}\n\n}")
                Code = generated_content[:Pos + len("}\n\n}")]
                Code = Code.replace("\nNote:", "// Note:").replace("```","")
                code_list.append(Code)
        if len(code_list) == 0: raise ValueError("No Test method generated\n" + generated_content)

        return code_list

    # input:ori_test_Path, output method intention
    def intention_unit(self, PL_Focal_Method, focal_method_name):
        
        Intention_NL = f'Please describe the intention of the {focal_method_name} method in one sentence.'
        ask_intention_prompt = PL_Focal_Method + '\n\n' + Intention_NL

        role = "I want you to play the role of a professional who infers method intention."
        Intention_NL = f'Please tell me the intention of the {focal_method_name} method.'
        ask_intention_prompt = PL_Focal_Method + '\n\n' + Intention_NL
        instruction = role + '\n\n' + ask_intention_prompt

        prompt = self.problem_prompt.format(instruction=instruction)
        if "gpt-3.5" in model_path:
            response_intention = openai.ChatCompletion.create(
                model=model_path,
                messages=[
                    {"role": "system",
                     "content": "I want you to play the role of a professional who infers method intention."},
                    {"role": "user", "content": ask_intention_prompt},
                ],
                temperature=0
            )
            intentions = response_intention.choices[0].message['content']
        else:
            intentions = self.generate(prompt)

        intentions = " ".join(intentions.split())
        # intention = re.split('(?<=[.!?]) +', intentions)
        return intentions

    def commentDelete(self, code):
        # comment delete
        regex = r"/\*(.|\\n)*?\*/"
        noMultilineComments = re.sub(regex, "", code)

        # remove single line comments (// ...)
        regex = r"//.*"
        non_comment_code = re.sub(regex, "", noMultilineComments)

        pattern = re.compile(r"(?s)/\*.*?\*/|//.*?[\r\n]")  # 匹配 /**...*/ 样式的注释
        codeWithoutComment = pattern.sub("", non_comment_code)  # 去除注释

        return codeWithoutComment
    
if __name__ == "__main__":
    import sys
    
    sys.stdout = open(log_file, 'a')
    sys.stderr = open(log_file, 'a')

    ChatGptTester()