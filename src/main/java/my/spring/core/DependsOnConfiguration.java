package my.spring.core;


import lombok.extern.slf4j.Slf4j;
import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Configuration
@Slf4j
public class DependsOnConfiguration {



    @Lazy//ini akan dibuat nanti ketika sudahh diakses tidak saat Spring pertama kali dijalannya(jika tidak diakses tidak akan dibuat)
    @Bean
    @DependsOn("bar")//memberi tahu pembuatan @Bean foo setelah @Bean bar dibuat
    public Foo foo(){
        log.info("create new foo");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("create new bar");
        return new Bar();
    }
}
