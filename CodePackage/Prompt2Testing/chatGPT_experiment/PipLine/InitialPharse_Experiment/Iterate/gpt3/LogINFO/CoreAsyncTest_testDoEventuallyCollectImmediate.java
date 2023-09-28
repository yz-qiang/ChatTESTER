original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoEventuallyCollectImmediate
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< eu.toolchain.async2:tiny-async-core >-----------------
[INFO] Building A tiny async implementation for Java (Core) 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tiny-async-core ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\udoprog_tiny-async-java\tiny-async-core\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ tiny-async-core ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ tiny-async-core ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\udoprog_tiny-async-java\tiny-async-core\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ tiny-async-core ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 30 source files to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\udoprog_tiny-async-java\tiny-async-core\target\test-classes
[INFO] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java: Some input files use unchecked or unsafe operations.
[INFO] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest.java: Recompile with -Xlint:unchecked for details.
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[47,25] cannot find symbol
  symbol:   method toCompletableFuture()
  location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[48,30] cannot find symbol
  symbol:   method toCompletableFuture()
  location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[49,38] cannot find symbol
  symbol:   method toCompletableFuture()
  location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[50,38] cannot find symbol
  symbol:   method toCompletableFuture()
  location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[INFO] 4 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.246 s
[INFO] Finished at: 2023-04-29T00:33:30+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.3:testCompile (default-testCompile) on project tiny-async-core: Compilation failure: Compilation failure: 
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[47,25] cannot find symbol
[ERROR]   symbol:   method toCompletableFuture()
[ERROR]   location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[48,30] cannot find symbol
[ERROR]   symbol:   method toCompletableFuture()
[ERROR]   location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[49,38] cannot find symbol
[ERROR]   symbol:   method toCompletableFuture()
[ERROR]   location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] /D:/Python/Test_Completion/Promt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[50,38] cannot find symbol
[ERROR]   symbol:   method toCompletableFuture()
[ERROR]   location: variable stage of type eu.toolchain.concurrent.Stage<java.util.List<java.lang.String>>
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en
