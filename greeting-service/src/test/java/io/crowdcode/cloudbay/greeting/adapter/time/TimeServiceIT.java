package io.crowdcode.cloudbay.greeting.adapter.time;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@SpringBootTest
class TimeServiceIT {

    @Autowired
    TimeService timeService;

    @Test
    void fetchTimeFromRemoteService() {
        assertThat(timeService.retrieveNow()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}
