package rules;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

import drools.SyracuseData;

public class SyracuseUnit implements RuleUnitData {
    // private DataSource<SyracuseData> syracuseData;
    private DataStore<SyracuseData> syracuseData;
    private SingletonStore<Integer> startValue;

    public SyracuseUnit() {
        this.syracuseData = DataSource.createStore();
        this.startValue = DataSource.createSingleton();
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

    public void setSyracuseData(DataStore<SyracuseData> syracuseData) {
        this.syracuseData = syracuseData;
    }
}
