#
#
# makefile
#
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
STYLE_COMMAND = "-jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar"
STYLE_XML = style.xml


compile: TrafficLight.java LightBulb.java TrafficLightTest.java Lane.java sensor.java sensorTest.java Car.java CarTest.java CarQueue.java Controller.java ControllerTest.java $(JUNIT5_JAR)

	javac -cp .:$(JUNIT5_JAR) TrafficLightTest.java CarTest.java sensorTest.java ControllerTest.java

	javac TrafficLight.java LightBulb.java Lane.java Controller.java sensor.java Car.java CarQueue.java

clean:
	rm -f *~
	rm -f *.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 
