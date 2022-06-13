package io.crowdcode.cloudbay.greeting.controller;

import io.crowdcode.cloudbay.greeting.config.GreetingProperties;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
class GreetingControllerTest {

    @Test
    void checkWelcomeMessageDefault() {
        assertThat(new GreetingController(new GreetingProperties(), Optional.empty()).welcome()).isNotNull();
    }
}
