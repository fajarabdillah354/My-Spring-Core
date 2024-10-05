package my.spring.core;

import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import my.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

    /** Dependencies
     * saat kita membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain
     * Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung dengan object lain, atau kita sebut dependencies
     * Dependencies akan secara otomatis di inject(dimasukan) kedalam object yang membutuhkannnya
     * Spring Framework sejak awal menggunakan cara kerja dependency



     ** Spring Dependency Injection
     * Spring sejak awal dikenal dengan framework untuk dependency injection
     * ketika kita membuat method untuk bean di Spring, kita bisa menambahkan tipe parameter tersebut
     * jika ternyata tidak ada bean yang cocok, maka secara otomatis akan terjadi error
     * Dan jika ternyata bean lebih dari satu, secara otomatis akan terjadi error, kecuali terdapat primary bean
     */

    /**@Component
     * ketika menggunakana annotation ini kita tidak perlu lagi menggunakan @Bean
     * @Bean akan secara otomatis dibuatkan oleh Spring dari @Component dimana dibuat dari nama classnya yang di camelCase (ex = ProductService -> productService)
     * @Component hanya mendukung 1 @Bean saja,jadi jika kita ingin membuat beberapa bean dengan tipe yang sama ,kita tetep harus menggunakan @Bean method
     *
     */


    /** Dependency Injection
     * sebelumnya untuk melakukan Dependency Injection di @Bean, kita bisa menambah parameter di methodnya
     * secara otomatis Spring akan memilih bean mana yang cocok untuk parameter tersebut
     * bagaimana jika menggunakan @Component
     * untuk @Component kita bisa melakukan beberapa cara untuk Dependency Injectionnya
     */

    //ada Beberapa cara menambahkan Dependency Injection ke dalam @Component
    /*
        1. Dengan Constuctor
            * kita bisa melakukan dependency injection menggunakan constructor parameter
            * kita bisa menambahkan constructor yang memiliki paramaeter jika membutuhkan bean yang lain
            * secara otomatis Spring akan mencarikan bean tersebut, dan ketika membuat bean @Component, Spring akan menggunakan bean yang dibutuhkan di conctructor
            * Constuctor-based Dependency Injection hanya mendukung satu constructor, jadi pastikan kita hanya membuat satu constuctor
        2. Dengan Setter Dependency(bisa digabung dengan Constructor)
            * Selain menggunakan constructor paramater, kita juga bisa menggunakan setter method jika ingin melakukan Dependency Injection pada Component
            * untuk melakukannya dengan menggunakan Setter method, kita perlu menambahkan annotation @AutoWired pada setter methodnya
            * Secara otomatis Spring akan mencari bean yang dibutuhkan di setter method yang dimiliki annotation @AutoWired
            * Setter-based DI juga bisa digunakan dengan Constructor-based DI
        3. Field-based Dependency Injection(SUDAH TIDAK DIRECOMENDASIKAN DIGUNAKAN)
     */


    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }


    @Test
    void testDepandencyInject() {
        Foo foo = applicationContext.getBean("fooSecond",Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());


    }
}
