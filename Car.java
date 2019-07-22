public class Car
{
    private boolean motion;
    private boolean onSensor;
    private Lane lane;

    //might need to pass a Lane object for location.
    public Car(Lane lane)
    {
        motion = true;
        onSensor = false;
        this.lane = lane;
      
        System.out.println("The car approaches the " + lane.getTag() + " lane of the intersection.");
    }

    public void stop()
    {
        if (lane.getLight() != 'G'){
            setMotion(false);
            setSensor(true);
            System.out.println("The car has stopped at the " + lane.getTag() + " intersection");
            System.out.println("The " + lane.getTag() + " Sensor has been notified");
        }
    }

    public void go()
    {
        if (lane.getLight() == 'G'){
            setMotion(true);
            setSensor(false);
            System.out.println("The car leaves the " + lane.getTag()  + " intersection");
            lane.queue.remove();
        }
    }

    public boolean getMotion()
    {
        return motion;
    }

    public void setMotion(boolean bool)
    {
        motion = bool;
    }

    public boolean getSensor()
    {
        return onSensor;
    }

    public void setSensor(boolean bool)
    {
        onSensor = bool;
    }

    public Lane getLane()
    {
        return lane;
    }

    public void setLane(Lane lane)
    {
        this.lane = lane;
    }
}
