
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SensorTest {
   
    static Sensor sense;
    static CarQueue q;
    static Car car;
    static Lane lane;

    @BeforeEach
    void init() {
        q = new CarQueue();
        lane = new Lane('E');
        car = new Car(lane);

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

