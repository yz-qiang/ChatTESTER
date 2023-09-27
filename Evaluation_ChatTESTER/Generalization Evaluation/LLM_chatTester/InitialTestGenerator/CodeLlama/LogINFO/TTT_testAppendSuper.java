original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/CompareToBuilderTest###testAppendSuper
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
[WARNING] While traversing org.apache.commons.lang3.builder.ToStringStyleTest.ToStringStyleImpl, caught com.sun.tools.javac.code.Symbol$CompletionFailure: class file for org.apache.commons.lang3.builder.ToStringStyle$DefaultToStringStyle not found
[WARNING] While traversing org.apache.commons.lang3.builder.ToStringStyleTest.ToStringStyleImpl, caught com.sun.tools.javac.code.Symbol$CompletionFailure: class file for org.apache.commons.lang3.builder.ToStringStyle$NoFieldNameToStringStyle not found
[WARNING] While traversing org.apache.commons.lang3.builder.ToStringStyleTest.ToStringStyleImpl, caught com.sun.tools.javac.code.Symbol$CompletionFailure: class file for org.apache.commons.lang3.builder.ToStringStyle$ShortPrefixToStringStyle not found
[INFO] 3 warnings 
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/EventCountCircuitBreakerTest.java:[329,20] cannot access org.apache.commons.lang3.concurrent.AbstractCircuitBreaker
  class file for org.apache.commons.lang3.concurrent.AbstractCircuitBreaker not found
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/LocaleUtilsTest.java:[19,1] static import only from classes and interfaces
[ERROR] Annotation generator had thrown the exception. com.sun.tools.javac.code.Symbol$CompletionFailure: class file for org.apache.commons.lang3.builder.ToStringStyle$SimpleToStringStyle not found
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/MemoizerTest.java:[33,13] cannot find symbol
  symbol:   class Computable
  location: class org.apache.commons.lang3.concurrent.MemoizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/ReflectionToStringBuilderExcludeTest.java:[27,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/AbstractExceptionContextTest.java:[34,38] cannot find symbol
  symbol:   class Pair
  location: package org.apache.commons.lang3.tuple
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/AbstractExceptionContextTest.java:[40,62] cannot find symbol
  symbol: class ExceptionContext
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/EqualsBuilderTest.java:[27,40] cannot find symbol
  symbol:   class MethodUtils
  location: package org.apache.commons.lang3.reflect
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[22,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[22,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[23,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[23,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[24,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[24,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[25,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[25,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[26,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[26,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[27,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[27,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[28,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[28,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[29,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[29,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[30,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[30,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[31,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[31,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ClassUtilsTest.java:[41,43] package org.apache.commons.lang3.ClassUtils does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest.java:[18,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/ConstantInitializerTest.java:[35,13] cannot find symbol
  symbol:   class ConstantInitializer
  location: class org.apache.commons.lang3.concurrent.ConstantInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedExceptionTest.java:[25,32] cannot find symbol
  symbol:   class StringUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedExceptionTest.java:[31,74] cannot find symbol
  symbol: class ContextedException
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[64,5] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[68,13] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[72,13] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[76,13] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[89,15] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[219,119] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[379,104] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[386,84] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/DefaultExceptionContextTest.java:[25,79] cannot find symbol
  symbol: class DefaultExceptionContext
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/LazyInitializerTest.java:[50,13] cannot find symbol
  symbol:   class LazyInitializer
  location: class org.apache.commons.lang3.concurrent.LazyInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/LazyInitializerTest.java:[40,15] cannot find symbol
  symbol:   class ConcurrentInitializer
  location: class org.apache.commons.lang3.concurrent.LazyInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/AbstractConcurrentInitializerTest.java:[119,24] cannot find symbol
  symbol:   class ConcurrentInitializer
  location: class org.apache.commons.lang3.concurrent.AbstractConcurrentInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/ReflectionDiffBuilderTest.java:[29,51] cannot find symbol
  symbol:   class Diffable
  location: class org.apache.commons.lang3.builder.ReflectionDiffBuilderTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/ReflectionDiffBuilderTest.java:[53,16] cannot find symbol
  symbol:   class DiffResult
  location: class org.apache.commons.lang3.builder.ReflectionDiffBuilderTest.TypeTestClass
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateFormat_ParserTest.java:[30,15] cannot find symbol
  symbol:   class DateParser
  location: class org.apache.commons.lang3.time.FastDateFormat_ParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffResultTest.java:[36,49] cannot find symbol
  symbol:   class Diffable
  location: class org.apache.commons.lang3.builder.DiffResultTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffResultTest.java:[48,16] cannot find symbol
  symbol:   class DiffResult
  location: class org.apache.commons.lang3.builder.DiffResultTest.SimpleClass
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[23,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[23,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[27,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[27,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[28,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[28,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[29,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[29,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[30,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[30,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[31,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[31,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[32,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[32,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[33,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[33,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[34,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[34,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[35,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[35,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[36,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[36,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[37,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[37,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[38,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[38,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[39,39] cannot find symbol
  symbol:   class JavaVersion
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[39,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[19,37] package org.apache.commons.lang3.arch does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[136,57] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[136,75] cannot find symbol
  symbol:   class Processor
  location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[142,60] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[142,78] cannot find symbol
  symbol:   class Processor
  location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[148,57] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[148,75] cannot find symbol
  symbol:   class Processor
  location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[154,60] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[154,78] cannot find symbol
  symbol:   class Processor
  location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/test/SystemDefaultsSwitchTest.java:[24,37] cannot find symbol
  symbol:   class FastTimeZone
  location: package org.apache.commons.lang3.time
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringUtilsTest.java:[41,37] cannot find symbol
  symbol:   class WordUtils
  location: package org.apache.commons.lang3.text
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[39,40] cannot find symbol
  symbol:   class MutableObject
  location: package org.apache.commons.lang3.mutable
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[40,37] cannot find symbol
  symbol:   class StrBuilder
  location: package org.apache.commons.lang3.text
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[604,48] cannot find symbol
  symbol:   class MutableObject
  location: class org.apache.commons.lang3.ObjectUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[619,50] cannot find symbol
  symbol:   class MutableObject
  location: class org.apache.commons.lang3.ObjectUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateFormat_PrinterTest.java:[30,15] cannot find symbol
  symbol:   class DatePrinter
  location: class org.apache.commons.lang3.time.FastDateFormat_PrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[52,5] cannot find symbol
  symbol:   class DatePrinter
  location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[56,13] cannot find symbol
  symbol:   class DatePrinter
  location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[60,13] cannot find symbol
  symbol:   class DatePrinter
  location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[64,13] cannot find symbol
  symbol:   class DatePrinter
  location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[75,15] cannot find symbol
  symbol:   class DatePrinter
  location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringEscapeUtilsTest.java:[35,47] cannot find symbol
  symbol:   class CharSequenceTranslator
  location: package org.apache.commons.lang3.text.translate
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsRoundingTest.java:[58,5] cannot find symbol
  symbol:   class FastDateFormat
  location: class org.apache.commons.lang3.time.DateUtilsRoundingTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrSubstitutorTest.java:[31,40] cannot find symbol
  symbol:   class MutableObject
  location: package org.apache.commons.lang3.mutable
[INFO] 102 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.200 s
[INFO] Finished at: 2023-09-24T06:26:07Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project gwt-commons-lang3: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/EventCountCircuitBreakerTest.java:[329,20] cannot access org.apache.commons.lang3.concurrent.AbstractCircuitBreaker
[ERROR]   class file for org.apache.commons.lang3.concurrent.AbstractCircuitBreaker not found
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/LocaleUtilsTest.java:[19,1] static import only from classes and interfaces
[ERROR] Annotation generator had thrown the exception. com.sun.tools.javac.code.Symbol$CompletionFailure: class file for org.apache.commons.lang3.builder.ToStringStyle$SimpleToStringStyle not found
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/MemoizerTest.java:[33,13] cannot find symbol
[ERROR]   symbol:   class Computable
[ERROR]   location: class org.apache.commons.lang3.concurrent.MemoizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/ReflectionToStringBuilderExcludeTest.java:[27,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/AbstractExceptionContextTest.java:[34,38] cannot find symbol
[ERROR]   symbol:   class Pair
[ERROR]   location: package org.apache.commons.lang3.tuple
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/AbstractExceptionContextTest.java:[40,62] cannot find symbol
[ERROR]   symbol: class ExceptionContext
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/EqualsBuilderTest.java:[27,40] cannot find symbol
[ERROR]   symbol:   class MethodUtils
[ERROR]   location: package org.apache.commons.lang3.reflect
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[22,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[22,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[23,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[23,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[24,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[24,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[25,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[25,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[26,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[26,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[27,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[27,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[28,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[28,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[29,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[29,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[30,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[30,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[31,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SystemUtilsTest.java:[31,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ClassUtilsTest.java:[41,43] package org.apache.commons.lang3.ClassUtils does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest.java:[18,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/ConstantInitializerTest.java:[35,13] cannot find symbol
[ERROR]   symbol:   class ConstantInitializer
[ERROR]   location: class org.apache.commons.lang3.concurrent.ConstantInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedExceptionTest.java:[25,32] cannot find symbol
[ERROR]   symbol:   class StringUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedExceptionTest.java:[31,74] cannot find symbol
[ERROR]   symbol: class ContextedException
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[64,5] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[68,13] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[72,13] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[76,13] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[89,15] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[219,119] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[379,104] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java:[386,84] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/DefaultExceptionContextTest.java:[25,79] cannot find symbol
[ERROR]   symbol: class DefaultExceptionContext
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/LazyInitializerTest.java:[50,13] cannot find symbol
[ERROR]   symbol:   class LazyInitializer
[ERROR]   location: class org.apache.commons.lang3.concurrent.LazyInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/LazyInitializerTest.java:[40,15] cannot find symbol
[ERROR]   symbol:   class ConcurrentInitializer
[ERROR]   location: class org.apache.commons.lang3.concurrent.LazyInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/AbstractConcurrentInitializerTest.java:[119,24] cannot find symbol
[ERROR]   symbol:   class ConcurrentInitializer
[ERROR]   location: class org.apache.commons.lang3.concurrent.AbstractConcurrentInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/ReflectionDiffBuilderTest.java:[29,51] cannot find symbol
[ERROR]   symbol:   class Diffable
[ERROR]   location: class org.apache.commons.lang3.builder.ReflectionDiffBuilderTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/ReflectionDiffBuilderTest.java:[53,16] cannot find symbol
[ERROR]   symbol:   class DiffResult
[ERROR]   location: class org.apache.commons.lang3.builder.ReflectionDiffBuilderTest.TypeTestClass
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateFormat_ParserTest.java:[30,15] cannot find symbol
[ERROR]   symbol:   class DateParser
[ERROR]   location: class org.apache.commons.lang3.time.FastDateFormat_ParserTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffResultTest.java:[36,49] cannot find symbol
[ERROR]   symbol:   class Diffable
[ERROR]   location: class org.apache.commons.lang3.builder.DiffResultTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffResultTest.java:[48,16] cannot find symbol
[ERROR]   symbol:   class DiffResult
[ERROR]   location: class org.apache.commons.lang3.builder.DiffResultTest.SimpleClass
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[23,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[23,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[27,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[27,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[28,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[28,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[29,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[29,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[30,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[30,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[31,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[31,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[32,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[32,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[33,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[33,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[34,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[34,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[35,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[35,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[36,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[36,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[37,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[37,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[38,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[38,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[39,39] cannot find symbol
[ERROR]   symbol:   class JavaVersion
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/JavaVersionTest.java:[39,1] static import only from classes and interfaces
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[19,37] package org.apache.commons.lang3.arch does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[136,57] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[136,75] cannot find symbol
[ERROR]   symbol:   class Processor
[ERROR]   location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[142,60] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[142,78] cannot find symbol
[ERROR]   symbol:   class Processor
[ERROR]   location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[148,57] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[148,75] cannot find symbol
[ERROR]   symbol:   class Processor
[ERROR]   location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[154,60] package Processor does not exist
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArchUtilsTest.java:[154,78] cannot find symbol
[ERROR]   symbol:   class Processor
[ERROR]   location: class org.apache.commons.lang3.ArchUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/test/SystemDefaultsSwitchTest.java:[24,37] cannot find symbol
[ERROR]   symbol:   class FastTimeZone
[ERROR]   location: package org.apache.commons.lang3.time
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringUtilsTest.java:[41,37] cannot find symbol
[ERROR]   symbol:   class WordUtils
[ERROR]   location: package org.apache.commons.lang3.text
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[39,40] cannot find symbol
[ERROR]   symbol:   class MutableObject
[ERROR]   location: package org.apache.commons.lang3.mutable
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[40,37] cannot find symbol
[ERROR]   symbol:   class StrBuilder
[ERROR]   location: package org.apache.commons.lang3.text
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[604,48] cannot find symbol
[ERROR]   symbol:   class MutableObject
[ERROR]   location: class org.apache.commons.lang3.ObjectUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[619,50] cannot find symbol
[ERROR]   symbol:   class MutableObject
[ERROR]   location: class org.apache.commons.lang3.ObjectUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateFormat_PrinterTest.java:[30,15] cannot find symbol
[ERROR]   symbol:   class DatePrinter
[ERROR]   location: class org.apache.commons.lang3.time.FastDateFormat_PrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[52,5] cannot find symbol
[ERROR]   symbol:   class DatePrinter
[ERROR]   location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[56,13] cannot find symbol
[ERROR]   symbol:   class DatePrinter
[ERROR]   location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[60,13] cannot find symbol
[ERROR]   symbol:   class DatePrinter
[ERROR]   location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[64,13] cannot find symbol
[ERROR]   symbol:   class DatePrinter
[ERROR]   location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest.java:[75,15] cannot find symbol
[ERROR]   symbol:   class DatePrinter
[ERROR]   location: class org.apache.commons.lang3.time.FastDatePrinterTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringEscapeUtilsTest.java:[35,47] cannot find symbol
[ERROR]   symbol:   class CharSequenceTranslator
[ERROR]   location: package org.apache.commons.lang3.text.translate
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsRoundingTest.java:[58,5] cannot find symbol
[ERROR]   symbol:   class FastDateFormat
[ERROR]   location: class org.apache.commons.lang3.time.DateUtilsRoundingTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrSubstitutorTest.java:[31,40] cannot find symbol
[ERROR]   symbol:   class MutableObject
[ERROR]   location: package org.apache.commons.lang3.mutable
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
