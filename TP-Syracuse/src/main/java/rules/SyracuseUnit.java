package rules;

import org.drools.ruleunits.api.RuleUnitData;
import drools.model.SyracuseData;
import org.drools.ruleunits.api.DataSource;
// import org.kie.api.runtime.rule.DataSource;

public class SyracuseUnit implements RuleUnitData {
    private DataSource<SyracuseData> syracuseData;

    public SyracuseUnit() {
        this.syracuseData = DataSource.createStore();
    }

    public SyracuseUnit(DataSource<SyracuseData> syracuseData) {
        this.syracuseData = syracuseData;
    }

    public DataSource<SyracuseData> getSyracuseData() {
        return syracuseData;
    }

    public void setSyracuseData(DataSource<SyracuseData> syracuseData) {
        this.syracuseData = syracuseData;
    }
}
