package main.java.rules;

// import org.kie.api.runtime.rule.RuleUnitData;
import org.drools.ruleunits.api.RuleUnitData;
import main.java.drools.model.SyracuseData;

public class SyracuseRuleUnit implements RuleUnitData {
    private SyracuseData syracuseData;

    public SyracuseData getSyracuseData() {
        return syracuseData;
    }

    public void setSyracuseData(SyracuseData syracuseData) {
        this.syracuseData = syracuseData;
    }
}
