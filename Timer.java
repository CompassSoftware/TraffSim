public class Timer
{

    int time;
<<<<<<< HEAD
    //getter for timer remaining on timer
    Clock clock;

    public Timer(int s, Clock clock)
=======
    
    public Timer(int s)
>>>>>>> 8a7dfdb5b40859c450a163c0e5c66490b9bdfc35
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
