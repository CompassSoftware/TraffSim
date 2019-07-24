/**
 * Sensor class - checks to see if car is present.
 * @author Sam Howard
 * @version 7/23/19
 */
public class Sensor {
    
    CarQueue queue;
    boolean carOnSensor;
    
    /**
     * Class Constructor.
     * @param q queue object
     */
    public Sensor(CarQueue q) {
        this.queue = q;
    }
    
    /**
     * carPresent method.
     */
    private void carPresent() {
        if (queue.peek() == null) {
            carOnSensor = false;
        }
        else {
            carOnSensor = true;
        }
    }
    
    /**
     * getCarOnsensor method.
     * @return carOnSensor
     */
    public boolean getCarOnSensor() {
        carPresent();
        return carOnSensor;
    }

}