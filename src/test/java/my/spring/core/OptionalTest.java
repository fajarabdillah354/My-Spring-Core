package my.spring.core;

import my.spring.core.data.Foo;
import my.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalTest {


    /** Optional Dependency
     * secara default, semua dependency itu wajib
     * artinya jika Spring tidak menemukan bean yang dibutuhkan pada saat DI, maka secara otomatis akan terjadi error
     * namun jika kita memang ingin membuat sebuah dependency menjadi Optional, artinya tidak wajib
     * kita bisa wrap dependency tersebut dengan menggunakan java.util.Optional<T>
     * Secara otomatis jika ternyata bean yang dibutuhkan tidak ada, maka tidak akan terjadi error
     * kita bisa gunakan Optional<T> pada @Bean (methdo parameter) ataupun @Component(constructor parameter,setter method paramter, dan field)
     *
     */

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        applicationContext.registerShutdownHook();
    }


    @Test
    void testOptional() {
        //jika ada dependency yang tidak wajib kita bisa menggunakan java util Optional

        Foo foo = applicationContext.getBean(Foo.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getBar());
        Assertions.assertSame(foo, fooBar.getFoo());
    }
}
