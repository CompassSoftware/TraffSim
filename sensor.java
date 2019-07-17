public class sensor {

    public boolean car;
    public boolean pedestrian;

    public sensor() {
        car = this.car;
        pedestrian = this.pedestrian;
    }

    public boolean CarSensor(boolean is_present) {
        if (!is_present) {
            return false;
        }
        return true;
    }

    public boolean Pedestrian(boolean is_ped) {
        if (!is_ped) {
            return false;
        }
        return true;
    }

    public void setCar(boolean c) {
        car = c;
    }

    public void setPed(boolean p) {
        pedestrian = p;
    }
}
        

