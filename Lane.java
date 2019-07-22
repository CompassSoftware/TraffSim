public class Lane {
    
    TrafficLight light;
    sensor sense;
    boolean car;
    CarQueue queue;
    char tag;

    public Lane(char tag) {
        light = new TrafficLight();
        sense = new sensor();
        queue = new CarQueue();
        this.tag = tag;
    }

    public boolean carOnSensor() {
        car = sense.carPresent();
        return car;
    }

    public void addCar(Car car) {
        queue.setQueue(car);
    }

    public void setLight(char color) {
        light.setColor(color);
    }

    public void getLight(){
        light.getLight();
    }

    public void getTag(){
        return tag;
    }

    public void printLight(){
        light.toString();
    }
}
