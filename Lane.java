public class Lane {
    
    TrafficLight light;
    sensor sense;
    boolean car;
    CarQueue queue;

    public Lane() {
        light = new TrafficLight();
        sense = new sensor();
        queue = new CarQueue();
    }

    public boolean carOnSensor() {
        car = sense.carPresent();
        return car;
    }

    public void addCar(Car car) {
        queue.setQueue(car);
    }

    public void run() {
        carOnSensor();
    }

    public void tlight(BulbColor color) {
        light.setColor(color);
    }
}
