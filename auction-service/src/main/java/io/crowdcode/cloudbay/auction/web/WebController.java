package io.crowdcode.cloudbay.auction.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebController {

    @GetMapping("/user/private")
    public String userPrivatePage() {
        return "Welcome To Spring Security user private";
    }

    @GetMapping("/api/private")
    public String apiPrivatePage() {
        return "Welcome To the VIP room api private! ";
    }
}
