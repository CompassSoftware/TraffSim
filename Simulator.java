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

    /*
     * East car approaches light, delayed by minTimer
     */
    public static void run2(String[] args){
        System.out.println("\t\t***This is a Simulation of an Eastbound Car moving into a 4-way intersection***");
        Lane[] lanes = new Lane[4];
        for (int i = 0; i < lanes.length; i++) lanes[i] = new Lane('N');
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

         northCar.stop();
            int[] lanesWithCar = intersectControl.lanesWithCar();
            for (int laneToSend : lanesWithCar)
                if (laneToSend != -1) intersectControl.sendCar(laneToSend);
            northCar.go();

        eastCar.stop();    

        while(minTimer > 0 && maxTimer > 0){
            intersectControl.printLights();

           



        }


    }

/*
 * No cars, maxTimer goes off and cycles light
 */
    public static void run3(String[] args){
        System.out.println("\t\t***This is a Simulation of an Eastbound Car moving into a 4-way intersection***");
        Lane[] lanes = new Lane[4];
        for (int i = 0; i < lanes.length; i++) lanes[i] = new Lane('N');
        lanes[1].setTag('W');
        lanes[2].setTag('S');
        lanes[3].setTag('E');
        Controller intersectControl = new Controller(lanes);
        lanes[0].setLight('G');
        lanes[2].setLight('G');

        while(minTimer > 0 && maxTimer > 0){
          intersectControl.printLights(); 
        }

        System.out.println("\t\t***One cycle completed***\n\t\t***Simulation Concluded***");

    }
}





