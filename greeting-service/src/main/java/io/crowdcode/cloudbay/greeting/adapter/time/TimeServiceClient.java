package io.crowdcode.cloudbay.greeting.adapter.time;

import io.crowdcode.cloudbay.time.api.TimeServiceApi;
import io.crowdcode.cloudbay.time.model.TimeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@FeignClient(value = "timeServiceApi", url="${time.service.url}")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public interface TimeServiceClient extends TimeServiceApi {

    @GetMapping()
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    TimeResponse retrieveNow();

}
