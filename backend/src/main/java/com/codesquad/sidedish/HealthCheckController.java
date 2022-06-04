package com.codesquad.sidedish;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/api/check")
    public String healthChecker() {
        return "ok!!";
    }
}
