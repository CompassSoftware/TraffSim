import java.util.Queue;
import java.util.LinkedList;

/*
 * CarQueue.java
 *
 * FIFO ordering of cars in a given lane
 *
 */
public class CarQueue{
    private Queue<Car> queue = new LinkedList<>();

    /* 
     * Does not change queue, returns first car
     * @return      first car in queue
     */
    public Car peek(){
        return queue.peek();
    }

    
    /*
     * Adds car to back of queue
     * @param       car to add to queue
     */
    public void add(Car c){
        queue.add(c);
    }

    /*
     * Pops and returns first car in queue. Throws exception if empty
     * @return      first car in queue
     */
    public Car remove(){
        return queue.remove();
    }

    /*
     * Class Getter
     * @return      this queue
     */
    public Queue<Car> getQueue(){

        return queue;
    }

    /*
     * Class Setter
     * @param       queue to replace this queue
     */
    public void setQueue(Queue<Car> queue){
        this.queue = queue;

    }
}
