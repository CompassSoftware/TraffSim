

public class sensor {

    CarQueue queue;
    boolean carOnSensor;
    Car car;

    public sensor(CarQueue q) {
        this.queue = q;
        car = new Car();
    }

    public void carPresent() {
        if (!car.getSensor()) {
            car = false;
        }
        car = true;
    }
}
