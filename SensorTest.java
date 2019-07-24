
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SensorTest {
   
    static Sensor sense;
    static CarQueue q;
    static Car car;

    @BeforeEach
    void init() {
        q = new CarQueue();
        car = new Car();

    }

    @Test
    public void testCarSensor() {
        
        q.add(car);
        sense = new Sensor(q);
        assertTrue(sense.getCarOnSensor());

    }

    @Test
    public void testCarSensorFalse(){
        sense = new Sensor(q);
        assertFalse(sense.getCarOnSensor());
    }

    

}

