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

    private LightBulb red;
    private LightBulb yellow;
    private LightBulb green;

    //Default Constructor
    public TrafficLight(){
        setColor(BulbColor.RED);
    }

    //Specifc Constructor
    public TrafficLight(BulbColor color){
        setColor(color);
    }

    //Getter
    public BulbColor getColor(){
        return color;

    }

    //Setter
    public void setColor(BulbColor color){
        this.color = color;
        changeLights();
    }

    //Sets the different LightBulb booleans to on/off when the light status is changed
    private void changeLights(){
        red.setState(false);
        green.setState(false);
        yellow.setState(false);
        switch (color){
            case RED:
                red.setState(true);
                break;
            case YELLOW:
                yellow.setState(true);
                break;
            case GREEN:
                green.setState(true);
                break;
            default:
                System.out.println("Light color is neither RED nor GREEN nor YELLOW as reported by"
                        + "enum field in TrafficLight.java");
        }
    }
}
