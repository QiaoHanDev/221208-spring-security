package io.crowdcode.cloudbay.greeting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@ActiveProfiles("friesisch")// setzt spring.profiles.active=friesisch
@SpringBootTest
class GreetingControllerFriesischTest {

    @Autowired
    private GreetingController greetingController;

    @Test
    void checkWelcomeMessageDefault() {
        assertThat(greetingController.welcome()).contains("Moin");
    }
}
