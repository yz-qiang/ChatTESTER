original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/xml/XmlPresentTest###testChild
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
[INFO] argLine set to -javaagent:D:\\repository\\org\\jacoco\\org.jacoco.agent\\0.7.4.201502262128\\org.jacoco.agent-0.7.4.201502262128-runtime.jar=destfile=D:\\Python\\Test_Completion\\Promt2Testing\\repo_get\\approachValidation_repo\\pvanassen_ns-api\\target\\jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ ns-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\pvanassen_ns-api\src\main\resources
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
[INFO] Compiling 9 source files to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\pvanassen_ns-api\target\test-classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.444 s
[INFO] Finished at: 2023-04-28T23:27:44+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en

########## Test INFO ##########
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
[INFO] argLine set to -javaagent:D:\\repository\\org\\jacoco\\org.jacoco.agent\\0.7.4.201502262128\\org.jacoco.agent-0.7.4.201502262128-runtime.jar=destfile=D:\\Python\\Test_Completion\\Promt2Testing\\repo_get\\approachValidation_repo\\pvanassen_ns-api\\target\\jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ ns-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\pvanassen_ns-api\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ ns-api ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ ns-api ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 18 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ ns-api ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.18.1:test (default-test) @ ns-api ---
[INFO] Surefire report directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\pvanassen_ns-api\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running nl.pvanassen.ns.xml.XmlPresentTest
23:27:49.935 [main] DEBUG nl.pvanassen.ns.xml.XmlPresent - Could not find individual child node: nonexistent
23:27:49.941 [main] DEBUG nl.pvanassen.ns.xml.XmlPresent - Could not find individual child node: child
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.301 sec - in nl.pvanassen.ns.xml.XmlPresentTest
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.827 s
[INFO] Finished at: 2023-04-28T23:27:50+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en
