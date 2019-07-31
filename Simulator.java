import java.util.Scanner;

public class Simulator{

	Scanner s = new Scanner(System.in);
	String str;
			
    public static void main (String[] args){
    	do {
    		System.out.println("run - No Car sim");
        	System.out.println("run1 - Eastbound Car (issue 1)");
        	System.out.println("help - Print again");
        	str = s.nextLine();
    	} while (str == "help");

    	if (str == "run") {
    		run(args);
    	} else if (str == "run1") {
    		run1(args);
    	}
    }

    //public static void run1(String [] args){
    //    System.out.println("\t\t***This is a Simulation of an Eastbound Car moving into a 4-way intersection***");
    //    Lane[] lanes = new Lane[4];
    //    for (int i = 0; i < lanes.length; i++) lanes[i] = new Lane('N');
    //    lanes[1].setTag('W');
    //    lanes[2].setTag('S');
    //    lanes[3].setTag('E');
    //    Car eastCar = new Car(lanes[3]); // Eastbound Lane
    //    lanes[3].queue.add(eastCar);
    //    Controller intersectControl = new Controller(lanes);
    //    lanes[0].setLight('G');
    //    lanes[2].setLight('G');

    //    while (lanes[0].queue.peek() != null || lanes[1].queue.peek() != null 
    //            || lanes[2].queue.peek() != null || lanes[3].queue.peek() != null){ // There is a car in a lane

    //        intersectControl.printLights();
    //        eastCar.stop();
    //        int[] lanesWithCar = intersectControl.lanesWithCar();
    //        for (int laneToSend : lanesWithCar)
    //            if (laneToSend != -1) intersectControl.sendCar(laneToSend);
    //        eastCar.go();
    //    }
    //    System.out.println("No more cars on intersection");
    //    System.out.println("\t\t***Simulation Concluded***");
    //}

    public static void run (String[] args){
        System.out.println("\t\t***This is a Simulation of an Eastbound Car moving into a 4-way intersection***");

        //Set up all lanes and controller, north and south lanes start as green

        Lane[] lanes = new Lane[4];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Lane('N');
        }
        lanes[1].setTag('W');
        lanes[2].setTag('S');
        lanes[3].setTag('E');
        Controller intersectControl = new Controller(lanes);
        lanes[0].setLight('G');
        lanes[2].setLight('G');


        /*
         * To model different scenarios, we can just change the amount of cars and
         * the lanes they're in, but the logic below should (once finished) be run for
         * all the scenarios.
         */


        Car eastCar = new Car(lanes[3]);
        Car northCar = new Car(lanes[0]);
        lanes[3].list.add(eastCar);
        lanes[0].list.add(northCar);

        int i = 0;


        Clock clock = new Clock();       
        Timer minTimer = new Timer(intersectControl.MINTIME, clock);
        Timer maxTimer = new Timer(intersectControl.MAXTIME, clock);
        Timer globalTimer = new Timer(6, clock);



        //globaltimer to stop program, otherwise runs regardless of the amount of cars remaining
        while(globalTimer.getTime() > 0){
            Lane currlane = lanes[i%4];
            minTimer.setTime(intersectControl.MINTIME);
            maxTimer.setTime(intersectControl.MAXTIME);


            /*
             * inner loop represents the ticks in a single light CYCLE. 
             * Exiting this loop means that the green lights
             * will be made red and the red lights will be made green
             *
             * REQUIRES: some method of switching to the next lane
             */
            while(minTimer.getTime() > 0 && maxTimer.getTime() > 0 && globalTimer.getTime() > 0){
                intersectControl.printLights();             //always show the status of the lights
                if (currlane.list.size() > 0){
                    if (currlane.list.peek() != null){     //checks if there is a car at the front of the list
                        currlane.list.peek().go();                //car drives thru intersection and leaves
                        minTimer.setTime(intersectControl.MINTIME);              //reset mintimer because a car triggered the sensor in its lane
                    }
                }
                minTimer.tick(1);
                maxTimer.tick(1);
                globalTimer.tick(1);    
                currlane.list.advance();                     //Always tick and advance the carlist
            }

            intersectControl.sendCar((i+1)%4);
            i++;
        }
    }


}




