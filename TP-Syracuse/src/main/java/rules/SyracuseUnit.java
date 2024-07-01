package rules;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

import drools.SyracuseData;

public class SyracuseUnit implements RuleUnitData {
    private DataSource<SyracuseData> syracuseData;
    private SingletonStore<Integer> startValue;

    // private SingletonStore<List<Integer>> sequence;
    // private SingletonStore<Integer> flightTime;
    // private SingletonStore<Integer> flightTimeOnAltitude;
    // private SingletonStore<Integer> maxAltitude;

    public SyracuseUnit() {
        this.syracuseData = DataSource.createSingleton();
        this.startValue = DataSource.createSingleton();

        // this.sequence = DataSource.createSingleton();
        // this.flightTime = DataSource.createSingleton();
        // this.flightTimeOnAltitude = DataSource.createSingleton();
        // this.maxAltitude = DataSource.createSingleton();
    }
    

    public void setStartValue(SingletonStore<Integer> startValue) {
        this.startValue = startValue;
    }

    public SingletonStore<Integer> getStartValue() {
        return startValue;
    }

    
    public DataSource<SyracuseData> getSyracuseData() {
        return syracuseData;
    }

    public void setSyracuseData(DataSource<SyracuseData> syracuseData) {
        this.syracuseData = syracuseData;
    }
}

// public SyracuseUnit(DataSource<SyracuseData> syracuseData) {
    //     this.syracuseData = syracuseData;
    // }

//     public SingletonStore<List<Integer>> getSequence() {
//         return sequence;
//     }

//     public void setSequence(SingletonStore<List<Integer>> sequence) {
//         this.sequence = sequence;
//     }

//     public SingletonStore<Integer> getFlightTime() {
//         return flightTime;
//     }

//     public void setFlightTime(SingletonStore<Integer> flightTime) {
//         this.flightTime = flightTime;
//     }

//     public SingletonStore<Integer> getFlightTimeOnAltitude() {
//         return flightTimeOnAltitude;
//     }

//     public void setFlightTimeOnAltitude(SingletonStore<Integer> flightTimeOnAltitude) {
//         this.flightTimeOnAltitude = flightTimeOnAltitude;
//     }

//     public SingletonStore<Integer> getMaxAltitude() {
//         return maxAltitude;
//     }

//     public void setMaxAltitude(SingletonStore<Integer> maxAltitude) {
//         this.maxAltitude = maxAltitude;
//     }
// }
