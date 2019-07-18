public class Lane {
    
    Light light;
    sensor sense;
    boolean car;
    Queue queue;

    public Lane() {
        light = new Light();
        sense = new sensor();
        //queue object
    }

    public boolean carOnSensor() {
        car = sense.carPresent();
        return car;
    }

    public void addCar(Car car) {
        queue.add(car);
    }

    public void run() {
        carOnSensor();
    }

    public void tlight(BulbColor color) {
        light.setColor(color);
    }
}
