/**
 * TrafficLight.java.
 *
 * Contains discrete states for different traffic light colors.
 * Sends this information to Controller and accelerates light 
 * cycles based on what controller commands.
 * 
 * @author -
 * @version 1.0
 * 
 */
public class TrafficLight {

    /**
     * Enum of three states representing the different light states.
     */
    enum BulbColor {
        RED, YELLOW, GREEN
    }


    private BulbColor color;

    private LightBulb red = new LightBulb();
    private LightBulb yellow = new LightBulb();
    private LightBulb green = new LightBulb();

    /**
     * 
     * Default Constructor sets light to red.
     *
     */
    public TrafficLight() {
        setColor('R');
    }

    /**
     * Specific Constructor.
     * Uses one of three characters to easily access the enum
     * and change the state of the light.
     * @param       color of new light
     */
    public TrafficLight(char color) {
        setColor(color);
    }

    /**
     * TrafficLight color getter.
     * @return      char of current light color
     */
    public char getColor() {
        switch (color) { 
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

    /**
     * TrafficLight color setter.
     * @param color char of color to set light to
     */
    public void setColor(char color) {
        switch(color) {
            case 'G':
            case 'g':
                this.color = BulbColor.GREEN;
                break;
            case 'Y':
            case 'y':
                this.color = BulbColor.YELLOW;
                break;
            case 'R':
            case 'r':
                this.color = BulbColor.RED;
                break;
            default:
                break;
        }
        changeLights();
    }

    /**
     * Called after a light is changed.
     * Updates all bulb objects to reflect the enum states
     */
    private void changeLights() {
        red.setState(false);
        green.setState(false);
        yellow.setState(false);
        switch (color) {
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
                System.out.println("Light color is neither RED nor GREEN nor"
                        + "YELLOW as reported by enum field in TrafficLight");
        }
    }

    /**
     * String dump for Controller/Simulator.
     * 
     * Filler string in case color isn't recognized
     * 
     * @return string of current TrafficLight color
     */
    public String toString() {
        switch (color) { 
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
