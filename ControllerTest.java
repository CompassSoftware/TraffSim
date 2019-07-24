/** 
 * JUnit5 test class
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ControllerTest {      
     
      static Controller controller;
      static TrafficLight light;
      static Lane[] lanes;
      
      @BeforeEach
      void makeController()
      {
        lanes = new Lane[1];
        lanes[0] = new Lane('E');
        controller = new Controller(lanes);
        light = new TrafficLight();
      }

      @Test
      public void testSenseNotify() 
      {
	    assertTrue(controller.isSenseNotify());
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
}

