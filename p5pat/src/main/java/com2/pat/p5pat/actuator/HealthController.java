package com2.pat.p5pat.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    Logger log = LoggerFactory.getLogger(HealthController.class);

    @Autowired
    private final HealthEndpoint he;

    public HealthController(HealthEndpoint healthEndpoint) {
        this.he = healthEndpoint;
    }

    @GetMapping("/health")
    public String health() {

        log.info("Estado del sistema: " + he.health().getStatus().getCode());

        return "Estado del sistema: " + he.health().getStatus().getCode();
    }


}
