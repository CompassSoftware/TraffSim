/*
 * Sensor class.
 */
public class sensor {

    CarQueue queue;
    boolean carOnSensor;

    public sensor(CarQueue q) {
        this.queue = q;
    }

    private void carPresent() {
        if (queue.peek() == null) {
            carOnSensor = false;
        }
        else carOnSensor = true;
    }

    public boolean getCarOnSensor(){
        carPresent();
        return carOnSensor;
    }

}
