package my.spring.core;

import my.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNameTest {

    /** Mengubah nama bean
     * secara default nama bean diambil dari nama method
     * namun kadang-kadang kita tidak ingin menggunakan nama method untuk nama bean
     * saat project kita sudah besar, kadang bisa jadi nama method sama , walaupun isi beannya berbeda
     * pada Spring nama bean itu harus unik tidak boleh sama
     * jika kita ingin mengubah nama bean, kita bisa menggunakan method value() milik annotation @Bean
     * ex = @Bean(name = " ")
     *
     */


    private ApplicationContext applicationContext;


    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }


    @Test
    void testNameBean() {
        Foo bean = applicationContext.getBean(Foo.class);
        Foo bean1 = applicationContext.getBean("firstFoo", Foo.class);
        Foo bean2 = applicationContext.getBean("secondFoo", Foo.class);

        Assertions.assertSame(bean1, bean);
        Assertions.assertNotSame(bean1, bean2);
        Assertions.assertNotSame(bean, bean2);


    }
}
