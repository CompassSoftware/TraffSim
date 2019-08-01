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
    }

    /**
     * carPresent method.
     */
    private void carPresent() {
        if (list.peek() == null) {
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
