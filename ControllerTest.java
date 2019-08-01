/** 
 * JUnit5 test class
 * 
 */

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ControllerTest {      
     
      static Controller controller;
      static Lane[] lanes;
      static Car car;
      ByteArrayOutputStream out;
      PrintStream original;

      @BeforeEach
      void makeController()
      {
    	  original = System.out;
    	  lanes = new Lane[3];
    	  lanes[0] = new Lane('E');
    	  car = new Car(lanes[0]);
    	  lanes[0].addCar(car);;
    	  controller = new Controller(lanes);
      }

      @Test
      public void testlanes() {
    	  
    	  if (controller.getLane()[0] == 1) {
    		  assertTrue(true);
    	  }
    	  else {
    		  assertFalse(false);
    	  }
      }
}

