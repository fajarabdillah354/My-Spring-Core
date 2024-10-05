package my.spring.core;

import my.spring.core.service.AuthService;
import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {

    /** Aware (interface)
     * Spring memiliki sebuah interface bernama Aware
     * Aware adalah super interface yang digunakan untuk semua Aware interface
     * Aware diperuntukan untuk penanda agar Spring melakukan injection object yang kita butuhkan
     * mirip seperti yang sudah kita lakukan ketika membuat IdAware menggunakan IdGenerator Bean Post Processor
     * namun untuk ini, kita tidak perlu lagi membuat Bean Post Processor secara manual kita bisa gunakan Aware

     */

    /** Daftar Aware
     * ApplicationContextAware -> untuk mendapat application context
     * BeanFactoryAware -> untuk mendapat bean factory
     * BeanNameAware -> untuk mendapat nama bean
     * ApplicationEventPubsliherAware -> untuk mendapat event publisher
     * EnviromentAware -> untuk mendapat enviroment
     *
     */


    @Configuration
    @Import(AuthService.class)
    public static class TestConfiguration{
        
    }
    
    private ConfigurableApplicationContext applicationContext;
    
    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);

        Assertions.assertEquals("my.spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
    }
}
