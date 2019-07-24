import java.util.ArrayList;

/**
 * CarQueue.java.
 *
 *  Front of the line starts at idx0
 *  
 *  @author James Brown
 *  @version 1.0
 *
 */
public class CarList extends ArrayList {

    /**
     * Does not change queue, returns first car.
     * @return      first car in queue
     */
    public Car peek(){
        return get(0);
    }

    /**
     * Pops and returns first car in queue. Throws exception if empty
     * @return      first car in queue
     */
    public Car remove(Car c) {
        Car car = peek();
        remove(c);
        return car;
    }
}
