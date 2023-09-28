# -*- coding: utf-8 -*-
import sys
import json
import re
import os
import xml.etree.ElementTree as ET
import subprocess
import os
import glob
from tqdm import tqdm
# import Compile_Test_INFO

current_dir = os.path.dirname(__file__)  # ./PipLine/Deal
Promt2Testing_PATH = os.path.abspath(os.path.join(current_dir, os.pardir, os.pardir, os.pardir, os.pardir))
Involved_repo_PATH = os.path.join(Promt2Testing_PATH, 'repo_get', "approachValidation_repo")



class CompilePrompt:
    def __init__(self, Error_INFO_dict, Gen_Java_File, repo_name):
        self.Error_INFO_dict = Error_INFO_dict
        self.Gen_Java_File = Gen_Java_File
        self.repo_name = repo_name

    # Input: {"ERROR_MESSAGE": str, "Class_Name": str, "ERROR_LINE": str}
    def Compile_deal(self):
        ERROR_MESSAGE = self.Error_INFO_dict['ERROR_MESSAGE']
        Class_Name = self.Error_INFO_dict['Class_Name']
        ERROR_LINE = self.Error_INFO_dict['ERROR_LINE']
        Import_State = self.Error_INFO_dict['Import_State']

        import_line = 0
        i = 0
        BuggyCode = []
        with open(self.Gen_Java_File, 'r', encoding='utf-8') as f:
            for line in f.readlines():
                i = i + 1
                if "import " in line: import_line = i
                if int(ERROR_LINE) == i:
                    numbe_of_cr = line.count(' ')-2
                    BugInfo = f"<Buggy Line>: {ERROR_MESSAGE}" + '\n'
                    BuggyCode.append("\n")
                    BuggyCode.append(' '*numbe_of_cr+BugInfo)
                    BuggyCode.append(line)
                    BuggyCode.append("\n")

                elif "// original test path:" not in line and "Test Method" not in line and 'Fixed Test Method' not in line:
                    BuggyCode.append(line)

        if len(Class_Name) > 0:
            Class_Name_java = Class_Name + ".java"

            Class_Java_Path = glob.glob(os.path.join(Involved_repo_PATH, self.repo_name, '**/', Class_Name_java),
                                        recursive=True)

            # windows use .;  Linux use .:
            JarPath = os.path.join(Promt2Testing_PATH, 'Java_Analyzer\src\main\jarPackage\javaparser-core-3.24.7.jar')
            classpath = '.:' + JarPath
            if len(Class_Java_Path) == 0: return ""
            arg1 = Class_Java_Path[0]
            arg2 = Class_Name
            ExcuteJava = os.path.join(Promt2Testing_PATH, 'Java_Analyzer\src\main\java')
            os.chdir(ExcuteJava)
            result = subprocess.run(["java", '-cp', classpath, 'PublicInfo_collection.java', arg1, arg2],
                                    stdout=subprocess.PIPE, check=True)
            os.chdir(current_dir)

            PublicINFOs = result.stdout.strip().decode('ascii')
            PublicINFO = commentDelete(PublicINFOs)
            CompileError_fix_Prompt = f"// {Class_Name} class\n" + PublicINFO + "\n\n" + "// Test Method\n" + commentDelete("".join(BuggyCode)) + "\n\n" +\
                f"The test method has a bug error (marked <Buggy Line>). " \
                f"\n Please repair the buggy line with the given \"{Class_Name}\" class information (it is crucial) and return the complete test method after repair. \n" \
                f"Note that the contents in  \"{Class_Name}\" class  cannot be modified."


        elif len(Import_State)>0:
            CompileError_fix_Prompt = f"// Import information\n" + Import_State + "\n\n" +"// Test Method\n" + commentDelete("".join(BuggyCode)) + "\n\n" + \
                                      f"The test method has a bug error (marked <Buggy Line>). \n" \
                                      f"Please repair the buggy line with the given Import information (it is crucial) and return the complete test method after repair."
        else:
            CompileError_fix_Prompt = "// Test Method\n" + commentDelete("".join(BuggyCode)) + "\n\n" + \
                                      f"The test method has a bug error (marked <Buggy Line>). \n Please repair the buggy " \
                                      f"line and return the complete test method after repair."

        return CompileError_fix_Prompt


class TestPrompt():
    def __init__(self, Error_INFO_dict, Gen_Java_File, Method_intention, Focal_Method, Focal_Method_name):
        self.Error_INFO_dict = Error_INFO_dict
        self.Gen_Java_File = Gen_Java_File
        self.Method_intention = Method_intention
        self.Focal_Method = Focal_Method
        self.Focal_Method_name = Focal_Method_name


    # Input: {"ERROR_MESSAGE": str, "Class_Name": str, "ERROR_LINE": str}
    def Test_deal(self):
        ERROR_MESSAGE = self.Error_INFO_dict['ERROR_MESSAGE']
        # Class_Name = self.Error_INFO_dict['Class_Name']
        ERROR_LINE = self.Error_INFO_dict['ERROR_LINE']
        i = 0
        Buggy_line = ""
        allCode = []
        with open(self.Gen_Java_File,'r', encoding='utf-8') as f:
            for line in f.readlines():
                i = i + 1
                if int(ERROR_LINE) == i:
                    Buggy_line = line.strip()
                    allCode.append("\n")
                    allCode.append("<Buggy Line>\n")
                    allCode.append(line)
                    allCode.append("\n")
                elif "// original test path:" not in line and "Test Method" not in line and 'Fixed Test Method' not in line:
                    allCode.append(line)

        intention = re.split('(?<=[.!?]) +', self.Method_intention)[0]
        dealedCode = commentDelete("".join(allCode)).replace("<Buggy Line>\n","<Error Line>\n")
        
        
        TestError_fix_Prompt ="// Test Method (Need to be repaired)\n" + dealedCode + "\n\n" + \
                                "// Focal method (Cannot be modified)\n" + self.Focal_Method + "\n\n" + \
                                f"The test method throw an error \" {ERROR_MESSAGE} \" in \" {Buggy_line} \". "  + "\n"+ \
                                f"Please refer to the code logic of the Focal method to repair the error in the test method, and then return the complete test method after repair. "+\
                                f"Note that adding a try-catch structure to repair the test method and modify the Focal method both are denied."

        return TestError_fix_Prompt


def commentDelete(code):
    # comment delete
    regex = r"/\*(.|\\n)*?\*/"
    noMultilineComments = re.sub(regex, "", code)

    # remove single line comments (// ...)
    regex = r"//.*"
    non_comment_code = re.sub(regex, "", noMultilineComments)

    pattern = re.compile(r"(?s)/\*.*?\*/|//.*?[\r\n]")  # 匹配 /**...*/ 样式的注释
    codeWithoutComment = pattern.sub("", non_comment_code)  # 去除注释

    code = '\n'.join(filter(lambda x: x.strip(), codeWithoutComment.split('\n')))

    out_code = []
    code_list = code.split("\n")
    add_line = []
    for i in range(len(code_list)):
        if i in add_line: continue

        if "<Buggy Line>" in code_list[i]:
            out_code.append("\n")
            out_code.append(code_list[i]+'\n')  # bug info
            out_code.append(code_list[i+1]+'\n') # bug code
            out_code.append("\n")
            add_line.append(i+1)

        else:
            out_code.append(code_list[i]+'\n')

    returnCode = "".join(out_code)

    return returnCode

if __name__ == "__main__":
    pass
