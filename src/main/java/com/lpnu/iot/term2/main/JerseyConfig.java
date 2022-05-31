package com.lpnu.iot.term2.main;

import com.lpnu.iot.term2.lab8.controller.JaxRSController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.lpnu.iot.term2.lab8.controller");
    }
}
