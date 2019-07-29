public class Timer
{

    int time;
    //getter for timer remaining on timer
    Clock clock;
    
    public Timer(int s, Clock clock)
    {
        time = s;
        this.clock = clock;
    }

    public int getTime()
    {
        return time;
    }

    public void tick(int t)
    {
        //global time incremented
        //clock.setSeconds(t);
        //decrement different time here
        time = time-t;
    }

    public void setTime(int sec)
    {
        time = sec;
    }

}
