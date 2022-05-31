package com.lpnu.iot.term2.lab8.config;

import com.lpnu.iot.term2.lab8.structure.WeaponController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(WeaponController.class);
    }
}
