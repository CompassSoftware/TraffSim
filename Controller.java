import java.util.Arrays;

public class Controller{
 
    private Lane[] lanes;
    private int[] laneWithCar;

    public Controller(Lane[] lanes){
        this.lanes = lanes;
        laneWithCar = new int[lanes.length];
        Arrays.fill(laneWithCar, -1); // sets array to Null val.
    }

    public int[] lanesWithCar(){
       for (int i = 0; i < lanes.length; i++){
            if (lanes[i].carOnSensor()){ // if a car is on a sensor, add it to the set of lanes with with cars at light.
                System.out.println("Controller notified that " + lanes[i].getTag() + " lane has a sensor that has been set off");
                int j = 0;
                //System.out.println(Arrays.toString(laneWithCar));
                while (laneWithCar[j] != -1 && j < laneWithCar.length - 1) j++;
                laneWithCar[j] = i;
            }
        }
        return laneWithCar;
    }

    public void sendCar(int laneToSend){
        boolean changed = false;
        if (lanes[laneToSend].getLight() != 'G'){
            for (Lane l : lanes)
                if (l.getLight() == 'G'){
                    changed = true;
                     l.setLight('Y');
                }
            if (changed){
                System.out.println("Lights notified to change");
                printLights(); 
            }
            
            for (Lane l : lanes)
                if (l.getLight() == 'Y') l.setLight('R');
            if (changed){
                System.out.println("Lights notified to change");
                 printLights();
            }

            for (Lane l : lanes)
                if (lanes[laneToSend].getTag() == l.getTag()
                    || lanes[laneToSend].getOppTag() == l.getTag()) l.setLight('G');
            System.out.println("Lights notified to change");
            printLights();
        }
    }

    public void printLights(){
        for (Lane l : lanes){
            System.out.print("\t" + l.getTag() + " " + l.printLight());
        }
        System.out.println();
    }
}
               
