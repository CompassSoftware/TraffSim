/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;





public class TrafficLightTest1{
    TrafficLight light1, light2;
    @BeforeEach
        public void init(){
            light1 = new TrafficLight(GREEN);
            light2 = new TrafficLight(YELLOW);
            light3 = new TrafficLight();
            

        }
    @Test
    public void test

}





public class Calculator5Test {
    Calculator calculator;
    @BeforeEach

        public void init(){
            calculator = new Calculator();

        }
    @Test
        public void testEvaluate2() {
            int sum = calculator.evaluate("1+2+3");
            assertEquals(6, sum);
        }

    @Test

        public void testEvaluate() {
            int sum = calculator.evaluate("3 + 4 + 5");
            assertEquals(12, sum);
        }
}
