#
#
# makefile
#
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND = -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml



compile: *.java $(JUNIT5_JAR)
	javac -g -cp .:$(JUNIT5_JAR) *.java 
	#javac *.java

clean:
	rm -f *~
	rm -f *.class

test: compile $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path

run:
	make clean
	make 
	java Simulator

begin:
	make compile
	make run

customchk: *.java style.xml
	java $(CKSTYLE_COMMAND) -c style.xml *.java


