package com.adis.drools;

import org.kie.api.event.rule.DefaultRuleRuntimeEventListener;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adis.questionnaire.quest.Question;
import com.adis.questionnaire.quest.Rubrique;

public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {
    public RuleEventListenerConfig() {
        super(new MyRuleRuntimeEventListener());
    }
}

class MyRuleRuntimeEventListener extends DefaultRuleRuntimeEventListener {
    private static Logger LOGGER = LoggerFactory.getLogger(MyRuleRuntimeEventListener.class);

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        Object o = event.getObject();
        if (o instanceof Question) {
            Question q = (Question) o;
            q.setStale(false);
            LOGGER.debug("Insert Question [" + q.getLibelle() + "]");
        } else if (o instanceof Rubrique) {
            Rubrique r = (Rubrique) o;
            r.setStale(false);
            LOGGER.debug("Insert Rubrique [" + r.getLibelle() + "]");
        } else {
            LOGGER.debug("Insert " + o.getClass().getSimpleName() + "");
        }
        super.objectInserted(event);
    }
}
