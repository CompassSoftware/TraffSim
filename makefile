#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for JUnit sample
#
# @author Dr. Fenwick
# @version Summer 2018
#

JUNIT4_JAR = /usr/share/java/junit-4.10.jar
JUNIT4_RUNNER = org.junit.runner.JUnitCore 
HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar
JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "USAGE: make target"
	@echo "EXAMPLE: make help"
	@echo "EXAMPLE: make targetlist"

targetlist:
	@echo "7 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
	@echo "____________________ compile4, test4 - builds/runs JUnit4 tests"
	@echo "____________________ defchk, customchk - default or custom checkstyle"

help:
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make test ; make defchk"

# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

compile: TrafficLight.java LightBulb.java TrafficLightTest.java $(JUNIT5_JAR)
	javac -cp .:$(JUNIT5_JAR) TrafficLightTest.java
	javac TrafficLight.java
	javac LightBulb.java

clean:
	rm -f *~
	rm -f *.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 


