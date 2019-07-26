public class Timer extends Thread
{
	int timeUsed;
	boolean timeV;
	TimerClient callbackObject;

	public Timer(int millis)
	{
		timeUsed = millis;
		timeV = false;
	}
	public Timer(int millis, TimerClient client)
	{
		this(millis);
		callbackObject = client;
	}
	public void run()
	{
		try
		{
			Thread.sleep(timeUsed);
		}
		catch(Exception e)
		{
			
		}

		timeV = true;
		if (callbackObject != null) 
		{
			callbackObject.timerCallback();
		}
	}

	public boolean expired()
	{
		return timeV;
	}
	
	public void start()
	{
		//System.out.println("Starting: " + timeUsed + " Second Timer ");
		super.start();
		
	}
}
