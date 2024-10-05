package my.spring.core;

import lombok.extern.slf4j.Slf4j;
import my.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class DuplicateTest {


    @Test
    void testDuplicate() {

        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        //context.getBean(Foo.class);//error karna ekspetasi nya dapetin single dengan tipe data Foo ternyata ada 2 foo1, dan foo2

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo = context.getBean(Foo.class);

        });
        log.info("Create new foo");

    }


    @Test
    void testGetTwoBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class
        );

        //jika ada 2 bean kita bisa menggunakan paramater name untuk memberi tahu nama bean mana yang ingin kita gunakan
        Foo getFoo1 = context.getBean("foo1", Foo.class);
        Foo getFoo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(getFoo1,getFoo2);


    }
}
