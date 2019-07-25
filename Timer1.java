public class Timer1 extends Thread
{

    int time;
    boolean sentinal;

    public Timer1(int s)
    {
        time = s;
        sentinal = false;
    }

    public int start()
    {
        
        try
        {   
            Thread.sleep(time*1000);
        }
        catch(Exception e)
        {

        }

        
        sentinal = true;

    }

}
