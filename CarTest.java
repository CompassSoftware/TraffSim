
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CarTest
{

    static Car car;
    static Lane lane;
    ByteArrayOutputStream out; 
    PrintStream original;

    @BeforeEach
    public void init() 
    {
        original = System.out;
        lane = new Lane('E');
        lane.queue.add(new Car(lane));
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


