/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

public class TrafficLightTest{
    TrafficLight light1, light2, light3;
    @BeforeEach
        public void init(){
            light1 = new TrafficLight('G');
            light2 = new TrafficLight('Y');
            light3 = new TrafficLight('R');


        }
    @Test
        public void testDefConst(){
            assertEquals(light3.getColor(), TrafficLight.BulbColor.RED);

        }
    @Test
        public void testInit1(){
            boolean b1, b2, b3;
            b1 = light1.getColor() != light2.getColor();
            b2 = light2.getColor() != light3.getColor();
            b3 = light3.getColor() != light1.getColor();
            assertTrue(b1 && b2 && b3);
        }
    @Test
        public void testConst(){
            boolean b1, b2;
            b1 = light1.getColor() == 'G';
            b2 = light2.getColor() == 'Y';
            assertTrue(b1 && b2);
        }
    @Test
        public void testSetter(){
            light2.setColor('R');
            assertEquals(light2.getColor(), light3.getColor());
        }
}

