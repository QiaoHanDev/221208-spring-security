package io.crowdcode.cloudbay.greeting.controller;

import io.crowdcode.cloudbay.greeting.adapter.time.TimeService;
import io.crowdcode.cloudbay.greeting.config.GreetingProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@Slf4j
@RestController// @Controller -> @Component, @ResponseBody
//@RequiredArgsConstructor // Erzeugt einen GreetingController(GreetingProperties greetingProperties)
public class GreetingController {

//    @Autowired
//    private List<GreetingProperties> propertiesList;

    private final GreetingProperties greetingProperties;

    private final Optional<TimeService> timeService;

//    @Value("${welcomeMessage}")
//    private String welcomeMessage = "Herzlich Willkommen";
//
//    @Value("${goodbyeMessage}")
//    private String goodbyeMessage = "Auf Wiedersehen";

    public GreetingController(GreetingProperties greetingProperties, Optional<TimeService> timeService) {
        this.greetingProperties = greetingProperties;
        this.timeService = timeService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greetingProperties.getWelcomeMessage() + nowSuffix();
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return greetingProperties.getGoodbyeMessage() + nowSuffix();
    }

    private String nowSuffix() {
        return timeService.map(TimeService::retrieveNow).map(dt -> " at " + dt).orElse("");
    }
}
