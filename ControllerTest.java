/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ControllerTest {      
     
      Calculator controller;
      TrafficLight light;
      
      @BeforeEach
      void makeController(){
        controller = new Controller();
        light = TrafficLight();
      }

      @Test
      public void testSenseNotify() {
	    assertTrue(controller.isSenseNotify());
      }
      
      @Test
      public void testLightNotify() {
        assertTrue(controller.isLightNotiy());
      }

      @Test
      public void testSendNotifyLight() {
         controller.sigLight(light, "yelllow");
         assertEquals(light.getColor(), YELLOW);
      }
}
