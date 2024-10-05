package my.spring.core;

import my.spring.core.data.Car;
import my.spring.core.processor.IdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanPostProcessorTest {


    /** Bean Post Processor
     * BeanPostProcessor merupakan sebuah interface yang bisa kita gunakan untuk memodifikasi proses pembuatan bean di application Context
     * BeanPostProcessor mirip seperti middleware, yang diakses sebelum bean di initalized dan setelah bean di initialized
     * karena sangat flexible, bahkan BeanPostProcessor bisa memodifikasi hasil object bean
     *
     */

    @Configuration
    @Import({Car.class, IdGeneratorBeanPostProcessor.class})
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;



    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanProcessorCar() {

        //jika mau memodifikasi bean2 yang kita mau kita bisa menggunakan BeanPostProcessor


        Car car = applicationContext.getBean(Car.class);

        System.out.println(car.getId());

        Assertions.assertNotNull(car.getId());
    }
}
