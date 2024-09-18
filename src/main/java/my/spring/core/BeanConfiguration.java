package my.spring.core;

import lombok.extern.slf4j.Slf4j;
import my.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean//jika kita tidak menulis ini maka tidak akan dianggep bean
    public Foo foo1(){
        Foo foo = new Foo();
        log.info("Create new foo");
        return foo;
    }




}
