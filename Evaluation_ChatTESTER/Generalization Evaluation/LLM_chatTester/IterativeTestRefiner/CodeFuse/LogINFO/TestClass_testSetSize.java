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
[WARNING] COMPILATION WARNING : 
[INFO] -------------------------------------------------------------
[WARNING] Some messages have been simplified; recompile with -Xdiags:verbose to get full output
[INFO] 1 warning
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[15,27] cannot find symbol
  symbol:   class RamDisk
  location: package de.waldheinz.fs.fat
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[25,41] incompatible types: int cannot be converted to boolean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[26,15] constructor Fat in class de.waldheinz.fs.fat.Fat cannot be applied to given types;
  required: de.waldheinz.fs.fat.BootSector,long
  found: de.waldheinz.fs.fat.FatFileSystem
  reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[33,14] no suitable method found for write(java.nio.file.Path,java.nio.ByteBuffer)
    method java.nio.file.Files.write(java.nio.file.Path,byte[],java.nio.file.OpenOption...) is not applicable
      (argument mismatch; java.nio.ByteBuffer cannot be converted to byte[])
    method java.nio.file.Files.write(java.nio.file.Path,java.lang.Iterable<? extends java.lang.CharSequence>,java.nio.charset.Charset,java.nio.file.OpenOption...) is not applicable
      (argument mismatch; java.nio.ByteBuffer cannot be converted to java.lang.Iterable<? extends java.lang.CharSequence>)
    method java.nio.file.Files.write(java.nio.file.Path,java.lang.Iterable<? extends java.lang.CharSequence>,java.nio.file.OpenOption...) is not applicable
      (argument mismatch; java.nio.ByteBuffer cannot be converted to java.lang.Iterable<? extends java.lang.CharSequence>)
[INFO] 4 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.190 s
[INFO] Finished at: 2023-09-26T17:41:45Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project fat32-lib: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[15,27] cannot find symbol
[ERROR]   symbol:   class RamDisk
[ERROR]   location: package de.waldheinz.fs.fat
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[25,41] incompatible types: int cannot be converted to boolean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[26,15] constructor Fat in class de.waldheinz.fs.fat.Fat cannot be applied to given types;
[ERROR]   required: de.waldheinz.fs.fat.BootSector,long
[ERROR]   found: de.waldheinz.fs.fat.FatFileSystem
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest.java:[33,14] no suitable method found for write(java.nio.file.Path,java.nio.ByteBuffer)
[ERROR]     method java.nio.file.Files.write(java.nio.file.Path,byte[],java.nio.file.OpenOption...) is not applicable
[ERROR]       (argument mismatch; java.nio.ByteBuffer cannot be converted to byte[])
[ERROR]     method java.nio.file.Files.write(java.nio.file.Path,java.lang.Iterable<? extends java.lang.CharSequence>,java.nio.charset.Charset,java.nio.file.OpenOption...) is not applicable
[ERROR]       (argument mismatch; java.nio.ByteBuffer cannot be converted to java.lang.Iterable<? extends java.lang.CharSequence>)
[ERROR]     method java.nio.file.Files.write(java.nio.file.Path,java.lang.Iterable<? extends java.lang.CharSequence>,java.nio.file.OpenOption...) is not applicable
[ERROR]       (argument mismatch; java.nio.ByteBuffer cannot be converted to java.lang.Iterable<? extends java.lang.CharSequence>)
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException