original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
########## Compile INFO ##########
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< cn.xdean:Java-EX >--------------------------
[INFO] Building Java-EX 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Java-EX ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ Java-EX ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 73 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/target/classes
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[5,16] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[22,24] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[33,17] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[229,18] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[231,14] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[235,40] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[236,21] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/main/java/cn/xdean/jex/lang/unsafe/UnsafeUtil.java:[236,33] sun.misc.Unsafe is internal proprietary API and may be removed in a future release
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ Java-EX ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 11 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ Java-EX ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 36 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest.java:[19,22] no suitable method found for compare(java.lang.Object[],java.lang.Object[])
    method cn.xdean.jex.lang.collection.ArrayUtil.compare(int[],int[]) is not applicable
      (argument mismatch; java.lang.Object[] cannot be converted to int[])
    method cn.xdean.jex.lang.collection.ArrayUtil.<T>compare(T[],T[]) is not applicable
      (inference variable T has incompatible bounds
        upper bounds: java.lang.Comparable<T>
        lower bounds: java.lang.Object)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest.java:[25,34] no suitable method found for compare(java.lang.Object[],java.lang.Object[])
    method cn.xdean.jex.lang.collection.ArrayUtil.compare(int[],int[]) is not applicable
      (argument mismatch; java.lang.Object[] cannot be converted to int[])
    method cn.xdean.jex.lang.collection.ArrayUtil.<T>compare(T[],T[]) is not applicable
      (inference variable T has incompatible bounds
        upper bounds: java.lang.Comparable<T>
        lower bounds: java.lang.Object)
[INFO] 2 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.124 s
[INFO] Finished at: 2023-09-26T00:35:57Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project Java-EX: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest.java:[19,22] no suitable method found for compare(java.lang.Object[],java.lang.Object[])
[ERROR]     method cn.xdean.jex.lang.collection.ArrayUtil.compare(int[],int[]) is not applicable
[ERROR]       (argument mismatch; java.lang.Object[] cannot be converted to int[])
[ERROR]     method cn.xdean.jex.lang.collection.ArrayUtil.<T>compare(T[],T[]) is not applicable
[ERROR]       (inference variable T has incompatible bounds
[ERROR]         upper bounds: java.lang.Comparable<T>
[ERROR]         lower bounds: java.lang.Object)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest.java:[25,34] no suitable method found for compare(java.lang.Object[],java.lang.Object[])
[ERROR]     method cn.xdean.jex.lang.collection.ArrayUtil.compare(int[],int[]) is not applicable
[ERROR]       (argument mismatch; java.lang.Object[] cannot be converted to int[])
[ERROR]     method cn.xdean.jex.lang.collection.ArrayUtil.<T>compare(T[],T[]) is not applicable
[ERROR]       (inference variable T has incompatible bounds
[ERROR]         upper bounds: java.lang.Comparable<T>
[ERROR]         lower bounds: java.lang.Object)
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
