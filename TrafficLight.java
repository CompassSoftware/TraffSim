/*
 * TrafficLight.java
 *
 * Contains discrete states for different traffic light colors.
 * Sends this information to Controller and accelerates changes based 
 * on what controller commands.
 */

enum BulbColor{
    RED, YELLOW, GREEN
}


public class TrafficLight{

    private BulbColor color;

    public TrafficLight(){
        setColor(BulbColor.RED);

    }

    public TrafficLight(BulbColor color){
        setColor(color);
    }


    public BulbColor getColor(){
        return color;

    }
    public void setColor(BulbColor color){
        this.color = color;
    }

}
