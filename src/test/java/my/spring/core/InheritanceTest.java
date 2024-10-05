package my.spring.core;

import my.spring.core.data.MercantServiceImpl;
import my.spring.core.service.MercantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testInheritance() {
        //biasa kita buat interfacenya lalu implementasinya kita registrasikan sebagai bean, nanti ketika mengakses cukup sebutkan nama interface

        // kegunaan ini jika suatu saat kita mengganti model implementasinya kita cukup mengubah class implnya tanpa harus merubah dependency yang menggunakan interfacenya

        MercantServiceImpl mercantServiceImpl = applicationContext.getBean(MercantServiceImpl.class);
        MercantService mercantService = applicationContext.getBean(MercantService.class);

        //saat menggunakan bean kita bisa memakai class service atau pun kelas implnya

        Assertions.assertSame(mercantService, mercantServiceImpl);

    }
}
