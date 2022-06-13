package io.crowdcode.cloudbay.greeting.adapter.time;

import io.crowdcode.cloudbay.time.model.TimeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@Slf4j
@Service
public class TimeService {

    private final RestTemplate restTemplate;

    @Value("${time.service.url}")
    private String timeServiceUrl;

    public TimeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public LocalDateTime retrieveNow() {
        ResponseEntity<TimeResponse> response = restTemplate
                .getForEntity(timeServiceUrl, TimeResponse.class);

        return (response.getBody() != null) ? response.getBody().getNow() : LocalDateTime.MAX;
    }
}
