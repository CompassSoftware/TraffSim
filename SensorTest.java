
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
<<<<<<< HEAD
        public void testCarSensorFalse(){
            sense = new Sensor(list);
            assertFalse(sense.getCarOnSensor());
        }

=======
    public void testCarSensorFalse(){
        sense = new Sensor(list);
        boolean ok = false;
        if (sense.list.listFull()) {ok = true;}
        assertTrue(ok);
    }
>>>>>>> 8a7dfdb5b40859c450a163c0e5c66490b9bdfc35


}

