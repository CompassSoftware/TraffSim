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
    public static final int MINTIME = 2;
    public static final int MAXTIME = 12;


    private Timer minTimer;
    private Timer maxTimer;
    private Lane[] lanes;
    private int[] laneWithCar;

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
        minTimer = new Timer(MINTIME);
        maxTimer = new Timer(MAXTIME);
    }

    /**
     * A method to find which lanes currently have a car on their 
     * sensor. Sets lanesWithCar to the lanes that have a car in them.
     *
     */
    public void lanesWithCar(){
        for (int i = 0; i < lanes.length; i++){
            if (lanes[i].list.size() > 0){
                // if a car is on a sensor, add it to the set of lanes with with cars at light.
System.out.println("VVVVVV");
                if (lanes[i].carOnSensor()){ 
                    System.out.println("Controller notified that " + lanes[i].getTag() + " lane has a sensor that has been set off");

                    int j = 0;
                    //System.out.println(Arrays.toString(laneWithCar));
                    while (laneWithCar[j] != -1 && j < laneWithCar.length - 1) {
                        j++;
                    }
                    laneWithCar[j] = i;
                }

            }
        }
    }

    public int[] lanesNotEmpty(){
        int[] lanesNotEmpty = new int[lanes.length];
        Arrays.fill(lanesNotEmpty, -1);
        for(int i = 0; i < lanes.length; i++){
            if (lanes[i].list.size() > 0){
                int j = 0;
                for (j = 0; j < lanesNotEmpty.length && lanesNotEmpty[j] != -1; j++);

                    lanesNotEmpty[j] = i;
            }

        }
        return lanesNotEmpty;
    }

    /*
     * A method to try to send cars on a specific lane by setting all
     * other lanes to red, then this lane to green.
     *
     * @param laneToSend Lane that needs to be sent by changing light to green.
     */
    public int sendCar(int laneToSend, Clock clock) {

        boolean changed = false;
        Lane redLane = lanes[0];
        int incGlobalTime = 0;
        if (minTimer.getTime() <= 0 && laneToSend != -1){
            if( lanes[laneToSend].getLight() != 'G') {
                for (Lane l : lanes) {
                    if (l.getLight() == 'G') {
                        changed = true;
                        l.setLight('Y');
                    }
                }

                if (changed) {
                	clock.setSeconds(1);
                    incGlobalTime++;
                    System.out.println("Lights notified to change");
                    printLights();
                }

                for (Lane l : lanes)
                    if (l.getLight() == 'Y') l.setLight('R');
                if (changed){

                	clock.setSeconds(1);
                    incGlobalTime++;
                    System.out.println("Lights notified to change");
                    printLights();

                }
            }


            for (Lane l : lanes)
                if (lanes[laneToSend].getTag() == l.getTag()
                        || lanes[laneToSend].getOppTag() == l.getTag()) l.setLight('G');
            System.out.println("Lights notified to change");
            printLights();
            minTimer.setTime(MINTIME + 1);
            maxTimer.setTime(MAXTIME + 1);
        }

        if (maxTimer.getTime() <= 2){
            incGlobalTime++;
            for (Lane l : lanes){
                if (l.getLight() == 'G'){
                    changed = true;
                    l.setLight('Y');
                }
                else redLane = l;
            }
            if (changed) {
                clock.setSeconds(1);
                incGlobalTime++;                
                System.out.print("[" + clock.toString() + "]");
                System.out.println("Lights notified to change");
                printLights();
            }
            for (Lane l : lanes)
                if (l.getLight() == 'Y') l.setLight('R');
            if (changed){
                clock.setSeconds(1);
                incGlobalTime++;    
                System.out.print("[" + clock.toString() + "]");
                System.out.println("Lights notified to change");
                printLights();

            }

            redLane.setLight('G');
            for(Lane l : lanes) if (redLane.getOppTag() == l.getTag()) l.setLight('G');
            clock.setSeconds(1);
            incGlobalTime++;    
            System.out.print("[" + clock.toString() + "]");
            System.out.println("Lights notified to change");
            printLights();
            minTimer.setTime(MINTIME);
            maxTimer.setTime(MAXTIME + 1);

        }
        minTimer.tick(1);
        maxTimer.tick(1);
        return incGlobalTime;
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

    public int[] getLane() {
        return laneWithCar;
    }
}

