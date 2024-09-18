package my.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "my.spring.core.repository",
        "my.spring.core.service",
        "my.spring.core.configuration",
})
public class ComponentConfiguration {





}
