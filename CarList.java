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

    public Car remove(int i){
    	Car car = list.get(i);
    	list.remove(i);
    	return car;
    }

    public void add(Car c) {
    	if (list.isEmpty()) {
    		c.setSensor(true);
    	}
        list.add(c);
    }

    public Car get(int i){
        return list.get(i);
    }

    public ArrayList<Car> getList() {
        return list;
    }

    public void setList(ArrayList<Car> list) {
        this.list = list;
    }

    /*
     * Moves every car in the list 1 closer to the head.
     * NOTE: The head is overwritten, it must be handled beforehand
     */
    
    /*public void advance(){
        for (int i = 0; i < list.size() - 1; i++){
            list.set(i, list.get(i+1));
        }
        
        list.size() - 1 = c
    }*/

    /*
     *  Method that will return CarList size
     *
     *  return - size of CarList
     */
    public int size(){
        return list.size();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    /*
     * Uses arrayList method isEmpty 
     *
     *  return - returns true or false if the list has any cars
     */
    public boolean listFull() {
       boolean b = false;

       if (list.isEmpty()) {
           b = true;
       }

       return b;
    }
}
