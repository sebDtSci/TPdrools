package drools;

import org.kie.api.event.rule.DefaultRuleRuntimeEventListener;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



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
        LOGGER.debug("Insert " + o.getClass().getSimpleName() + "");
        super.objectInserted(event);
    }
}
