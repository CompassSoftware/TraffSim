public class Pedestrian
{
    private boolean motion;
    private boolean wait;
    private String location;

    public Pedestrian(String loc)
    {
        motion = false;
        wait = true;
        location = loc;
    }
    
    public void stop ()
    {
        setMotion(false);
        setWait(true);
        System.out.println("Pedestrian has stopped at the " + location  + " crosswalk");
    }

    public void go()
    {
        setMotion(true);
        setWait(false);
        System.out.println("Pedestrian crosses at  the " + location + " crosswalk");
    }
    
    public boolean getMotion()
    {
        return motion;
    }

    public void setMotion(boolean bool)
    {
        motion = bool;
    }

    public boolean getWait()
    {
        return wait;
    }

    public void setWait(boolean bool)
    {
        wait = bool;
    }

    public String getLocation()
    {
        return location;
    }
}  
