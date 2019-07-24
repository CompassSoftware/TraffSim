import java.util.Arrays;
/**
 * Controller Class.
 * 
 * A class to control the lanes's traffic lights by taking
 * information from the lane's sensor and computing sequence
 * to get all cars through intersection.
 * 
 * @author JEBro
 * @version 1.0
 * 
 * 07/21/2019
 */
public class Controller {
 
    private Lane[] lanes;
    private int[] laneWithCar;

    /**
     * Constructor for Controller class takes in a set of lanes.
     * Initializes lanes array to the one passed in and initialized laneWithCar
     * to a Null value
     *
     * @param lanes set of lanes controller is associated to.
     */
    public Controller(Lane[] lanes) {
        this.lanes = lanes;
        laneWithCar = new int[lanes.length];
        // sets array to Null value
        Arrays.fill(laneWithCar, -1); 
    }

    /**
     * A method to find which lanes currently have a car on their 
     * sensor. Sets lanesWithCar to the lanes that have a car in them.
     *
     * @return an int array of lanes with a car in them.
     */
    public int[] lanesWithCar() {
        for (int i = 0; i < lanes.length; i++) {
    	    // if a car is on a sensor
        	//add it to the set of lanes with with cars at light.
            if (lanes[i].carOnSensor()) { 
                System.out.println("Controller notified that " + lanes[i]
                		.getTag() + " lane has a sensor that has been set off");
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
    
    /**
     * A method to try to send cars on a specific lane by setting all
     * other lanes to red, then this lane to green.
     *
     * @param laneToSend Lane that needs to be sent by changing light to green.
     */
    public void sendCar(int laneToSend) {
        boolean changed = false;
        if (lanes[laneToSend].getLight() != 'G') {
            for (Lane l : lanes) {
                if (l.getLight() == 'G') {
                    changed = true;
                    l.setLight('Y');
                }
            }
            
            if (changed) {
                System.out.println("Lights notified to change");
                printLights(); 
            }
        }
        
        for (Lane l : lanes) {
            if (l.getLight() == 'Y') {
            	l.setLight('R');
            }
        }
        
        if (changed) {
            System.out.println("Lights notified to change");
            printLights();
        }

        for (Lane l : lanes) {
            if (lanes[laneToSend].getTag() == l.getTag()
                    || lanes[laneToSend].getOppTag() == l.getTag()) {
                l.setLight('G');
            }
            System.out.println("Lights notified to change");
            printLights();
        }
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
               
