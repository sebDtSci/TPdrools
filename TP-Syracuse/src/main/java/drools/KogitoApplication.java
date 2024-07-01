package  drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = { "rules.**", "org.kie.kogito.**", "http**" })
public class KogitoApplication {
    public static void main(String[] args) {
        SpringApplication.run(KogitoApplication.class, args);
    }

    @Bean
    RuleEventListenerConfig newRuleEventListener() {
        return new RuleEventListenerConfig();
    }
    @Bean
    AgendaEventListenerConfig newAgendaEventListener() {
    	return new AgendaEventListenerConfig();
    }
}