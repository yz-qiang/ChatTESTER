original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest###testRound
########## Compile INFO ##########
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for de.knightsoft-net:gwt-commons-lang3:jar:3.7-0
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-scm-publish-plugin is missing. @ line 706, column 15
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-surefire-plugin is missing. @ line 659, column 15
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-jar-plugin is missing. @ line 687, column 15
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] Inspecting build with total of 1 modules...
[INFO] Installing Nexus Staging features:
[INFO]   ... total of 1 executions of maven-deploy-plugin replaced with nexus-staging-maven-plugin
[INFO] 
[INFO] ----------------< de.knightsoft-net:gwt-commons-lang3 >-----------------
[INFO] Building Apache Commons Lang 3.7-0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gwt-commons-lang3 ---
[INFO] Using 'ISO-8859-1' encoding to copy filtered resources.
[INFO] Copying 14 resources
[INFO] 
[INFO] --- gwt-maven-plugin:2.8.2:resources (default) @ gwt-commons-lang3 ---
[WARNING] The artifact xml-apis:xml-apis:jar:2.0.2 has been relocated to xml-apis:xml-apis:jar:1.0.b2
[INFO] 166 source files from GWT module org.apache.commons.GWTCommonsLang3
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ gwt-commons-lang3 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 152 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/target/classes
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/main/java/org/apache/commons/lang3/ObjectUtils.java: Some input files use or override a deprecated API.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/main/java/org/apache/commons/lang3/ObjectUtils.java: Recompile with -Xlint:deprecation for details.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/main/java/org/apache/commons/lang3/text/StrBuilder.java: Some input files use unchecked or unsafe operations.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/main/java/org/apache/commons/lang3/text/StrBuilder.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gwt-commons-lang3 ---
[INFO] Using 'ISO-8859-1' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ gwt-commons-lang3 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 172 source files to /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/target/test-classes
[INFO] -------------------------------------------------------------
[WARNING] COMPILATION WARNING : 
[INFO] -------------------------------------------------------------
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringUtilsTest.java: Some input files use or override a deprecated API.
[WARNING] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringUtilsTest.java: Recompile with -Xlint:deprecation for details.
[INFO] 2 warnings 
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest.java:[35,16] no suitable constructor found for GregorianCalendar(int,int,int,int,int,int,int)
    constructor java.util.GregorianCalendar.GregorianCalendar() is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.Locale) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale,boolean) is not applicable
      (actual and formal argument lists differ in length)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest.java:[52,22] reference to round is ambiguous
  both method round(java.util.Date,int) in org.apache.commons.lang3.time.DateUtils and method round(java.util.Calendar,int) in org.apache.commons.lang3.time.DateUtils match
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest.java:[60,22] no suitable constructor found for GregorianCalendar(int,int,int,int,int,int,int)
    constructor java.util.GregorianCalendar.GregorianCalendar() is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.Locale) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int,int) is not applicable
      (actual and formal argument lists differ in length)
    constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale,boolean) is not applicable
      (actual and formal argument lists differ in length)
[INFO] 3 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.175 s
[INFO] Finished at: 2023-09-26T06:52:49Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project gwt-commons-lang3: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest.java:[35,16] no suitable constructor found for GregorianCalendar(int,int,int,int,int,int,int)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar() is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.Locale) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int,int) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale,boolean) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest.java:[52,22] reference to round is ambiguous
[ERROR]   both method round(java.util.Date,int) in org.apache.commons.lang3.time.DateUtils and method round(java.util.Calendar,int) in org.apache.commons.lang3.time.DateUtils match
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest.java:[60,22] no suitable constructor found for GregorianCalendar(int,int,int,int,int,int,int)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar() is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.Locale) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(int,int,int,int,int,int) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR]     constructor java.util.GregorianCalendar.GregorianCalendar(java.util.TimeZone,java.util.Locale,boolean) is not applicable
[ERROR]       (actual and formal argument lists differ in length)
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
