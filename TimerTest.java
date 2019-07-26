interface TimerClient {
	public void timerCallback();
}

public class TimerTest implements TimerClient
{
	double numSeconds = 4.5;
	double pollDelay = 0.25;
	int numPolls = 0; 
	int numExpectedPolls = (int)(numSeconds / pollDelay) - 1; // last poll will work!
	boolean timerExpired = false;

 	public void timerCallback() {
		timerExpired = true;
	}	
	public static void main(String[] args)
	{
		TimerTest test = new TimerTest();
		test.runPollTest();

		test.runInterruptTest();
	}
	public void runPollTest() {
		pollDelay *= 1000;
		System.out.println("Testing using poll method:");
		System.out.println("\tTest will sleep for " 
					+ pollDelay + "ms then poll timer to see if expired.");
		System.out.println("\tEach poll will print a dot.");

		System.out.println("\tCreating " + numSeconds + " second timer...");		
		Timer t = new Timer((int)(numSeconds*1000));

		System.out.println("\tStarting timer...");
		System.out.print("\t");
		t.start();

		while(true)
		{
			try
			{
				Thread.sleep((int)pollDelay);
				
			}
			catch(Exception e)
			{
			}

			if(! t.expired())
			{
				numPolls++;
				System.out.print(".");
			}
			else
			{
				break;
			}
		}
		System.out.println();
		System.out.println("\tNumber of polls was " + numPolls);	
		System.out.println("\tNumber of expected polls was " + numExpectedPolls);	
		if (numExpectedPolls == numPolls)
			System.out.println("Poll Test PASSED!");
		else if (numExpectedPolls-1 <= numPolls && numPolls <= numExpectedPolls+1) 
			System.out.println("Poll Test PASSED! (small timing variance between threads is allowed)");
		else	
			System.out.println("Poll Test FAILED!");
	}

	public void runInterruptTest() {
		numPolls = 0;
		System.out.println("Testing using interrupt method:");
		System.out.println("\tTest will sleep for " 
					+ pollDelay + "ms and then awake and print a dot.");
		System.out.println("\tWhen timer expires it will interrupt causing sleeping to stop.");

		System.out.println("\tCreating " + numSeconds + " second timer...");		
		Timer t = new Timer((int)(numSeconds*1000), this); // pass object with callback method

		System.out.println("\tStarting timer...");
		System.out.print("\t");
		t.start();

		while(! timerExpired)
		{
			try
			{
				Thread.sleep((int)pollDelay);
				
			}
			catch(Exception e)
			{
			}

			numPolls++;
			System.out.print(".");
		}
		System.out.println();
		System.out.println("\tNumber of sleeps was " + numPolls);	
		System.out.println("\tNumber of expected sleeps was " + numExpectedPolls);	
		if (numExpectedPolls == numPolls)
			System.out.println("Interrupt Test PASSED!");
		else if (numExpectedPolls-1 <= numPolls && numPolls <= numExpectedPolls+1) 
			System.out.println("Interrupt Test PASSED! (small timing variance between threads is allowed)");
		else	
			System.out.println("Interrupt Test FAILED!");
	}
}
