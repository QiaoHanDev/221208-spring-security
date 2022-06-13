package io.crowdcode.cloudbay.greeting.adapter.time;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.crowdcode.cloudbay.time.model.TimeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@RestClientTest(value = TimeService.class, properties = "time.service.url=http://timeservice/now")
class TimeServiceMockTest {

    @Autowired
    MockRestServiceServer mockRestServiceServer;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    TimeService timeService;

    @Test
    void testTimeService() throws JsonProcessingException {

        LocalDateTime testDateTime = LocalDateTime.of(2022, 1, 1, 12, 00, 0);
        TimeResponse time = new TimeResponse().now(testDateTime);
        String timeJson = objectMapper.writeValueAsString(time);

        mockRestServiceServer
                .expect(requestTo("http://timeservice/now"))
                .andExpect(header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andRespond(withSuccess(timeJson, MediaType.APPLICATION_JSON));

        assertThat(timeService.retrieveNow()).isEqualTo(testDateTime);

    }

}
