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
    public static void run2(String args[]){
        System.out.println("\t\t***This is a Simulation of an Eastbound Car moving into a 4-way intersection***");
        Lane[] lanes = new Lane[4];
        for (int i = 0; i < lanes.length; i++){
             lanes[i] = new Lane('N');
        }
        //modify lanes class to have timer field
        //modify controller to have a maxtimer field
        lanes[1].setTag('W');
        lanes[2].setTag('S');
        lanes[3].setTag('E');
        Car eastCar = new Car(lanes[3]); // Eastbound Lane
        lanes[3].queue.add(eastCar);
        Car northCar = new Car(lanes[0]);
        lanes[0].queue.add(northCar);
        Controller intersectControl = new Controller(lanes);
        lanes[0].setLight('G');
        lanes[2].setLight('G');

        
        

        while(/*maxTimer.getTime() > 0*/){
intersectControl.printlights();
/*NOTE: PSEUDOCODE
 * I currently don't know how the program does light changing to send cars, it's presumably 
 * done in a different method for the most part. If this is the case, the logic in that method 
 * must be changed to allow for the lights to change only when one of the two timers goes off
 * during a lane's green cycle.
 */

//int[] lanesWithCar = intersectControl.lanesWithCar;
//for (laneToSend : lanesWithCar){
//if (laneToSend != -1){ 
//intersectControl.sendCar(laneToSend);
//intersectControl.maxTimer.increment();                  
//laneToSend.queue.poll().go();
//}
//}
//

//If control reaches here, cars were let through before maxtimer was reached, attempt to time out mintimers

        }

        //if control reached here, maxtimer is reached, the lights will be cycled
System.out.println("\t\t***Full timer elapsed***\n\t\t***Simulation Concluded***");

      


    }
}





