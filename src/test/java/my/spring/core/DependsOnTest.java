package my.spring.core;

import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {


    /** @DependsOn
     * defaultnya pembuatan bean akan dilakukan dari atas ke bawah
     * annotation @DependsOn dapat digunakan untuk memberi tahu kapan suatu bean dibuat, contoh @DependsOn("A") berarti bean ini dibuat jika bean A terbuat terlebih dahulu
     * kita juga bisa memprioritaskan bean mana duluan yang dibuat dengan @DependsOn
     * @return
     */


    /** @Lazy
     * secara default, bean di Spring akan dibuat ketika apllikasi Spring pertama kali dijalankan
     * oleh karena itu, kadang ketika aplikasi Spring pertama berjalan akan sedikit lambat, hal ini karena semua bean akan dibuat di awal
     * Namun jika mau, kita juga bisa membuat sebuah bean menjadi lazy(malas), dimana bean tidak akan dibuat, hingga dibutuhkan atau diakses
     * untuk membuatnyaa kita perlu menambahkan annotation @Lazy pada bean tersebut
     * @return
     */
    
    
    private ApplicationContext applicationContext;
    
    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
    }

    @Test
    void testDependsOn() {
        //saat ada Bean yang bersifat Lazy ketika projet dijalankan maka dia tidak akan dibuat terlebih dahulu
        applicationContext.getBean(Foo.class);//ketika diakses baru akan dibuat
    }
}
