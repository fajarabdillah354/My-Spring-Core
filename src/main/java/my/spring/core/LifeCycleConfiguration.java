package my.spring.core;

import my.spring.core.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {

    /**Life Cycle Annotation
     * selain menggunakan interface initializingBean dan DisposableBean, kita juga bisa menggunakan annotation untuk mendaftarkan callback method untuk lifeCycle
     * pada annotation @Bean, terdapat mehtod initMethod() dan destroyMethod()
     * iniMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean selesai dibuat
     * destroyMethod() digunakan untuk meregistrasikan method yang akan di panggil ketika bean akan dihancurkan
     * Methodnya harus tanpa parameter, dan return valuenya tidak akan dipedulikan, jadi sebaiknya gunakan tipe void saja
     *
     * @return
     */

    /** @PostConstruct dan @PreDestroy
     * selain menggunakan annotation @Bean, untuk menandai sebuah method adalah init method dan destroy method, kita juga bisa menggunakan annotation pada methodnya secara langsung
     * ini bisa digunakan untuk menghindari kita lupa menyebutkan init dan destroy method ketika membuat @Bean
     * @PostConstruct merupakan method yang dipanggil ketika bean diselesai dibuat
     * @PreDestroy merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan
     * jika sudah menggunakan annotation ini, kita tidak perlu lagi menyebutkannya dalam @Bean

     * @return
     */



//    @Bean(initMethod = "start",destroyMethod = "stop")//value disini adalah nama method yang telah di buat di class Server
    @Bean//jika menggunakan cara @PostConstruct dan @PreDestroy tidak perlu initMethod dan destroyMethod
    public Server server(){
        return new Server();
    }



}
