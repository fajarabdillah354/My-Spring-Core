package my.spring.core;

import my.spring.core.data.Foo;
import my.spring.core.processor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

public class BeanFactoryPostProcessorTest {

    /** Bean Factory Post Processor
     * secara default, mungkin kita tidak akan pernah sama sekali membuat application Context secara manual
     * namun kadang ada keadaan kita ingin memodifikasi secara internal application Context
     * Spring merekomendasikan kita untuk membuat Bean Factory Post Processo
     *
     *
     */


    @Component
    @Import(FooBeanFactoryPostProcessor.class)
    public static class TestConfiguration{

    }


    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFactoryBeanPostProcessor() {

        Foo bean = applicationContext.getBean(Foo.class);

        Assertions.assertNotNull(bean);//sukses karna pada class FooBeanFactoryPostProcessor sudah di registrasikan
    }
}
