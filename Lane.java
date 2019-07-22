public class Lane {
    
    private TrafficLight light;
    private sensor sense;
    private boolean car;
    public CarQueue queue;
    private char tag;
    private char oppLaneTag;

    public Lane(char tag) {
        light = new TrafficLight();
        queue = new CarQueue();
        sense = new sensor(queue);
        this.tag = tag;
        setOppTag();
    }

    public boolean carOnSensor() {
        car = sense.getCarOnSensor();
        return car;
    }

    public void addCar(Car car) {
        queue.add(car);
    }

    public void removeCar(){
        queue.remove();
    }

    public void setLight(char color) {
        light.setColor(color);
    }

    public char getLight(){
        return light.getColor();
    }

    public char getTag(){
        return tag;
    }

    public String printLight(){
        return light.toString();
    }

    public void setTag(char tag){
        this.tag = tag;
        setOppTag();
    }

    public char getOppTag(){
        return oppLaneTag;
    }

    public void setOppTag(){
        if(tag == 'N') oppLaneTag = 'S';
        else if(tag == 'S') oppLaneTag = 'N';
        else if(tag == 'E') oppLaneTag = 'W';
        else oppLaneTag = 'E'; 
    }

}
