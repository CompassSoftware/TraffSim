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
        time = time-t;
    }

    public void setTime(int sec)
    {
        time = sec;
    }

}
