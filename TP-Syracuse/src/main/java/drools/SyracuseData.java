package drools;

import java.util.ArrayList;
import java.util.List;

public class SyracuseData {
    private List<Integer> sequence = new ArrayList<>();
    private int flightTime;
    private int flightTimeOnAltitude;
    private int maxAltitude;

    public List<Integer> getSequence() {
        return sequence;
    }
    public void setSequence(List<Integer> s) {
        this.sequence = s;
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
