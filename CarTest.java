import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;

public class CarTest 
{

    Car car;
    ByteArrayOutputStream 

    @BeforeEach
    void init() 
    {
        car = new car();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }


    @Test
    public void testStop()
    {
        //needs to be changed so that it takes the location and prints it.
        car.stop();
        assertEquals("The car has stopped at... " ,out.toString());
    }

    @Test
    public void testMotion()
    {
        assertFalse(car.getMotion());
    }

    @Test
    public void testMotion1()
    {
        car.setMotion();

        assertTrue(car.getMotion());
    }

    @Test
    public void testSensor
    {
        assertFalse(car.getSensor());
    }

    @Test
    public void testSensor1()
    {
        car.setSensor();
        assertTrue(car.getSensor());
    }

    @Test
    public void testGo()
    {
        //change so it takes direction from location? or direction
        car.go();
        assertEquals("The car leaves the intersection going... " ,out.toString());
    }

}
