package my.spring.core;

import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {

    /** @Import
     * saat nanti kita membuat aplikasi, tidak mungkin kita hanya akan membuat satu Configuration class saja
     * biasanya kita akan membuat banyak sekali, tergantung seberapa komplek aplikasi kita
     * Spring mendukung import Configuration Class lain jika dibutuhkan
     * kita bisa menggunakan annotatin @Import, lalu sebutkan Configuration class mana yang ingin kita import
     * ketika kita melakukan import, kita bisa import lebih dari satu class
     *
     */


    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testImport() {

        Foo foo = applicationContext.getBean(Foo.class);//kita bisa memasukan apa saja dengan syarat telah diimport ke class applicationContextnya
        Bar bar = applicationContext.getBean(Bar.class);
    }
}
