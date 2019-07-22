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

    private LightBulb red = new LightBulb();
    private LightBulb yellow = new LightBulb();
    private LightBulb green = new LightBulb();

    //Default Constructor
    public TrafficLight(){
        setColor(BulbColor.RED);
    }

    //Specifc Constructor
    public TrafficLight(BulbColor color){
        setColor(color);
    }

    //Getter
    public char getColor(){
        switch (color){ 
            case RED:
                return 'R';
            case YELLOW:
                return 'Y';
            case GREEN:
                return 'G';
            default:
                return 'N';
        }
    }

    //Setter
    public void setColor(char color){
        switch(color){
            case 'G':
            case 'g':
                this.color = BulbColor.Green;
                break;
            case 'Y':
            case 'y':
                this.color = BulbColor.Yellow;
                break;
            case 'R':
            case 'r':
                this.color = BulbColor.Red;
                break;
        }
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

    public String toString(){
        switch (color){ 
            case RED:
                return "Red";
            case YELLOW:
                return "Yellow";
            case GREEN:
                return "Green";
            default:
                return "Not A Color";
        }
    }

}
