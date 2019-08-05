import java.util.Scanner;

public class Simulator{

    static Scanner s = new Scanner(System.in);
    static String str;

    public static void main (String[] args){
        do {
            do {
                System.out.println("run - No Car sim");
                System.out.println("run1 - Eastbound Car (issue 1)");
                System.out.println("help - Print again");
                System.out.println("quit - Exits program");
                System.out.print("\nInput Needed: ");
                str = s.nextLine();
                str.trim();       	
            } while (str.compareTo("help") == 0);

            if (str.compareTo("run") == 0) {
                run(args);
            }
            else if (str.compareTo("run1") == 0) {
                run1(args);
            }
            else if (str.compareTo("quit") == 0);
            else {
                System.out.println("No valid input.");
            }
        } while(str.compareTo("quit") != 0);
    }


    public static void run1(String [] args){
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

        Car nonWestCar = new Car(lanes[1]); // into CarList
        Car nonSouthCar = new Car(lanes[2]);

        nonWestCar.setReal(false);
        nonSouthCar.setReal(false);

        // puts empty cars into each lane
        for(int i = 0; i < 4; i++) lanes[1].addCar(nonWestCar);
        for(int i = 0; i < 4; i++) lanes[2].addCar(nonSouthCar);

        Car eastCar = new Car(lanes[3]);
        Car northCar = new Car(lanes[0]);
        lanes[3].addCar(eastCar);           
        lanes[0].addCar(northCar);


        Clock clock = new Clock();       
        Timer globalTimer = new Timer(5);
        int tickTime = 1;
        int[] lanesWithCar;
        System.out.print("[" + clock.toString() + "] ");
        intersectControl.printLights();
        int incGlobalTime = 0;
        //globaltimer to stop program, otherwise runs regardless of the amount of cars remaining

        lanesWithCar = intersectControl.getLane();

        while(globalTimer.getTime() > 0){

            for (int laneToSend : lanesWithCar){
                clock.setSeconds(tickTime);
                System.out.print("[" + clock.toString() + "]");
                intersectControl.printLights();
                incGlobalTime = intersectControl.sendCar(laneToSend, clock);

                /*Looks at every lane with size > 0*/
                int[] lanesNotEmpty = intersectControl.lanesNotEmpty();
                for (int currlane : lanesNotEmpty){
                    if (currlane != -1){

                        CarList list = lanes[currlane].list;
                        int blankcar = 0;
                        for(blankcar = 0; blankcar < list.size() && list.get(blankcar).getReal(); blankcar++);

                        //logic in car.go should handle every permutation for this call
                        list.peek().go(blankcar);                   
                    }
                }

            }
            globalTimer.tick(tickTime + incGlobalTime);
            //System.out.println();

        }            




        System.out.println("No more cars on intersection");
        System.out.println("\t\t***Simulation Concluded***");
    }

    public static void run (String[] args){
        System.out.println("\t\t***This is a simulation of a 4-way intersection w/ no cars.***");

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

        lanesWithCar = intersectControl.getLane();

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
        System.out.println("\t\t***Simulation Concluded***");
    }
}
