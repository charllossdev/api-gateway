package com.example.serviceadmin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-admin")
@Slf4j
public class ApiController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to the admin service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return header;
    }

    @GetMapping("/check")
    public String check() {
        return "hi, there. This is a message from admin service";
    }
}
