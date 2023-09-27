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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[46,70] cannot find symbol
  symbol:   variable TimeUnit
  location: class eu.toolchain.concurrent.CoreAsyncTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[50,38] method doEventuallyCollectImmediate in class eu.toolchain.concurrent.CoreAsync cannot be applied to given types;
  required: java.util.Collection<? extends java.util.concurrent.Callable<? extends eu.toolchain.concurrent.Stage<? extends C>>>,java.util.function.Consumer<? super C>,java.util.function.Supplier<? extends T>
  found: java.util.List<java.util.concurrent.Callable<java.lang.String>>,java.util.function.Consumer<java.lang.String>,java.util.function.Supplier<java.lang.Integer>
  reason: cannot infer type-variable(s) C,T
    (argument mismatch; java.util.List<java.util.concurrent.Callable<java.lang.String>> cannot be converted to java.util.Collection<? extends java.util.concurrent.Callable<? extends eu.toolchain.concurrent.Stage<? extends C>>>)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[52,82] cannot find symbol
  symbol:   variable TimeUnit
  location: class eu.toolchain.concurrent.CoreAsyncTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[53,22] cannot find symbol
  symbol:   method get()
  location: variable result of type eu.toolchain.concurrent.Stage<java.lang.Integer>
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[53,30] cannot find symbol
  symbol:   method equalTo(java.lang.Integer)
  location: class eu.toolchain.concurrent.CoreAsyncTest
[INFO] 5 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.615 s
[INFO] Finished at: 2023-09-26T02:33:59Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.3:testCompile (default-testCompile) on project tiny-async-core: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[46,70] cannot find symbol
[ERROR]   symbol:   variable TimeUnit
[ERROR]   location: class eu.toolchain.concurrent.CoreAsyncTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[50,38] method doEventuallyCollectImmediate in class eu.toolchain.concurrent.CoreAsync cannot be applied to given types;
[ERROR]   required: java.util.Collection<? extends java.util.concurrent.Callable<? extends eu.toolchain.concurrent.Stage<? extends C>>>,java.util.function.Consumer<? super C>,java.util.function.Supplier<? extends T>
[ERROR]   found: java.util.List<java.util.concurrent.Callable<java.lang.String>>,java.util.function.Consumer<java.lang.String>,java.util.function.Supplier<java.lang.Integer>
[ERROR]   reason: cannot infer type-variable(s) C,T
[ERROR]     (argument mismatch; java.util.List<java.util.concurrent.Callable<java.lang.String>> cannot be converted to java.util.Collection<? extends java.util.concurrent.Callable<? extends eu.toolchain.concurrent.Stage<? extends C>>>)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[52,82] cannot find symbol
[ERROR]   symbol:   variable TimeUnit
[ERROR]   location: class eu.toolchain.concurrent.CoreAsyncTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[53,22] cannot find symbol
[ERROR]   symbol:   method get()
[ERROR]   location: variable result of type eu.toolchain.concurrent.Stage<java.lang.Integer>
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest.java:[53,30] cannot find symbol
[ERROR]   symbol:   method equalTo(java.lang.Integer)
[ERROR]   location: class eu.toolchain.concurrent.CoreAsyncTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
