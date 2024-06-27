package main.java.drools.service;

import main.java.drools.model.SyracuseData;

import java.util.ArrayList;
import java.util.List;

public class SyracuseService {

    public SyracuseData calculateSyracuseSequence(int startValue) {
        SyracuseData syracuseData = new SyracuseData();
        syracuseData.setStartValue(startValue);

        List<Integer> sequence = new ArrayList<>();
        int current = startValue;
        int flightTime = 0;
        int flightTimeInAltitude = 0;
        int maxAltitude = startValue;

        while (current != 1) {
            sequence.add(current);
            flightTime++;
            if (current > maxAltitude) {
                maxAltitude = current;
            }
            if (current > startValue) {
                flightTimeInAltitude++;
            }
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                current = 3 * current + 1;
            }
        }
        sequence.add(1);
        flightTime++; // Counting the last step to 1

        syracuseData.setSequence(sequence);
        syracuseData.setFlightTime(flightTime);
        syracuseData.setFlightTimeInAltitude(flightTimeInAltitude);
        syracuseData.setMaxAltitude(maxAltitude);

        return syracuseData;
    }
}
