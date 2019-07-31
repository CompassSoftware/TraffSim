import java.util.Arrays;
/**
 * Controller Class.
 * 
 * A class to control the lanes's traffic lights by taking
 * information from the lane's sensor and computing sequence
 * to get all cars through intersection.
 * 
 * @author -
 * @version 1.0
 * 
 * 07/21/2019
 */
public class Controller{
    public static int QUICKESTCYCLE = 4;
    public static int QUICKCYCLE = 8;
    public static int MAXTIME = 12;


    private Lane[] lanes;
    private int[] laneWithCar;
    private Clock clock;

    /**
     * Constructor for Controller class takes in a set of lanes.
     * Initializes lanes array to the one passed in and initialized laneWithCar
     * to a Null value
     *
     * @param lanes set of lanes controller is associated with.
     */
    public Controller(Lane[] lanes) {
        this.lanes = lanes;
        laneWithCar = new int[lanes.length];
        // sets array to Null value
        Arrays.fill(laneWithCar, -1);

        Timer maxtimer, difftimer, globaltimer;
        maxtimer = new Timer(MAXTIME);
        difftimer = new Timer(QUICKCYCLE);
        globaltimer = new Timer(48);

        clock = new Clock(maxtimer, difftimer, globaltimer); 
    }

    /**
     * A method to find which lanes currently have a car on their 
     * sensor. Sets lanesWithCar to the lanes that have a car in them.
     *
     * @return an int array of lanes with a car in them.
     */
    public int[] lanesWithCar(){
        for (int i = 0; i < lanes.length; i++){
            if (lanes[i].carOnSensor()){ // if a car is on a sensor, add it to the set of lanes with with cars at light.
                System.out.println("Controller notified that " + lanes[i].getTag() + " lane has a sensor that has been set off");

                int j = 0;
                //System.out.println(Arrays.toString(laneWithCar));
                while (laneWithCar[j] != -1 && j < laneWithCar.length - 1) {
                    j++;
                }
                laneWithCar[j] = i;
            }
        }
        return laneWithCar;
    }

    public void fullCylce(int laneToSend){

        switch (lanes[laneToSend].getTag()){

            case 'R':
                toGreen(laneToSend);
                printLights();
                toYellow(laneToSend+1);
                clock.tick();
                printLights();
                toRed(laneToSend+1);

                clock.tick();
                printLights();


                break;

        }
    }

    /*
     * ??
     *
     * @param laneToSend Lane that needs to be sent by changing light to green.
     */
    public void toYellow(int laneToSend) {
        Lane opp;
        for (int i; i < 3; i++){
            if (lanes[i].getTag() == lanes[laneToSend].getOppTag())
                opp = lanes[laneToSend];
        }

        if (lanes[laneToSend].getLight() == 'G'){
            lanes[laneToSend].setLight('Y');
            opp.setLight('Y');
            System.out.println("Lights notified to change");
            printLights();

            //tick clock somehow?
            clock.tick();
        }

        else{
            if (lanes[laneToSend].getLight() == 'Y')
                color = "YELLOW";
            else
                color = "RED";

            System.out.println("Incorrect cycle call:-\n\tExpected light color: Green"
                    + "\n\tActual light color: " + color);
            System.exit(0);
        }


        /*
         * ??
         *
         * @param laneToSend Lane that needs to be sent by changing light to green.
         */
        public void toGreen(int laneToSend) {
            Lane opp;
            for (int i; i < 3; i++){
                if (lanes[i].getTag() == lanes[laneToSend].getOppTag())
                    opp = lanes[laneToSend];
            }

            if (lanes[laneToSend].getLight() == 'R'){
                lanes[laneToSend].setLight('G');
                opp.setLight('G');
                System.out.println("Lights notified to change");
                printLights();

                //tick clock somehow?
                clock.tick();
                else{
                    if (lanes[laneToSend].getLight() == 'Y')
                        color = "YELLOW";
                    else
                        color = "RED";

                    System.out.println("Incorrect cycle call:-\n\tExpected light color: Green"
                            + "\n\tActual light color: " + color);
                    System.exit(0);
                }


            }
            /*
             * ??
             *
             * @param laneToSend Lane that needs to be sent by changing light to green.
             */
            public void toRed(int laneToSend) {
                Lane opp;
                for (int i; i < 3; i++){
                    if (lanes[i].getTag() == lanes[laneToSend].getOppTag())
                        opp = lanes[laneToSend];
                }

                if (lanes[laneToSend].getLight() == 'Y'){
                    lanes[laneToSend].setLight('R');
                    opp.setLight('R');
                    System.out.println("Lights notified to change");
                    printLights();

                    //tick clock somehow?
                    clock.tick();
                    else{
                        if (lanes[laneToSend].getLight() == 'Y')
                            color = "YELLOW";
                        else
                            color = "RED";

                        System.out.println("Incorrect cycle call:-\n\tExpected light color: Green"
                                + "\n\tActual light color: " + color);
                        System.exit(0);
                    }


                }

                //  boolean changed = false;
                //  if (lanes[laneToSend].getLight() != 'G') {
                //      for (Lane l : lanes) {
                //          if (l.getLight() == 'G') {
                //              changed = true;
                //              l.setLight('Y');
                //          }
                //      }

                //      for (Lane l : lanes)
                //          if (l.getLight() == 'Y') l.setLight('R');
                //      if (changed){
                //          System.out.println("Lights notified to change");
                //          printLights();

                //      }
                //  }

                //  if (changed) {
                //      System.out.println("Lights notified to change");
                //      printLights();
                //  }

                //  for (Lane l : lanes)
                //      if (lanes[laneToSend].getTag() == l.getTag()
                //              || lanes[laneToSend].getOppTag() == l.getTag()) l.setLight('G');

                //  System.out.println("Lights notified to change");
                //  printLights();
            }


            /**
             * Method that prints the states of each lanes light.
             */
            public void printLights() {
                for (Lane l : lanes) {
                    System.out.print("\t" + l.getTag() + " " + l.printLight());
                }
                System.out.println();
            }
        }

