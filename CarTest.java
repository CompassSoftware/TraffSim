import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CarTest
{

    static Car car;
    ByteArrayOutputStream out; 
    PrintStream original;

    @BeforeEach
    public void init() 
    {
        original = System.out;
        car = new Car("eastbound");
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
        assertEquals("The car has stopped at the " + car.getLoc() + " intersection" , out.toString());
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

    @Test
    public void testGo()
    {
        car.go();
        System.out.flush();
        assertEquals("The car leaves the " + car.getLoc() + " intersection" ,out.toString());
    }

}
