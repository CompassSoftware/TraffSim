/**
 * 
 * Car Class.
 * 
 * @author James Brown
 * @version 1.0
 *
 */
public class Car {
    private boolean motion;
    private boolean onSensor;
    private Lane lane;
<<<<<<< HEAD
=======
    private boolean real;
>>>>>>> 8a7dfdb5b40859c450a163c0e5c66490b9bdfc35

    /**
     *  Car constructor takes a lane object and returns a car object.
     *
     *  @param lane - Lane object where the car approaches
     */
    public Car(Lane lane) {
        motion = true;
        onSensor = false;
        this.lane = lane;
<<<<<<< HEAD
        System.out.println("The car approaches the "
                + lane.getTag() + " lane of the intersection.");
=======
        if (real) System.out.println("The car approaches the "
                + lane.getTag() + " lane of the intersection.");
        real = true;
>>>>>>> 8a7dfdb5b40859c450a163c0e5c66490b9bdfc35
    }

    /**
     *  Stop orders the car to stop moving and prints where it stops.
     */
    public void stop() {
        if (lane.getLight() != 'G') {
            setMotion(false);
            setSensor(true);
            System.out.print("The car has stopped at the " 
                    + lane.getTag() + " intersection. ");
            System.out.println("The " + lane.getTag() 
                    + " Sensor has been notified");
        }
    }

    /**
     *  Go orders the car to leave the intersection and tells where it goes.
     */
    public void go() {
        if (lane.getLight() == 'G') {
            setMotion(true);
            setSensor(false);
            System.out.println("The car leaves the " 
                    + lane.getTag()  + " intersection.");
            lane.list.remove();
        }
    }

    /**
     *  getTag returns the direction of the lane.
     *
     *  @return direction of lane car is in
     */
    public char getTag() {
        return lane.getTag();
    }

    /**
     *  getMotion returns true or false if car is in motion.
     *
     *  @return t/f
     */
    public boolean getMotion() {
        return motion;
    }

    /**
     *  setMotion is set to t/f depending if the car has stopped or gone.
     *  
     *  @param bool - t/f for motion field
     */
    public void setMotion(boolean bool) {
        motion = bool;
    }

    /**
     *  returns t/f depending if the car is on a sensor.
     *
     *  @return t/f
     */
    public boolean getSensor() {
        return onSensor;
    }
    /**
     *  setSensor is used when a car approaches or leaves an intersection.
     *
     *  @param bool - true or false for when it's on a Lane sensor
     */
    public void setSensor(boolean bool) {
        onSensor = bool;
    }

    /**
     *  returns the lane object.
     *
     *  @return this car's Lane object
     */
    public Lane getLane() {
        return lane;
    }

    /**
     *  setLane sets the lane for the car.
     *
     *  @param lane - the lane where the car is at.
     */
    public void setLane(Lane lane) {
        this.lane = lane;
    }

    public void setReal(boolean real) {
        this.real = real;
    }

    public boolean getReal() {
        return real;
    }

    public Car copy(){
        Car c = new Car(lane);
        c.setMotion(motion);
        c.setSensor(onSensor);
        c.setReal(real);
        return c;
    }
}
