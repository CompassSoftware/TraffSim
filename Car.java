public class Car
{
    private boolean motion;
    private boolean onSensor;
    private String location;

    //might need to pass a Lane object for location.
    public Car()
    {
        motion = true;
        onSensor = false;
        location = null;
    }

    public void stop()
    {
        setMotion(false);
        setSensor(true);
        System.out.print("The car has stopped at the" + location + " intersection");
    }

    public void go()
    {
        setMotion(true);
        setSensor(false);
        System.out.print("The car leaves the" + location  + "intersection");
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
}
