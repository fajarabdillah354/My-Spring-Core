package my.spring.core;

import my.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp(){
        context = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);
    }

    @Test
    void testGetPrimary() {


        /** Primary Bean
         * jika terjadi duplicate bean, selain kita sebutkan nama beannya ketika ingin mengakses beannya, kita juga bisa pilih salah satu bean untuk menjadi primary
         * dengan memilih salah satu menjadi primary, secara otomatis jika kita mengakses bean tanpa menyebutkan nama beannya, secara otomatis primarynya akan dipilih
         * untuk memilih primary bean kita bisa tambahkan annotation @Primary
         *
         */

        Foo foo = context.getBean(Foo.class);//karna ini adalah primary dan method foo1 adalah primarynya maka foo dan foo1 nilainya harus sama
        Foo foo1 = context.getBean("foo1",Foo.class);
        Foo foo2 = context.getBean("foo2",Foo.class);

        Assertions.assertSame(foo, foo1);
        Assertions.assertNotSame(foo, foo2);
        Assertions.assertNotSame(foo1, foo2);

    }
}
