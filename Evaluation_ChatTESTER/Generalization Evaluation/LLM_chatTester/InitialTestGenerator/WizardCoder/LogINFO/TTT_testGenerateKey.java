original test path: l0s_fernet-java8###l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest###testGenerateKey
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
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/main/resources
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
[INFO] Compiling 19 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/target/test-classes
[INFO] -------------------------------------------------------------
[WARNING] COMPILATION WARNING : 
[INFO] -------------------------------------------------------------
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/example/pb/Example.java: /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/example/pb/Example.java uses or overrides a deprecated API.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/example/pb/Example.java: Recompile with -Xlint:deprecation for details.
[WARNING] Some messages have been simplified; recompile with -Xdiags:verbose to get full output
[INFO] 3 warnings 
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[32,53] incompatible types: possible lossy conversion from double to long
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[38,82] incompatible types: void cannot be converted to nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[39,35] cannot find symbol
  symbol:   method isSuccessful()
  location: variable verifierAPI of type nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[40,34] cannot find symbol
  symbol:   variable Duration
  location: class com.macasaet.fernet.KeyTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[41,54] cannot find symbol
  symbol:   variable keySizeBits
  location: class com.macasaet.fernet.KeyTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[42,12] cannot find symbol
  symbol:   class DecimalFormat
  location: class com.macasaet.fernet.KeyTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[42,35] cannot find symbol
  symbol:   class DecimalFormat
  location: class com.macasaet.fernet.KeyTest
[INFO] 7 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.221 s
[INFO] Finished at: 2023-09-24T14:56:12Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project fernet-java8: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[32,53] incompatible types: possible lossy conversion from double to long
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[38,82] incompatible types: void cannot be converted to nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[39,35] cannot find symbol
[ERROR]   symbol:   method isSuccessful()
[ERROR]   location: variable verifierAPI of type nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[40,34] cannot find symbol
[ERROR]   symbol:   variable Duration
[ERROR]   location: class com.macasaet.fernet.KeyTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[41,54] cannot find symbol
[ERROR]   symbol:   variable keySizeBits
[ERROR]   location: class com.macasaet.fernet.KeyTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[42,12] cannot find symbol
[ERROR]   symbol:   class DecimalFormat
[ERROR]   location: class com.macasaet.fernet.KeyTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest.java:[42,35] cannot find symbol
[ERROR]   symbol:   class DecimalFormat
[ERROR]   location: class com.macasaet.fernet.KeyTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
