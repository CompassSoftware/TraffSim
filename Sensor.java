/**
 * Sensor class - checks to see if car is present.
 * @author Sam Howard
 * @version 7/23/19
 */
public class Sensor {
    
    CarList carList;
    boolean carOnSensor;
    
    /**
     * Class Constructor.
     * @param q queue object
     */
    public Sensor(CarList c) {
        this.carList = c;
    }
    
    /**
     * carPresent method.
     */
    private void carPresent() {
        if (carList.peek() == null) { //change this peek() to match an arraylist method
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
