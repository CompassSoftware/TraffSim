
/**
 * Clock class that increments timer.
 * @author Sam Howard
 * @version 7/24/2019
 **/
public class Clock {

    public int seconds;
    public int minutes;
    public int hours = 12;
    public String scnds = "";
    public String mnts = "";
    public String hrs = "";
    public String time = "";
    public Timer maxtimer, difftimer, globaltimer;

    /**
     * Class Constructor.
     **/
    public Clock(Timer maxtimer, Timer difftimer, Timer globaltimer) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.maxtimer = maxtimer;
        this.difftimer = difftimer;
        this.globaltimer = globaltimer;
    }

    public void tick(int t){
    maxtimer.tick(t);
    difftimer.tick(t);
    globaltimer.tick(t);
    setSeconds(int sec);
    
    }

    /**
     * setSeconds method.
     * @param sec seconds
     **/
    public void setSeconds(int sec) {
        
        seconds += sec;
        setMinutes();
        setHours();
    }

    /**
     * setMinutes method.
     **/
    public void setMinutes() {
        if (seconds >= 60) {
            
            minutes++;
            seconds = seconds - 60;

        }
    }

    /**
     * setHours method.
     **/
    public void setHours() {
        if (minutes >= 60) {

            hours++;
            minutes = minutes - 60;
        }
    }
    /**
     * toString method.
     * @return time 
     **/
    public String toString() {
        
        if (seconds < 10) {
            scnds = scnds.valueOf(seconds);
            scnds = "0" + scnds;
        } 
        else {
            scnds = scnds.valueOf(seconds);
        }
        if (minutes < 10) {
            mnts = mnts.valueOf(minutes);
            mnts = "0" + mnts;
        } 
        else {
            mnts = mnts.valueOf(minutes);
        }
        if (hours < 10) {
            hrs = hrs.valueOf(hours);
            hrs = "0" + hrs;
        } 
        else { 
            hrs = hrs.valueOf(hours);
        }
        
        return time = hrs + ":" + mnts + ":" + scnds;
    }
}
