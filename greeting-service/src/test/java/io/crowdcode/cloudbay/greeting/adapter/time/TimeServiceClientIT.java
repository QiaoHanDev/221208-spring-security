package io.crowdcode.cloudbay.greeting.adapter.time;

import io.crowdcode.cloudbay.time.model.TimeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@SpringBootTest
class TimeServiceClientIT {
    @Autowired
    TimeServiceClient timeServiceClient;
    @Test
    void testWithFeignClient() {
        TimeResponse response = timeServiceClient.retrieveNow();
        assertThat(response.getNow()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}
