package my.spring.core;

import my.spring.core.data.Car;
import my.spring.core.processor.IdGeneratorBeanPostProcessor;
import my.spring.core.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTets {


    /** Ordered
     * Saat kita membuat Bean Post Processor, kita bisa membuat lebih dari satu
     * Kadang ada kasus disaat membuat beberapa Bean Post Processor, kita ingin membuat yang berurutan
     * secara default, Spring tidak menjamin urutan eksekusinya
     * kita bisa menentukan urutannya, kita bisa menggunakan Interface Ordered
     *
     */


    @Configuration
    @Import({Car.class, IdGeneratorBeanPostProcessor.class, PrefixIdGeneratorBeanPostProcessor.class})
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {

        Car car = applicationContext.getBean(Car.class);
        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("FJR -"));
    }
}
