original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[604,18] cannot access org.apache.commons.lang3.mutable.Mutable
  class file for org.apache.commons.lang3.mutable.Mutable not found
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest.java:[39,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest.java:[1651,18] cannot find symbol
  symbol:   class StrMatcher
  location: class org.apache.commons.lang3.text.StrBuilderTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedExceptionTest.java:[25,32] cannot find symbol
  symbol:   class StringUtils
  location: package org.apache.commons.lang3
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/LazyInitializerTest.java:[50,13] cannot find symbol
  symbol:   class LazyInitializer
  location: class org.apache.commons.lang3.concurrent.LazyInitializerTest
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/test/SystemDefaultsSwitchTest.java:[24,37] cannot find symbol
  symbol:   class FastTimeZone
  location: package org.apache.commons.lang3.time
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringUtilsTest.java:[41,37] cannot find symbol
  symbol:   class WordUtils
  location: package org.apache.commons.lang3.text
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[40,37] cannot find symbol
  symbol:   class StrBuilder
  location: package org.apache.commons.lang3.text
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[33,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[45,35] cannot find symbol
  symbol:   class StrTokenizer
  location: class org.apache.commons.lang3.text.StrTokenizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[538,26] cannot find symbol
  symbol:   class StrTokenizer
  location: class org.apache.commons.lang3.text.StrTokenizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[779,27] cannot find symbol
  symbol:   class StrTokenizer
  location: class org.apache.commons.lang3.text.StrTokenizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffTest.java:[30,26] cannot find symbol
  symbol:   class Diff
  location: class org.apache.commons.lang3.builder.DiffTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffTest.java:[32,46] cannot find symbol
  symbol:   class Diff
  location: class org.apache.commons.lang3.builder.DiffTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffBuilderTest.java:[26,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffBuilderTest.java:[38,51] cannot find symbol
  symbol:   class Diffable
  location: class org.apache.commons.lang3.builder.DiffBuilderTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffBuilderTest.java:[60,16] cannot find symbol
  symbol:   class DiffResult
  location: class org.apache.commons.lang3.builder.DiffBuilderTest.TypeTestClass
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/AtomicSafeInitializerTest.java:[69,13] cannot find symbol
  symbol:   class AtomicSafeInitializer
  location: class org.apache.commons.lang3.concurrent.AtomicSafeInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[48,31] cannot find symbol
  symbol:   class FormatFactory
  location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[439,60] cannot find symbol
  symbol:   class FormatFactory
  location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[450,60] cannot find symbol
  symbol:   class FormatFactory
  location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[461,68] cannot find symbol
  symbol:   class FormatFactory
  location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[475,61] cannot find symbol
  symbol:   class ExtendedMessageFormat
  location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[479,45] cannot find symbol
  symbol:   class FormatFactory
  location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest.OtherExtendedMessageFormat
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[41,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[52,38] cannot find symbol
  symbol:   class ImmutablePair
  location: package org.apache.commons.lang3.tuple
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[277,16] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[281,16] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[285,23] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[289,23] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[293,34] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[293,75] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[298,34] cannot find symbol
  symbol:   class ImmutablePair
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[305,49] cannot find symbol
  symbol:   class Mutable
  location: class org.apache.commons.lang3.reflect.MethodUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[40,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[41,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[42,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[44,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[45,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[46,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[47,13] cannot find symbol
  symbol:   class Range
  location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedRuntimeExceptionTest.java:[25,32] cannot find symbol
  symbol:   class StringUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/ConstructorUtilsTest.java:[31,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/FieldUtilsTest.java:[19,32] cannot find symbol
  symbol:   class ArrayUtils
  location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[32,22] cannot find symbol
  symbol:   class CircuitBreakingException
  location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[37,22] cannot find symbol
  symbol:   class CircuitBreakingException
  location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[42,22] cannot find symbol
  symbol:   class CircuitBreakingException
  location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[47,22] cannot find symbol
  symbol:   class CircuitBreakingException
  location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[INFO] 74 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.449 s
[INFO] Finished at: 2023-09-24T14:45:14Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile (default-testCompile) on project gwt-commons-lang3: Compilation failure: Compilation failure: 
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/EventCountCircuitBreakerTest.java:[329,20] cannot access org.apache.commons.lang3.concurrent.AbstractCircuitBreaker
[ERROR]   class file for org.apache.commons.lang3.concurrent.AbstractCircuitBreaker not found
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[604,18] cannot access org.apache.commons.lang3.mutable.Mutable
[ERROR]   class file for org.apache.commons.lang3.mutable.Mutable not found
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest.java:[39,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest.java:[1651,18] cannot find symbol
[ERROR]   symbol:   class StrMatcher
[ERROR]   location: class org.apache.commons.lang3.text.StrBuilderTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedExceptionTest.java:[25,32] cannot find symbol
[ERROR]   symbol:   class StringUtils
[ERROR]   location: package org.apache.commons.lang3
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/LazyInitializerTest.java:[50,13] cannot find symbol
[ERROR]   symbol:   class LazyInitializer
[ERROR]   location: class org.apache.commons.lang3.concurrent.LazyInitializerTest
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/test/SystemDefaultsSwitchTest.java:[24,37] cannot find symbol
[ERROR]   symbol:   class FastTimeZone
[ERROR]   location: package org.apache.commons.lang3.time
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/StringUtilsTest.java:[41,37] cannot find symbol
[ERROR]   symbol:   class WordUtils
[ERROR]   location: package org.apache.commons.lang3.text
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ObjectUtilsTest.java:[40,37] cannot find symbol
[ERROR]   symbol:   class StrBuilder
[ERROR]   location: package org.apache.commons.lang3.text
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
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[33,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[45,35] cannot find symbol
[ERROR]   symbol:   class StrTokenizer
[ERROR]   location: class org.apache.commons.lang3.text.StrTokenizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[538,26] cannot find symbol
[ERROR]   symbol:   class StrTokenizer
[ERROR]   location: class org.apache.commons.lang3.text.StrTokenizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrTokenizerTest.java:[779,27] cannot find symbol
[ERROR]   symbol:   class StrTokenizer
[ERROR]   location: class org.apache.commons.lang3.text.StrTokenizerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffTest.java:[30,26] cannot find symbol
[ERROR]   symbol:   class Diff
[ERROR]   location: class org.apache.commons.lang3.builder.DiffTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffTest.java:[32,46] cannot find symbol
[ERROR]   symbol:   class Diff
[ERROR]   location: class org.apache.commons.lang3.builder.DiffTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffBuilderTest.java:[26,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffBuilderTest.java:[38,51] cannot find symbol
[ERROR]   symbol:   class Diffable
[ERROR]   location: class org.apache.commons.lang3.builder.DiffBuilderTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/DiffBuilderTest.java:[60,16] cannot find symbol
[ERROR]   symbol:   class DiffResult
[ERROR]   location: class org.apache.commons.lang3.builder.DiffBuilderTest.TypeTestClass
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/AtomicSafeInitializerTest.java:[69,13] cannot find symbol
[ERROR]   symbol:   class AtomicSafeInitializer
[ERROR]   location: class org.apache.commons.lang3.concurrent.AtomicSafeInitializerTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[48,31] cannot find symbol
[ERROR]   symbol:   class FormatFactory
[ERROR]   location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[439,60] cannot find symbol
[ERROR]   symbol:   class FormatFactory
[ERROR]   location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[450,60] cannot find symbol
[ERROR]   symbol:   class FormatFactory
[ERROR]   location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[461,68] cannot find symbol
[ERROR]   symbol:   class FormatFactory
[ERROR]   location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[475,61] cannot find symbol
[ERROR]   symbol:   class ExtendedMessageFormat
[ERROR]   location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/ExtendedMessageFormatTest.java:[479,45] cannot find symbol
[ERROR]   symbol:   class FormatFactory
[ERROR]   location: class org.apache.commons.lang3.text.ExtendedMessageFormatTest.OtherExtendedMessageFormat
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[41,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[52,38] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: package org.apache.commons.lang3.tuple
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[277,16] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[281,16] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[285,23] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[289,23] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[293,34] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[293,75] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[298,34] cannot find symbol
[ERROR]   symbol:   class ImmutablePair
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest.TestBean
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/MethodUtilsTest.java:[305,49] cannot find symbol
[ERROR]   symbol:   class Mutable
[ERROR]   location: class org.apache.commons.lang3.reflect.MethodUtilsTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[40,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[41,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[42,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[44,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[45,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[46,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/RangeTest.java:[47,13] cannot find symbol
[ERROR]   symbol:   class Range
[ERROR]   location: class org.apache.commons.lang3.RangeTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/exception/ContextedRuntimeExceptionTest.java:[25,32] cannot find symbol
[ERROR]   symbol:   class StringUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/ConstructorUtilsTest.java:[31,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/FieldUtilsTest.java:[19,32] cannot find symbol
[ERROR]   symbol:   class ArrayUtils
[ERROR]   location: package org.apache.commons.lang3
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[32,22] cannot find symbol
[ERROR]   symbol:   class CircuitBreakingException
[ERROR]   location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[37,22] cannot find symbol
[ERROR]   symbol:   class CircuitBreakingException
[ERROR]   location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[42,22] cannot find symbol
[ERROR]   symbol:   class CircuitBreakingException
[ERROR]   location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] /home/zqc/Test_Completion/Prompt2Testing/repo_get/approachValidation_repo/ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/concurrent/CircuitBreakingExceptionTest.java:[47,22] cannot find symbol
[ERROR]   symbol:   class CircuitBreakingException
[ERROR]   location: class org.apache.commons.lang3.concurrent.CircuitBreakingExceptionTest
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
