public class Simulator{

    public static void main (String[] args){
        run1(args);
    }

    public static void run1(String [] args){
        System.out.println("\t\t***This is a Simulation of an Eastbound Car moving into a 4-way intersection***");
        Lane[] lanes = new Lane[4];
        for (int i = 0; i < lanes.length; i++) lanes[i] = new Lane('N');
        lanes[1].setTag('W');
        lanes[2].setTag('S');
        lanes[3].setTag('E');
        Car eastCar = new Car(lanes[3]); // Eastbound Lane
        lanes[3].queue.add(eastCar);
        Controller intersectControl = new Controller(lanes);
        lanes[0].setLight('G');
        lanes[2].setLight('G');

        while (lanes[0].queue.peek() != null || lanes[1].queue.peek() != null 
                || lanes[2].queue.peek() != null || lanes[3].queue.peek() != null){ // There is a car in a lane

            intersectControl.printLights();
            eastCar.stop();
            int[] lanesWithCar = intersectControl.lanesWithCar();
            for (int laneToSend : lanesWithCar)
                if (laneToSend != -1) intersectControl.sendCar(laneToSend);
            eastCar.go();
        }
        System.out.println("No more cars on intersection");
        System.out.println("\t\t***Simulation Concluded***");
    }

    public static void run (String[] args){


        /*
         * To model different scenarios, we can just change the amount of cars and
         * the lanes they're in, but the logic below should (once finished) be run for
         * all the scenarios.
         */
        int i = 0;
        int minTimer;
        //globaltimer to stop program, otherwise runs regardless of the amount of cars remaining
        while(globaltimer > 0){
            
            /*
             * inner loop represents the ticks in a single light CYCLE. 
             * Exiting this loop means that the green lights
             * will be made red and the red lights will be made green
             *
             * REQUIRES: some method of switching to the next lane
             */
            while(minTimer > 0 && maxTimer > 0){
                intersectControl.printLights();             //always show the status of the lights
                if (head.peek() != null){                   //checks if there is a car at the front of the list
                    head.go();                              //car drives thru intersection and leaves
                    minTimer.setTime(MINTIME);              //reset mintimer because a car triggered the sensor in its lane
                }
                else
                    minTimer.tick();                        //tick minTimer only when a car does not trigger the head sensor

                maxTimer.tick();    
                carList.advance();                          //Always tick maxtimer and advance the carlist
            }
                    }
    }


}





