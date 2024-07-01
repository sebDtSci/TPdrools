package drools.model;

import java.util.ArrayList;
import java.util.List;

public class SyracuseData {
    private int startValue;
    private List<Integer> sequence;
    private int flightTime;
    private int flightTimeOnAltitude;
    private int maxAltitude;

    public SyracuseData(int startValue) {
        this.startValue = startValue;
        this.sequence = new ArrayList<>();
        this.flightTime = 0;
        this.flightTimeOnAltitude = 0;
        this.maxAltitude = 0;
    }

    // Getters et Setters
    public int getStartValue() {
        return startValue;
    }

    public List<Integer> getSequence() {
        return sequence;
    }
    public void setSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public int getFlightTimeOnAltitude() {
        return flightTimeOnAltitude;
    }

    public void setFlightTimeOnAltitude(int flightTimeOnAltitude) {
        this.flightTimeOnAltitude = flightTimeOnAltitude;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }
}
