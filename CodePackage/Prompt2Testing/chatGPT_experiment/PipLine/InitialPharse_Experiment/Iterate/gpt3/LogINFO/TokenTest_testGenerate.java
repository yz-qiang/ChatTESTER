original test path: l0s_fernet-java8###l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest###testGenerate
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[INFO] 
[INFO] ------------------< com.macasaet.fernet:fernet-java8 >------------------
[INFO] Building Fernet Java 1.5.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ fernet-java8 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\l0s_fernet-java8\fernet-java8\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ fernet-java8 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ fernet-java8 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ fernet-java8 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 19 source files to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\l0s_fernet-java8\fernet-java8\target\test-classes
[INFO] -------------------------------------------------------------
[WARNING] COMPILATION WARNING : 
[INFO] -------------------------------------------------------------
[WARNING] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/example/pb/Example.java: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\l0s_fernet-java8\fernet-java8\src\test\java\com\macasaet\fernet\example\pb\Example.java uses or overrides a deprecated API.
[WARNING] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/example/pb/Example.java: Recompile with -Xlint:deprecation for details.
[WARNING] Some messages have been simplified; recompile with -Xdiags:verbose to get full output
[INFO] 3 warnings 
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest.java:[14,14] type com.macasaet.fernet.Token does not take parameters
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest.java:[14,36] no suitable method found for generate(java.security.Key,byte[])
    method com.macasaet.fernet.Token.generate(com.macasaet.fernet.Key,java.lang.String) is not applicable
      (argument mismatch; java.security.Key cannot be converted to com.macasaet.fernet.Key)
    method com.macasaet.fernet.Token.generate(com.macasaet.fernet.Key,byte[]) is not applicable
      (argument mismatch; java.security.Key cannot be converted to com.macasaet.fernet.Key)
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest.java:[16,27] cannot find symbol
  symbol:   variable supportedVersion
  location: class com.macasaet.fernet.Token
[INFO] 3 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.599 s
[INFO] Finished at: 2023-04-28T23:21:58+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project fernet-java8: Compilation failure: Compilation failure: 
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest.java:[14,14] type com.macasaet.fernet.Token does not take parameters
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest.java:[14,36] no suitable method found for generate(java.security.Key,byte[])
[ERROR]     method com.macasaet.fernet.Token.generate(com.macasaet.fernet.Key,java.lang.String) is not applicable
[ERROR]       (argument mismatch; java.security.Key cannot be converted to com.macasaet.fernet.Key)
[ERROR]     method com.macasaet.fernet.Token.generate(com.macasaet.fernet.Key,byte[]) is not applicable
[ERROR]       (argument mismatch; java.security.Key cannot be converted to com.macasaet.fernet.Key)
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest.java:[16,27] cannot find symbol
[ERROR]   symbol:   variable supportedVersion
[ERROR]   location: class com.macasaet.fernet.Token
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en
