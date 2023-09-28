original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentCompletableTest###testCancel
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
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.998 s
[INFO] Finished at: 2023-04-28T23:39:18+08:00
[INFO] ------------------------------------------------------------------------
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en

########## Test INFO ##########
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
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ tiny-async-core ---
[INFO] Surefire report directory: D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\udoprog_tiny-async-java\tiny-async-core\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running eu.toolchain.concurrent.ConcurrentCompletableTest
Tests run: 4, Failures: 0, Errors: 2, Skipped: 0, Time elapsed: 0.181 sec <<< FAILURE!
cancel_shouldPostComplete(eu.toolchain.concurrent.ConcurrentCompletableTest)  Time elapsed: 0.008 sec  <<< ERROR!
org.mockito.exceptions.misusing.NotAMockException: 
Argument passed to when() is not a mock!
Example of correct stubbing:
    doThrow(new RuntimeException()).when(mock).someMethod();
	at eu.toolchain.concurrent.ConcurrentCompletableTest.cancel_shouldPostComplete(ConcurrentCompletableTest.java:58)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.rules.ExpectedException$ExpectedExceptionStatement.evaluate(ExpectedException.java:239)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.mockito.internal.runners.JUnit45AndHigherRunnerImpl.run(JUnit45AndHigherRunnerImpl.java:37)
	at org.mockito.runners.MockitoJUnitRunner.run(MockitoJUnitRunner.java:62)
	at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)
	at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)
	at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
	at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
	at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)

cancel_shouldPostComplete(eu.toolchain.concurrent.ConcurrentCompletableTest)  Time elapsed: 0.009 sec  <<< ERROR!
org.mockito.exceptions.misusing.UnfinishedStubbingException: 
Unfinished stubbing detected here:
-> at eu.toolchain.concurrent.ConcurrentCompletableTest.cancel_shouldPostComplete(ConcurrentCompletableTest.java:58)

E.g. thenReturn() may be missing.
Examples of correct stubbing:
    when(mock.isOk()).thenReturn(true);
    when(mock.isOk()).thenThrow(exception);
    doThrow(exception).when(mock).someVoidMethod();
Hints:
 1. missing thenReturn()
 2. you are trying to stub a final method, you naughty developer!
 3: you are stubbing the behaviour of another mock inside before 'thenReturn' instruction if completed

	at org.mockito.internal.runners.util.FrameworkUsageValidator.testFinished(FrameworkUsageValidator.java:25)
	at org.junit.runner.notification.SynchronizedRunListener.testFinished(SynchronizedRunListener.java:56)
	at org.junit.runner.notification.RunNotifier$7.notifyListener(RunNotifier.java:190)
	at org.junit.runner.notification.RunNotifier$SafeNotifier.run(RunNotifier.java:72)
	at org.junit.runner.notification.RunNotifier.fireTestFinished(RunNotifier.java:187)
	at org.junit.internal.runners.model.EachTestNotifier.fireTestFinished(EachTestNotifier.java:38)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:331)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.mockito.internal.runners.JUnit45AndHigherRunnerImpl.run(JUnit45AndHigherRunnerImpl.java:37)
	at org.mockito.runners.MockitoJUnitRunner.run(MockitoJUnitRunner.java:62)
	at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)
	at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)
	at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
	at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
	at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)

Picked up JAVA_TOOL_OPTIONS: -Duser.language=en

Results :

Tests in error: 
  cancel_shouldPostComplete(eu.toolchain.concurrent.ConcurrentCompletableTest): (..)
  cancel_shouldPostComplete(eu.toolchain.concurrent.ConcurrentCompletableTest): (..)

Tests run: 4, Failures: 0, Errors: 2, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.362 s
[INFO] Finished at: 2023-04-28T23:39:22+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project tiny-async-core: There are test failures.
[ERROR] 
[ERROR] Please refer to D:\Python\Test_Completion\Promt2Testing\repo_get\approachValidation_repo\udoprog_tiny-async-java\tiny-async-core\target\surefire-reports for the individual test results.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
Picked up JAVA_TOOL_OPTIONS: -Duser.language=en
