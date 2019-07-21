/*
 * Sensor class.
 */
public class sensor {

    CarQueue queue
    boolean carOnSensor;
    Car car;

    public sensor(Queue q) {
        this.queue = q;
        car = new Car();
    }

    public void carPresent() {
        if (!car.getSensor()) {
            car = false;
        }
        car = true;
    }

}
        

