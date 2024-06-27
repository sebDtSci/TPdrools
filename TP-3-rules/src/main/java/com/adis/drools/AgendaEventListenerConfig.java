package com.adis.drools;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;

import com.adis.questionnaire.util.Util;

public class AgendaEventListenerConfig extends DefaultRuleEventListenerConfig{
    public AgendaEventListenerConfig() {
        super(new MyAgendaEventListener());
    }
}

class MyAgendaEventListener extends DefaultAgendaEventListener {
	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		Util.debug(event.getMatch().getRule().getPackageName() +" - " +event.getMatch().getRule().getName());
	}
}
