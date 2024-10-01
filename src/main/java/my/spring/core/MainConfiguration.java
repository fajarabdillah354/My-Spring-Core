package my.spring.core;


import my.spring.core.configuration.BarConfiguration;
import my.spring.core.configuration.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({//dengan menggunakan annotation @Import kita bisa meng import configuration lain yang dibutuhkan ke dalam 1 configuration
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {




}
