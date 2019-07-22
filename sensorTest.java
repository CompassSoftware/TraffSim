//import org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class sensorTest {
   
    sensor sense;

    @BeforeEach
    void init() {
        sense = new sensor();
    }

    @Test
    public void testCarSensor() {
        
        assertTrue(sense.CarSensor(true));

    }

    @Test
    public void testPedSensor() {
        assertTrue(sense.Pedestrian(true));
    }


}
