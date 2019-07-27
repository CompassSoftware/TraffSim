/** 
 * JUnit5 test class
 * 
 *

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ControllerTest {      
     
      static Controller controller;
      static TrafficLight light;
      static Lane[] lanes;
      static Car car;

      @BeforeEach
      void makeController()
      {
        lanes = new Lane[1];
        lanes[0] = new Lane('E');
        car = new Car(lanes[0])
        controller = new Controller(lanes);
        light = new TrafficLight();
      }

      @Test
      public void testlanesWithCar() 
      {
        int[] j;
        boolean b = false;
        lanes[0].addCar(car);

        j = controller.lanesWithCar();
        for (int i : j) {
            if (j[i] != 0)
        }

        assertTrue();
      }
      
      @Test
      public void testLightNotify()
      {
        assertTrue(controller.isLightNotiy());
      }

      @Test
      public void testSendNotifyLight(){
         controller.sigLight(light, "yelllow");
         assertEquals(light.getColor(), YELLOW);
      }
}*/

