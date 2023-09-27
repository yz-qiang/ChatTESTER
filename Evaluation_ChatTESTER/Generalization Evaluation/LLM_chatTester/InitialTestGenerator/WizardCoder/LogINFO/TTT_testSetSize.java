original test path: waldheinz_fat32-lib###waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest###testSetSize
########## Compile INFO ##########
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for de.waldheinz:fat32-lib:jar:0.6.6-SNAPSHOT
[WARNING] Reporting configuration should be done in <reporting> section, not in maven-site-plugin <configuration> as reportPlugins parameter. @ line 121, column 32
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[WARNING] The project de.waldheinz:fat32-lib:jar:0.6.6-SNAPSHOT uses prerequisites which is only intended for maven-plugin projects but not for non maven-plugin projects. For such purposes you should use the maven-enforcer-plugin. See https://maven.apache.org/enforcer/enforcer-rules/requireMavenVersion.html
[INFO] 
[INFO] -----------------------< de.waldheinz:fat32-lib >-----------------------
[INFO] Building FAT32 Library 0.6.6-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ fat32-lib ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ fat32-lib ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 38 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/target/classes
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/main/java/de/waldheinz/fs/fat/FatLfnDirectoryEntry.java: /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/main/java/de/waldheinz/fs/fat/FatLfnDirectoryEntry.java uses or overrides a deprecated API.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/main/java/de/waldheinz/fs/fat/FatLfnDirectoryEntry.java: Recompile with -Xlint:deprecation for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ fat32-lib ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 7 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ fat32-lib ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 26 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[12,9] try-with-resources is not supported in -source 1.6
  (use -source 7 or higher to enable try-with-resources)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[33,30] ')' expected
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[33,34] illegal start of expression
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[37,42] ';' expected
[INFO] 4 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.298 s
[INFO] Finished at: 2023-09-24T15:04:38Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project fat32-lib: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[12,9] try-with-resources is not supported in -source 1.6
[ERROR]   (use -source 7 or higher to enable try-with-resources)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[33,30] ')' expected
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[33,34] illegal start of expression
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[37,42] ';' expected
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
