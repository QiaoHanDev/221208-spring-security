package io.crowdcode.cloudbay.time.web;

import io.crowdcode.cloudbay.common.AnsiColor;
import io.crowdcode.cloudbay.time.api.TimeServiceApi;
import io.crowdcode.cloudbay.time.model.TimeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@Slf4j
@RestController
public class TimeController implements TimeServiceApi {

    @Override
    public ResponseEntity<TimeResponse> now() {
        TimeResponse timeResponse = new TimeResponse().now(LocalDateTime.now());
        log.info(AnsiColor.blue("GOT REQUEST AND SAY " + timeResponse.getNow()));
        return ResponseEntity.ok(timeResponse);
    }
}
