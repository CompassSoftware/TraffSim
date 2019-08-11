import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
    private boolean real;
    private String file = "out.txt";
    private PrintWriter out;
    /**
     *  Car constructor takes a lane object and returns a car object.
     *
     *  @param lane - Lane object where the car approaches
     */
    public Car(Lane lane) {
        try {
            out = new PrintWriter(file);
        motion = true;
        onSensor = false;
        this.lane = lane;
        real = true;
        if (real) out.println("The car approaches the "
                + lane.getTag() + " lane of the intersection.");
        out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Stop orders the car to stop moving and prints where it stops.
     */
    public void stop() {
        try {
            out = new PrintWriter(file);
        if (lane.getLight() != 'G') {
            setMotion(false);
            setSensor(true);
            out.print("The car has stopped at the " 
                    + lane.getTag() + " intersection. ");
           out.print("The " + lane.getTag() 
                    + " Sensor has been notified\n");
        }
        out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Go either orders the car to leave the intersection and tells where it goes,
     *  or tells it to move forward in the lane if it can.
     */
    public void go(int carspot) {
            setMotion(true);
            setSensor(false);

            try {
                out = new PrintWriter(file);
        if (lane.getLight() == 'G' || lane.getLight() == 'Y') {

            if (real){
            out.println("The car leaves the " 
                    + lane.getTag()  + " intersection.");
            }
            lane.list.remove();
        }
        else if (carspot < lane.list.size()){
                lane.list.remove(carspot);
        }

        out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
