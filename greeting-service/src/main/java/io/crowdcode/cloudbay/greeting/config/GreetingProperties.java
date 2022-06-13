package io.crowdcode.cloudbay.greeting.config;

import lombok.Data;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@Data
//@ConfigurationProperties(prefix = "io.crowdcode.greeting")
public class GreetingProperties {

    /**
     * Message displayed after Login
     */
    private String welcomeMessage = "Herzlich Willkommen";

    /**
     * Message displayed after Logout
     */
    private String goodbyeMessage = "Auf Wiedersehen";

    /**
     * Defines how long should the message been shown
     */
    private int showMessageInSeconds = 5;


}
