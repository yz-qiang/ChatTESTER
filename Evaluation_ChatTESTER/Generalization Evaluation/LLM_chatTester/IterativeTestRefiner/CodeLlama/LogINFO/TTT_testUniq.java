original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest###testUniq
########## Compile INFO ##########
[INFO] Scanning for projects...
[WARNING] The project edu.jhu.prim:prim:jar:3.1.5 uses prerequisites which is only intended for maven-plugin projects but not for non maven-plugin projects. For such purposes you should use the maven-enforcer-plugin. See https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html
[INFO] 
[INFO] -------------------------< edu.jhu.prim:prim >--------------------------
[INFO] Building edu.jhu.prim:prim 3.1.5
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- build-helper-maven-plugin:1.1:add-source (add-source) @ prim ---
[INFO] Source directory: /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/main/java_generated added.
[INFO] 
[INFO] --- build-helper-maven-plugin:1.1:add-test-source (add-test-source) @ prim ---
[INFO] Test Source directory: /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java_generated added.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ prim ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ prim ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ prim ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ prim ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 96 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/target/test-classes
[INFO] -------------------------------------------------------------
[WARNING] COMPILATION WARNING : 
[INFO] -------------------------------------------------------------
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/util/math/LogAddTableTest.java: /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/util/math/LogAddTableTest.java uses or overrides a deprecated API.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/util/math/LogAddTableTest.java: Recompile with -Xlint:deprecation for details.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/util/math/AbstractLogAddSubtractTableTest.java: /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/util/math/AbstractLogAddSubtractTableTest.java uses unchecked or unsafe operations.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/util/math/AbstractLogAddSubtractTableTest.java: Recompile with -Xlint:unchecked for details.
[INFO] 4 warnings 
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest.java:[11,13] cannot find symbol
  symbol:   method addAll(java.util.List<java.lang.Long>)
  location: variable list of type edu.jhu.prim.list.LongArrayList
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest.java:[12,13] cannot find symbol
  symbol:   method addAll(java.util.List<java.lang.Long>)
  location: variable list of type edu.jhu.prim.list.LongArrayList
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest.java:[16,29] cannot find symbol
  symbol:   method containsDuplicates()
  location: variable list of type edu.jhu.prim.list.LongArrayList
[INFO] 3 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.630 s
[INFO] Finished at: 2023-09-26T01:31:38Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project prim: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest.java:[11,13] cannot find symbol
[ERROR]   symbol:   method addAll(java.util.List<java.lang.Long>)
[ERROR]   location: variable list of type edu.jhu.prim.list.LongArrayList
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest.java:[12,13] cannot find symbol
[ERROR]   symbol:   method addAll(java.util.List<java.lang.Long>)
[ERROR]   location: variable list of type edu.jhu.prim.list.LongArrayList
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest.java:[16,29] cannot find symbol
[ERROR]   symbol:   method containsDuplicates()
[ERROR]   location: variable list of type edu.jhu.prim.list.LongArrayList
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
