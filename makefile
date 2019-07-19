#
#
# makefile
#
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
STYLE_COMMAND = "-jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar"
STYLE_XML = style.xml

default:
		@echo "compile - compiles all files"
		@echo "test - run the tests"
		@echo "clean - rm all class files"

clean:
		rm -f *.class

test: junit-platform-console-standalone-1.2.0.jar
		java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path

compile: junit-platform-console-standalone-1.2.0.jar
		javac -cp .:$(JUNIT5_JAR) *.java
