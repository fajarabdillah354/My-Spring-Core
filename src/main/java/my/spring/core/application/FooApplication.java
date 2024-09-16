package my.spring.core.application;

import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import my.spring.core.listener.AppStartingListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FooApplication {

//    @Bean
//    public Foo bar(Bar bar){//KITA COBA INJECT Class lain
//        return new Foo();
//    }


    @Bean
    public Foo foo(){
        return new Foo();
    }


//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }


    //kita bisa membuat membuat SpringApplication secara manual
    //dibawah ini adalah contoh custom pada banner di Spring

//    public static void main(String[] args) {
//
//        /** Customizing Spring Application
//         * kadang ada kalanya kita ingin melakukan pengaturan di Spring Application sebelum ApplicationContextnya dibuat
//         * kita bisa menggunakan langsung SpringApplication,atau bisa juga menggunakan SpringApplicationBuilder
//         *
//         */
//
//
//        SpringApplication application = new SpringApplication(FooApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);//CONTOH metikan fitur banner pada spring(banner tidak akan tampil)
//        application.setListeners(List.of(new AppStartingListener()));//menambahkan listener dengan Event Listener, Event listener biasa harus applikasi Springnya sudha jalan dulu tapi kalo SpringBoot beberapa event listener di triger sebelum applicationContextnya dibuat
//
//        ConfigurableApplicationContext run = application.run(args);
//
//        Foo foo = run.getBean(Foo.class);
//        System.out.println(foo);
//    }



}
