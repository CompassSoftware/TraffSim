
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SensorTest {
   
    static Sensor sense;
    static CarList list;
    static Car car;
    static Lane lane;

    @BeforeEach
    void init() {
        list = new CarList();
        lane = new Lane('E');
        car = new Car(lane);

    }

    @Test
    public void testCarSensor() {
        
        list.add(car);
        sense = new Sensor(list);
        assertTrue(sense.getCarOnSensor());

    }

    @Test
    public void testCarSensorFalse(){
        sense = new Sensor(list);
        boolean b = list.isEmpty();
        assertFalse(b);
    }

    

}

