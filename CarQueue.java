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

    public Car peek(){
        return queue.peek();
    }

    public Car poll(){
        return queue.poll();
    }

    public void add(Car c){
        queue.add(c);
    }

    public Car remove(){
        return queue.remove();
    }

    public Queue<Car> getQueue(){

        return queue;
    }

    public void setQueue(Queue<Car> queue){
        this.queue = queue;

    }
}
