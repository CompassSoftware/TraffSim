/**
 * Sensor class - checks to see if car is present.
 * @author Sam Howard
 * @version 7/23/19
 */
public class Sensor {
    
    CarList list;
    boolean carOnSensor;
    
    /**
     * Class Constructor.
     * @param q queue object
     */
    public Sensor(CarList l) {
        list = l;
        carOnSensor = false;
    }
    
    /**
     * carPresent method.
     */
    private void carPresent() {
        if (list.isEmpty()){
            carOnSensor = false;
        }
        else if (!list.peek().getReal()) {
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
    
    public void set() {
        carOnSensor = true;
    }
}
