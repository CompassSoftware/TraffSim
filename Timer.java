public class Timer
{

    int time;
    
    
    public Timer(int s)
    {
        time = s;
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
