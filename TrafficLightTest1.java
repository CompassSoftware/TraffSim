/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;




public class TrafficLightTest1{
    TrafficLight light1, light2, light3;
    @BeforeEach
        public void init(){
            light1 = new TrafficLight(BulbColor.GREEN);
            light2 = new TrafficLight(BulbColor.YELLOW);
            light3 = new TrafficLight();


        }
    @Test
        public void testDefConst(){
            assert light3.getColor() == BulbColor.RED;

        }

    @Test
        public void testInit1(){
            boolean b1, b2, b3;
            b1 = light1.getColor() != light2.getColor();
            b2 = light2.getColor() != light3.getColor();
            b3 = light3.getColor() != light1.getColor();
            assert b1 && b2 && b3;
        }

    @Test
        public void testConst(){
            boolean b1, b2;
            b1 = light1.getColor() == BulbColor.GREEN;
            b2 = light2.getColor() == BulbColor.YELLOW;
            assert b1 && b2;
        }

    @Test
        public void testSetter(){
            light2.setColor(BulbColor.RED);
            assert light2.getColor() == light3.getColor();
        }


}




