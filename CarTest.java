
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;

/**
 * 
 * CarTest Class.
 * 
 * @author -
 * @version 1.0
 *
 */
public class CarTest {

    static Car car;
    static Lane lane;
    ByteArrayOutputStream out; 
    PrintStream original;

    @BeforeEach
        public void init() {
            original = System.out;
            lane = new Lane('E');
            lane.list.add(new Car(lane));
            car = new Car(lane);
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
        }

    @AfterEach
        public void end()
        {
            System.setOut(original);
        }

    @Test
<<<<<<< HEAD
        public void testStop()
        {
            car.stop();
            assertEquals("The car has stopped at the " + car.getTag() + " intersection. The " + car.getTag()  + " Sensor has been notified\n" , out.toString());
        }

    @Test
        public void testGo()
        {
            lane.setLight('G');
            car = new Car(lane);
            car.go();
            assertEquals("The car approaches the " + car.getTag() + " lane of the intersection.\nThe car leaves the " + car.getTag() + " intersection.\n" , out.toString());
        }
=======
    public void testStop()
    {
        car.stop();
        assertEquals("The car has stopped at the " + car.getTag() + " intersection. "
        		+ "The " + car.getTag()  + " Sensor has been notified\n" , out.toString());
    }

    @Test
    public void testGo()
    {
        lane.setLight('G');
        car = new Car(lane);
        car.go();
        assertEquals("The car leaves the " + car.getTag() + " intersection.\n" , out.toString());
    }
>>>>>>> 8a7dfdb5b40859c450a163c0e5c66490b9bdfc35

    @Test
        public void testMotion()
        {
            car.setMotion(false);
            assertFalse(car.getMotion());
        }

    @Test
        public void testMotion1()
        {
            car.setMotion(true);
            assertTrue(car.getMotion());
        }

    @Test
        public void testSensor()
        {
            car.setSensor(false);
            assertFalse(car.getSensor());
        }

    @Test
        public void testSensor1()
        {
            car.setSensor(true);
            assertTrue(car.getSensor());
        } 
}


