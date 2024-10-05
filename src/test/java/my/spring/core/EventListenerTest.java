package my.spring.core;

import my.spring.core.listener.LoginAgainListener;
import my.spring.core.listener.LoginSuccesListener;
import my.spring.core.listener.UserListener;
import my.spring.core.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    /** Event Listener
     * Spring memiliki fitur Event Listener yang bisa digunakan untuk komunikasi antar class menggunakan event
     * Event di Spring merupakan object turunan dari ApplicationEvent, sedangkan Listener di Spring merupakan turunan dari ApplicationListener
     */


    /** Event Listener Annotation
     * selain menggunakan interface ApplicationListener, kita juga bisa menggunakan Annotation untuk membuat Listener
     * ini lebih fleksibel dibanding menggunakan interface ApplicationListener
     * kita bisa menggunakan annotation @EventListener
     *
     */


    @Configuration
    @Import({UserService.class,
            LoginSuccesListener.class,
            LoginAgainListener.class,
            UserListener.class
    })
    public static class TestConfiguration{


    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }


    @Test
    void testEvent() {

        //jika ingin menambahkan listener bisa langsung tambahkan saja, UserService tidak perlu melakukan modifikasi classnya lagi

        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("fajar","fajar");
        userService.login("fajar","salah");
        userService.login("fajar","ngktau");
    }
}
