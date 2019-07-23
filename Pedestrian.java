public class Pedestrian
{
    private boolean motion;
    private boolean wait;
    private String loc;
    
    /*
     *  Constructor returns a Pedestrian object with a direction set.
     *
     *  @param loc - direction the Pedestrian wishes to travel
     */
    public Pedestrian(String loc)
    {
        //may need a class for crosswalks
        motion = false;
        wait = true;
        location = loc;
    }
    
    /*
     *  Orders the Pedestrian to stop and prints where they stopped.
     */
    public void stop()
    {
        setMotion(false);
        setWait(true);
        System.out.print("Pedestrian has stopped at the " + location  + " crosswalk");
    }

    /*
     * Orders the Pedestrian to cross the crosswalk.
     */
    public void go()
    {
        setMotion(true);
        setWait(false);
        System.out.print("Pedestrian crosses at the " + location + " crosswalk");
    }
    
    /*
     *  returns t/f if the pedestrian is in motion.
     *
     *  @return t/f
     */
    public boolean getMotion()
    {
        return motion;
    }

    /*
     *  Sets motion to t/f determining if the Pedestrian is in motion.
     *
     *  @param bool - t/f depending on Pedestrian's action
     */
    public void setMotion(boolean bool)
    {
        motion = bool;
    }
    
    /*
     *  returns t/f if Pedestrian is at crosswalk or not.
     *
     *  @return t/f if Ped. is waiting
     */
    public boolean getWait()
    {
        return wait;
    }

    /* 
     *  Sets wait to t/f depending if the Pedestrian is in motion or not.
     *
     *  @param bool - t/f depending on who is calling it.
     */
    public void setWait(boolean bool)
    {
        wait = bool;
    }

    /*
     *  returns a String that is the direction of the Pedestrian
     *
     *  @return String of direction
     */
    public String getLocation()
    {
        return location;
    }
}  
