original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testToStringTracing
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< eu.toolchain.async2:tiny-async-core >-----------------
[INFO] Building A tiny async implementation for Java (Core) 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tiny-async-core ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ tiny-async-core ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ tiny-async-core ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ tiny-async-core ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 30 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/target/test-classes
[INFO] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CollectHelperTest.java: Some input files use unchecked or unsafe operations.
[INFO] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CollectHelperTest.java: Recompile with -Xlint:unchecked for details.
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[36,41] cannot find symbol
  symbol:   variable ManagedState
  location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[36,17] cannot find symbol
  symbol:   method getState()
  location: variable managed of type eu.toolchain.concurrent.ConcurrentManaged
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[37,17] cannot find symbol
  symbol:   method getReference()
  location: variable managed of type eu.toolchain.concurrent.ConcurrentManaged
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[38,72] cannot find symbol
  symbol:   class ValidBorrowed
  location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[38,42] cannot find symbol
  symbol:   variable Collections
  location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[38,17] cannot find symbol
  symbol:   method getTraces()
  location: variable managed of type eu.toolchain.concurrent.ConcurrentManaged
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[39,28] method toStringTracing in class eu.toolchain.concurrent.ConcurrentManaged<T> cannot be applied to given types;
  required: java.lang.Object,java.util.List
  found: no arguments
  reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[40,5] cannot find symbol
  symbol:   method assertThat(java.lang.String)
  location: class eu.toolchain.concurrent.ConcurrentManagedTest
[INFO] 8 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.750 s
[INFO] Finished at: 2023-09-26T02:26:47Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.3:testCompile (default-testCompile) on project tiny-async-core: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[36,41] cannot find symbol
[ERROR]   symbol:   variable ManagedState
[ERROR]   location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[36,17] cannot find symbol
[ERROR]   symbol:   method getState()
[ERROR]   location: variable managed of type eu.toolchain.concurrent.ConcurrentManaged
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[37,17] cannot find symbol
[ERROR]   symbol:   method getReference()
[ERROR]   location: variable managed of type eu.toolchain.concurrent.ConcurrentManaged
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[38,72] cannot find symbol
[ERROR]   symbol:   class ValidBorrowed
[ERROR]   location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[38,42] cannot find symbol
[ERROR]   symbol:   variable Collections
[ERROR]   location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[38,17] cannot find symbol
[ERROR]   symbol:   method getTraces()
[ERROR]   location: variable managed of type eu.toolchain.concurrent.ConcurrentManaged
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[39,28] method toStringTracing in class eu.toolchain.concurrent.ConcurrentManaged<T> cannot be applied to given types;
[ERROR]   required: java.lang.Object,java.util.List
[ERROR]   found: no arguments
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java:[40,5] cannot find symbol
[ERROR]   symbol:   method assertThat(java.lang.String)
[ERROR]   location: class eu.toolchain.concurrent.ConcurrentManagedTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
