/**
 *
 * @author Hayden C.
 * @version 1.0
 *
 */
public class Lane {
    
    public CarList list;
    private TrafficLight light;
    private Sensor sense;
    private boolean car;
    private char tag;
    private char oppLaneTag;
    
    /** 
     * This contructor takes in a paramater for the 
     * lane tag and sets variables equal to the results of prior methods.
     *
     * @param tag determines what direction we are working with.
     *
     */
    public Lane(char tag) {
        light = new TrafficLight();
        list = new CarList();
        sense = new Sensor(list);
        this.tag = tag;
        setOppTag();
    }

     /**
     *
     * This method T/F if there is a car present.
     * 
     * @return returns T/F if a car is on the sensor
     *
     */
    public boolean carOnSensor() {
        car = sense.getCarOnSensor();
        return car;
    }

    /**
    * @param car which is a created object of the car class.
    *
    * This method adds a car object to the queue.
    *
    */
    public void addCar(Car car) {
        list.add(car);
    }

    /**
     * This method removes a car from the list.
     *
     */
    public void removeCar() {
        list.remove();
    }
    
    /**
     * This method changes the color of the light.
     * @param color - new color for light 
     */
    public void setLight(char color) {
        light.setColor(color);
    }
    
    /**
     * This method gets the color of the light. 
     * 
     * @return returns first char of light color
     *
     */
    public char getLight() {
        return light.getColor();
    }
    
    /**
     * This method gets the tag variable which contains the lane name.
     * 
     * @return this method returns the tag.
     */
    public char getTag() {
        return tag;
    }
   
    public void advance() {
    }     
    /**
     * Retrieves light color in string form.
     * 
     * @return This method returns the light in string format.
     */
    public String printLight() {
        return light.toString();
    }
    
    /**
     * 
     * this method switches the tag to the opposite direction 
     * Ex: north to south etc.
     *      
     * @param tag sets tag to
     */
    public void setTag(char tag) {
        this.tag = tag;
        setOppTag();
    }
    
    /**
     *
     * @return this method returns the opposite Lane tag of the current lane.
     *
     */
    public char getOppTag() {
        return oppLaneTag;
    }
    
    /**
     * This lane creates different scenarios in which 
     * every instance of the opposite lane is created.
     */
    public void setOppTag() {
        if (tag == 'N') {
            oppLaneTag = 'S';
        }
        else if (tag == 'S') {
            oppLaneTag = 'N';
        }
        else if (tag == 'E') {
            oppLaneTag = 'W';
        }
        else {
            oppLaneTag = 'E'; 
        }
    }

}
