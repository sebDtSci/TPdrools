package drools;

import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;

import util.Util;

public class AgendaEventListenerConfig extends DefaultRuleEventListenerConfig{
    public AgendaEventListenerConfig() {
        super(new MyAgendaEventListener());
    }
}

class MyAgendaEventListener extends DefaultAgendaEventListener {
	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		Util.debug("--------- " +event.getMatch().getRule().getPackageName() +" - " +event.getMatch().getRule().getName() + " --------- ");
	}
}
