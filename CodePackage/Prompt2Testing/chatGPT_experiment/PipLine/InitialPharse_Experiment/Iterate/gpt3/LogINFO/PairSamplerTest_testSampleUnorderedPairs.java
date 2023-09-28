original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/sample/PairSamplerTest###testSampleUnorderedPairs
########## Compile INFO ##########
[INFO] Scanning for projects...
[WARNING] The project edu.jhu.prim:prim:jar:3.1.5 uses prerequisites which is only intended for maven-plugin projects but not for non maven-plugin projects. For such purposes you should use the maven-enforcer-plugin. See https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html
[INFO] 
[INFO] -------------------------< edu.jhu.prim:prim >--------------------------
[INFO] Building edu.jhu.prim:prim 3.1.5
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- build-helper-maven-plugin:1.1:add-source (add-source) @ prim ---
[INFO] Source directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\main\java_generated added.
[INFO] 
[INFO] --- build-helper-maven-plugin:1.1:add-test-source (add-test-source) @ prim ---
[INFO] Test Source directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\test\java_generated added.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ prim ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ prim ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 164 source files to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ prim ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ prim ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 96 source files to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\target\test-classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.514 s
[INFO] Finished at: 2023-04-28T23:07:16+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en

########## Test INFO ##########
[INFO] Scanning for projects...
[WARNING] The project edu.jhu.prim:prim:jar:3.1.5 uses prerequisites which is only intended for maven-plugin projects but not for non maven-plugin projects. For such purposes you should use the maven-enforcer-plugin. See https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html
[INFO] 
[INFO] -------------------------< edu.jhu.prim:prim >--------------------------
[INFO] Building edu.jhu.prim:prim 3.1.5
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- build-helper-maven-plugin:1.1:add-source (add-source) @ prim ---
[INFO] Source directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\main\java_generated added.
[INFO] 
[INFO] --- build-helper-maven-plugin:1.1:add-test-source (add-test-source) @ prim ---
[INFO] Test Source directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\test\java_generated added.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ prim ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ prim ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ prim ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ prim ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.18.1:test (default-test) @ prim ---
[INFO] Surefire report directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running edu.jhu.prim.sample.PairSamplerTest
WARNING: pseudo random number generator is not thread safe
SEED=123456789101112
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.006 sec <<< FAILURE! - in edu.jhu.prim.sample.PairSamplerTest
testSampleUnorderedPairs(edu.jhu.prim.sample.PairSamplerTest)  Time elapsed: 0.005 sec  <<< FAILURE!
java.lang.AssertionError: 
	at org.junit.Assert.fail(Assert.java:91)
	at org.junit.Assert.assertTrue(Assert.java:43)
	at org.junit.Assert.assertTrue(Assert.java:54)
	at edu.jhu.prim.sample.PairSamplerTest.testSampleUnorderedPairs(PairSamplerTest.java:27)

Picked up JAVA_TOOL_OPTIONS: -Duser.language=en

Results :

Failed tests: 
  PairSamplerTest.testSampleUnorderedPairs:27 

Tests run: 1, Failures: 1, Errors: 0, Skipped: 0

[ERROR] There are test failures.

Please refer to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\mgormley_prim\target\surefire-reports for the individual test results.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.049 s
[INFO] Finished at: 2023-04-28T23:07:19+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en
