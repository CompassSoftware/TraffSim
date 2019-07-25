import java.util.Timer;

public class Timer
{

   private int interval;
   private Timer timer;

   public Timer()
   {
       interval = 0;
       timer = 0;
   }

   public int getTime()
   {
       return interval;
   }

   public void setTime(int interval)
   {
       this.inteval = newInterval;
   }

   public int start()
   {

       timer = new Timer(30);
       interval = 5;

       if(//controller calls for timer;)
       {
            for(int i = 30; i!= 0;i--)
            {
           timer--;

           if(timer == 25)
           {
                System.out.println("Current Time: " + time);
           }
           if(timer == 20)
           {
                System.out.println("Current Time: " + time);
           }
           if(timer == 15)
           {
                System.out.println("Current Time: " + time);
           }
           if(timer == 10)
           {
                System.out.println("Current Time: " + time);
           }
           if(timer == 5)
           {
                System.out.println("Current Time: " + time);
           }
            }
           if(timer == 0)
           {
               System.out.println("Current Time: " + time);
               timer.cancel();
           }
             }

       }

   }

}
