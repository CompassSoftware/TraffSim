/*
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PedestrianTest
{
    static Pedestrian ped;
    ByteArrayOutputStream out;
    PrintStream original;

    @BeforeEach
    public void init()
    {
        original = System.out;
        ped = new Pedestrian("southbound");
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void end()
    {
        System.setOut(original);
    }

@Test
    public void testGo()
    {
        ped.go();
        System.out.flush();
        assertEquals("Pedestrian crosses at the " + ped.getLocation() + " crosswalk" , out.toString());
    }

@Test
    public void testStop()
    {
        ped.stop();
        assertEquals("Pedestrian has stopped at the " + ped.getLocation() + " crosswalk" , out.toString());
    }

    @Test
    public void testMotion()
    {
        ped.setMotion(false);
        assertFalse(ped.getMotion());
    }

    @Test
    public void testMotion1()
    {
        ped.setMotion(true);
        assertTrue(ped.getMotion());
    }

    @Test
    public void testWait()
    {
        ped.setWait(false);
        assertFalse(ped.getWait());
    }

    @Test
    public void testWait1()
    {
        ped.setWait(true);
        assertTrue(ped.getWait());
    }

    @Test
    public void testLocation()
    {
        String loc = ped.getLocation();
        assertEquals(loc, "southbound");
    }
}
*/
