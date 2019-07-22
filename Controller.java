public class Controller{
 
    private Lane[] lanes;
    private int[] laneWithCar;

    public Controller(Lane[] lanes){
        this.lane = lanes;
        laneWithCar = new int[lanes.length];
        for (int i : laneWithCar)// sets array to Null val.
            i = -1;
    }

    public void lanesWithCar(){
       for (int i = 0; i < lanes.length; i++){
            if (lanes[i].carOnSensor()){ // if a car is on a sensor, add it to the set of lanes with with cars at light.
                int j = 0;
                while (laneWithCar[j] != -1) j++;
                laneWithCar[j] = i;
            }
        }
    }

    public void sendCar(int laneToSend){
        if (laneToSend.getlight() != 'G'){
            for (Lane l : lanes)
                if (l.getLight() == 'G') l.setLight('Y');
            printLights(); // make function
            
            for (Lane l : lanes)
                if (l.getLight() == 'Y') l.setLight('R');
            printLights();

            for (Lane l : lanes)
                if (lanes[laneToSend].getTag == l.getTag) l.setLight('G');

            printLights();
        }
    }

    public void printLights(){
        for (Lane l : lanes){
            System.out.println("\t" + l.printLight());
        }
    }
               
