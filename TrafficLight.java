/*
 * TrafficLight.java
 *
 * Contains discrete states for different traffic light colors.
 * Sends this information to Controller and accelerates changes based 
 * on what controller commands.
 */

public class TrafficLight{


    public enum BulbColor{
        RED, YELLOW, GREEN
    }

    private BulbColor color;

    public TrafficLight(){
        setColor(RED);

    }

    public TrafficLight(BulbColor color){
        setColor(color);
    }


    public BulbColor getColor(){
        return color;

    }
    public void setColor(BulbColor color(){
            this.Bulbcolor = color;
            }

            }
