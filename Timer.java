import java.util.Timer;
import java.lang.Thread;

public class Timer extends Thread
{

   private int time;
   private boolean sentinal;

   public Timer(int s)
   {
       this.time = s;
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
