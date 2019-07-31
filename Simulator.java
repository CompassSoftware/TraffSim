public class Simulator{

    public static void main (String[] args){
        run(args);
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

        Car nonEastCar = new Car(lanes[3]); // creates empty car objects to be inserted
        Car nonWestCar = new Car(lanes[1]); // into CarList
        Car nonSouthCar = new Car(lanes[2]);
        Car nonNorthCar = new Car(lanes[0]);

        nonEastCar.setReal(false); // makes all non cars not real
        nonWestCar.setReal(false);
        nonSouthCar.setReal(false);
        nonNorthCar.setReal(false);

        lanes[0].addCar(nonNorthCar); // puts an empty car into each lane
        lanes[1].addCar(nonWestCar);
        lanes[2].addCar(nonSouthCar);
        lanes[3].addCar(nonEastCar);

        //Car eastCar = new Car(lanes[3]);
        //Car northCar = new Car(lanes[0]);
        //lanes[3].addCar(eastCar);
        //lanes[0].list.add(northCar);


        Clock clock = new Clock();       
        Timer globalTimer = new Timer(35);
        int tickTime = 1;
        int[] lanesWithCar;
        System.out.print("[" + clock.toString() + "] ");
        intersectControl.printLights();
        int incGlobalTime = 0;
        //globaltimer to stop program, otherwise runs regardless of the amount of cars remaining

        lanesWithCar = intersectControl.lanesWithCar();

        while(globalTimer.getTime() > 0){
            for (int laneToSend : lanesWithCar){
                clock.setSeconds(tickTime);
                System.out.print("[" + clock.toString() + "]");
                intersectControl.printLights();
                incGlobalTime = intersectControl.sendCar(laneToSend, clock);
                globalTimer.tick(tickTime + incGlobalTime);
                //System.out.println();
            }
        }
    }


}



