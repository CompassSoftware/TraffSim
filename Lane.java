/**
 *
 * @author Hayden C.
 * @version 1.0
 *
 */
public class Lane {
    
    public CarQueue queue;
    private TrafficLight light;
    private Sensor sense;
    private boolean car;
    private char tag;
    private char oppLaneTag;
    
    /** 
     * This contructor takes in a paramater for the lane tag and sets variables equal to the results of
     * prior methods.
     *
     * @param tag is a lane label that determines what direction we are working with.
     *
     */
    public Lane(char tag) {
        light = new TrafficLight();
        queue = new CarQueue();
        sense = new Sensor(queue);
        this.tag = tag;
        setOppTag();
    }

     /**
     * @return this method returns the car variable, which contains the information of whether or not there is a 
     * car at the light.
     *
     * This method gives the true or false response of whether or not there is a car present.
     *
     */
    public boolean carOnSensor() {
        car = sense.getCarOnSensor();
        return car;
    }

    /**
    * @param car which is a created object of the car class.
    *
    * This method adds a car object to the que.
    *
    */
    public void addCar(Car car) {
        queue.add(car);
    }

    /**
     * This method removes a car from the que.
     *
     */
    public void removeCar(){
        queue.remove();
    }
    
    /**
     * @param color contains the current color of the light. 
     * 
     * This method changes the color of the light.
     */
    public void setLight(char color) {
        light.setColor(color);
    }
    
    /**
     * This method gets the color of the light. 
     *
     */
    public char getLight(){
        return light.getColor();
    }
    
    /**
     * @return this method returns the tag.
     *
     * This method gets the tag variable which contains the lane name.
     *
     */
    public char getTag(){
        return tag;
    }
    
    /**
     * @return This method returns the light in string format.
     *
     */
    public String printLight(){
        return light.toString();
    }
    
    /**
     * @param This method contains the variable tag, which contains the lane specification.
     *
     * this method switches the tag to the opposite direction ex. north to south etc.
     *
     */
    public void setTag(char tag){
        this.tag = tag;
        setOppTag();
    }
    
    /**
     *
     * @return this method returns the opposite Lane tag of the current lane.
     *
     */
    public char getOppTag(){
        return oppLaneTag;
    }
    
    /**
     * This lane creates different scenarios in which every instance of the opposite lane is created.
     */
    public void setOppTag(){
        if(tag == 'N') oppLaneTag = 'S';
        else if(tag == 'S') oppLaneTag = 'N';
        else if(tag == 'E') oppLaneTag = 'W';
        else oppLaneTag = 'E'; 
    }

}
