original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[WARNING] The project nl.pvanassen:ns-api:jar:1.1.1 uses prerequisites which is only intended for maven-plugin projects but not for non maven-plugin projects. For such purposes you should use the maven-enforcer-plugin. See https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html
[INFO] 
[INFO] ------------------------< nl.pvanassen:ns-api >-------------------------
[INFO] Building ns-api 1.1.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-enforcer-plugin:1.4.1:enforce (enforce-maven) @ ns-api ---
[INFO] 
[INFO] --- maven-enforcer-plugin:1.4.1:enforce (default-cli) @ ns-api ---
[INFO] Entering enforcer
[INFO] No dependency management found. All ok
[INFO] 
[INFO] --- jacoco-maven-plugin:0.7.4.201502262128:prepare-agent (jacoco-initialize) @ ns-api ---
[WARNING] The artifact xml-apis:xml-apis:jar:2.0.2 has been relocated to xml-apis:xml-apis:jar:1.0.b2
[INFO] argLine set to -javaagent:/home/zqc/.m2/repository/org/jacoco/org.jacoco.agent/0.7.4.201502262128/org.jacoco.agent-0.7.4.201502262128-runtime.jar=destfile=/home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ ns-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ ns-api ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ ns-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 18 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ ns-api ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 9 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[41,33] cannot find symbol
  symbol:   method containsKey(java.lang.String)
  location: variable result of type nl.pvanassen.ns.model.stations.Stations
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[42,43] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[43,48] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[44,57] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[45,64] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[46,41] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[47,46] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[48,48] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[49,46] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[50,38] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[51,64] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[52,41] no suitable method found for get(java.lang.String)
    method java.util.List.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
    method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
      (argument mismatch; java.lang.String cannot be converted to int)
[INFO] 12 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.723 s
[INFO] Finished at: 2023-09-26T17:26:58Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.3:testCompile (default-testCompile) on project ns-api: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[41,33] cannot find symbol
[ERROR]   symbol:   method containsKey(java.lang.String)
[ERROR]   location: variable result of type nl.pvanassen.ns.model.stations.Stations
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[42,43] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[43,48] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[44,57] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[45,64] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[46,41] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[47,46] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[48,48] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[49,46] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[50,38] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[51,64] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest.java:[52,41] no suitable method found for get(java.lang.String)
[ERROR]     method java.util.List.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR]     method nl.pvanassen.ns.model.NsResultListWrapper.get(int) is not applicable
[ERROR]       (argument mismatch; java.lang.String cannot be converted to int)
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException