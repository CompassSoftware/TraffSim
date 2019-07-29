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
public class CarList {
    private ArrayList<Car> list;

    public CarList () {
        list = new ArrayList<Car>(10);
    }

    /**
     * Does not change list, returns first car.
     * @return      first car in List
     */
    public Car peek(){
        return list.get(0);
    }

    /**
     * Pops and returns first car in queue.
     * Advance should usually be called afterward
     * @return      first car in queue
     */
    public Car remove() {
        Car car = peek();
        list.remove(0);
        return car;
    }

    public void add(Car c) {
        list.add(c);
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    /*
     * Moves every car in the list 1 closer to the head.
     * NOTE: The head is overwritten, it must be handled beforehand
     */
    public void advance(){
        for (int i = 0; i < list.size() - 1; i++){
            list.set(i, list.get(i+1));
        }
    }
    public int size(){
return list.size();
    }
}
