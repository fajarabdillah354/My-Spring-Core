package my.spring.core;

import my.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {


    private ApplicationContext context;

    @BeforeEach
    void setUp(){
        context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void testScopePrototype() {

        //karna scope yang dipilihh adalah prototype maka bukan lagi menggunkan defaultnya yaitu singleton, jika menggunakan prototpye maka setiap pembuatan object dihitung object baru
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Foo foo3 = context.getBean(Foo.class);

        Assertions.assertNotEquals(foo1,foo2);
        Assertions.assertNotEquals(foo2,foo3);
        Assertions.assertNotEquals(foo3,foo1);

    }
}
