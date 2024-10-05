package my.spring.core;

import my.spring.core.data.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        applicationContext.registerShutdownHook();//membuat Spring menutup bean secara paksa setelah bean digunakan
    }

    @Test
    void testAnnotationLifeCycleServer() {
        Server server = applicationContext.getBean(Server.class);


    }
}
