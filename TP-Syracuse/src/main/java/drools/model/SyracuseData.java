package main.java.drools.model;

import java.util.List;

public class SyracuseData {
    private int startValue;
    private List<Integer> sequence;
    private int flightTime;
    private int flightTimeInAltitude;
    private int maxAltitude;
    public int getStartValue() {
        return startValue;
    }
    public void setStartValue(int startValue) {
        this.startValue = startValue;
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
    public int getFlightTimeInAltitude() {
        return flightTimeInAltitude;
    }
    public void setFlightTimeInAltitude(int flightTimeInAltitude) {
        this.flightTimeInAltitude = flightTimeInAltitude;
    }
    public int getMaxAltitude() {
        return maxAltitude;
    }
    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

}
