original test path: lazee_meteo###lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest###testFromCoordinates
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< no.api.meteo:meteo-core >-----------------------
[INFO] Building meteo-core 3.1.3-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ meteo-core ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ meteo-core ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ meteo-core ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ meteo-core ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 16 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[8,22] constructor Location in class no.api.meteo.entity.core.Location cannot be applied to given types;
  required: java.lang.Double,java.lang.Double,java.lang.Integer,java.lang.String
  found: double,double
  reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[9,22] constructor Location in class no.api.meteo.entity.core.Location cannot be applied to given types;
  required: java.lang.Double,java.lang.Double,java.lang.Integer,java.lang.String
  found: double,double,int
  reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[10,9] cannot find symbol
  symbol:   method assertThrows(java.lang.Class<java.lang.IllegalArgumentException>,()->Locati[...]null))
  location: class no.api.meteo.entity.core.LocationTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[11,9] cannot find symbol
  symbol:   method assertThrows(java.lang.Class<java.lang.IllegalArgumentException>,()->Locati[...]put"))
  location: class no.api.meteo.entity.core.LocationTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[12,9] cannot find symbol
  symbol:   method assertThrows(java.lang.Class<java.lang.IllegalArgumentException>,()->Locati[...]abc"))
  location: class no.api.meteo.entity.core.LocationTest
[INFO] 5 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.750 s
[INFO] Finished at: 2023-09-24T06:08:36Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project meteo-core: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[8,22] constructor Location in class no.api.meteo.entity.core.Location cannot be applied to given types;
[ERROR]   required: java.lang.Double,java.lang.Double,java.lang.Integer,java.lang.String
[ERROR]   found: double,double
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[9,22] constructor Location in class no.api.meteo.entity.core.Location cannot be applied to given types;
[ERROR]   required: java.lang.Double,java.lang.Double,java.lang.Integer,java.lang.String
[ERROR]   found: double,double,int
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[10,9] cannot find symbol
[ERROR]   symbol:   method assertThrows(java.lang.Class<java.lang.IllegalArgumentException>,()->Locati[...]null))
[ERROR]   location: class no.api.meteo.entity.core.LocationTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[11,9] cannot find symbol
[ERROR]   symbol:   method assertThrows(java.lang.Class<java.lang.IllegalArgumentException>,()->Locati[...]put"))
[ERROR]   location: class no.api.meteo.entity.core.LocationTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/lazee_meteo/meteo-core/src/test/java/no/api/meteo/entity/core/LocationTest.java:[12,9] cannot find symbol
[ERROR]   symbol:   method assertThrows(java.lang.Class<java.lang.IllegalArgumentException>,()->Locati[...]abc"))
[ERROR]   location: class no.api.meteo.entity.core.LocationTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
