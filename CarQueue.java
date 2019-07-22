/*
 * CarQueue.java
 *
 * FIFO ordering of cars in a given lane
 *
 */
import java.util.Queue;
import java.util.LinkedList;

public class CarQueue{
    private Queue<Car> queue = new LinkedList<>();


    public Queue<Car> getQueue(){

        return queue;
    }

    public void setQueue(Queue<Car> queue){
        this.queue = queue;

    }
}
