package my.spring.core;

import my.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    /*
        Singleton 1 tipedata 1 object, kita membuat bean dengan tipe data yang sama namun harus menggunakan nama bean yang berbeda
     */

    @Test
    void testCreateBean() {

        //diawal akan dibuat dulu semua object beannyaa

        ApplicationContext context1 =  new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ApplicationContext context2 =  new AnnotationConfigApplicationContext(BeanConfiguration.class);//karna defaultnya singleton maka object ke dua ini bukanlah object baru tetapi objecct yang sudah ter buat yang lebih dulu

        Assertions.assertNotNull(context1);
    }

    @Test
    void testGetBean() {
        ApplicationContext context =  new AnnotationConfigApplicationContext(BeanConfiguration.class);

        // jikaa ada 2 bean kita wajib menyebutkan nama beannya

        Foo foo1 = context.getBean(Foo.class);//getBean() untuk mendapatkan beannya
        Foo foo2 = context.getBean(Foo.class);

        //object ini akan sekali di buat meskipun kita meng inisiasi 2 object karna singleton


        Assertions.assertSame(foo1, foo2);//ini akan mendapatkan hasil object yang sama
    }
}
