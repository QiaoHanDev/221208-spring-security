package io.crowdcode.cloudbay.greeting.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
//@Profile("greeting")
@Configuration
//@EnableConfigurationProperties(GreetingProperties.class)
//@PropertySource(name="Greeting", value = "classpath:/greeting.properties")
public class GreetingConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "io.crowdcode.greeting")
    public GreetingProperties greetingProperties() {
        return new GreetingProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "io.crowdcode.archived")
    public GreetingProperties greetingArchivedProperties() {
        return new GreetingProperties();
    }

}
