package my.spring.core.data;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server{



    //LifeCycle adalah siklus bean setelah dibuat hingga di hancurkan

    //ada method lain yang bisa digunakan sebuah method harus dieksekusi setelah bean dibuat atau juga sebelum dihancurkan dengan menggunakan @PostConstruc dan @PreDestroy


    //jika menggunakan cara @PostConsruct dan @PreDestroy maka pada class configuration tidak perlu menentukan initMethod dan destroyMethod cukup @Bean saja
    @PostConstruct
    public void start(){
        log.info("Start Server");
    }

    @PreDestroy
    public void stop(){
        log.info("Stop Server");
    }




//    @PostConstruct
//    public void mulai(){
//        log.info("Memulai");
//    }
//
//    @PreDestroy
//    public void selesai(){
//        log.info("Selesai");
//    }


}
