original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest###testRemove
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[11,20] cannot find symbol
  symbol:   class Pair
  location: package edu.jhu.prim
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[28,25] cannot find symbol
  symbol:   method containsKey(long)
  location: variable ldsm of type edu.jhu.prim.map.LongDoubleSortedMap
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[30,50] cannot find symbol
  symbol:   method entrySet()
  location: variable ldsm of type edu.jhu.prim.map.LongDoubleSortedMap
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[33,13] cannot find symbol
  symbol:   method assertNotNull(java.util.Map.Entry<java.lang.Long,java.lang.Double>)
  location: class edu.jhu.prim.map.LongDoubleSortedMapTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[34,19] incompatible types: possible lossy conversion from long to int
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[44,26] cannot find symbol
  symbol:   method fail(java.lang.String)
  location: class edu.jhu.prim.map.LongDoubleSortedMapTest
[INFO] 6 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.328 s
[INFO] Finished at: 2023-09-26T17:09:27Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project prim: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[11,20] cannot find symbol
[ERROR]   symbol:   class Pair
[ERROR]   location: package edu.jhu.prim
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[28,25] cannot find symbol
[ERROR]   symbol:   method containsKey(long)
[ERROR]   location: variable ldsm of type edu.jhu.prim.map.LongDoubleSortedMap
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[30,50] cannot find symbol
[ERROR]   symbol:   method entrySet()
[ERROR]   location: variable ldsm of type edu.jhu.prim.map.LongDoubleSortedMap
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[33,13] cannot find symbol
[ERROR]   symbol:   method assertNotNull(java.util.Map.Entry<java.lang.Long,java.lang.Double>)
[ERROR]   location: class edu.jhu.prim.map.LongDoubleSortedMapTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[34,19] incompatible types: possible lossy conversion from long to int
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest.java:[44,26] cannot find symbol
[ERROR]   symbol:   method fail(java.lang.String)
[ERROR]   location: class edu.jhu.prim.map.LongDoubleSortedMapTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
