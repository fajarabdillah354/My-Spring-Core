package my.spring.core.application;


import my.spring.core.application.FooApplication;
import my.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FooApplication.class)//untuk testnya menggunakan annotation @SpringBootTest
public class SpringBootFooApplicationTest {

    //SpringBoot akan scanning 1 package maka hati dalam meletakan program spring jangan sampai di package yang banyak class atau data-datanya


    /** Banner
     * SpringBoot memiliki fitur banner, dimana saat aplikasi Spring Boot berjalan, kita bisa menampilkan tulisan banner di console
     * Secara default fitur banner ini akan menyala dan akan mencari tulisan banner di classpath dengan nama banner.txt
     * jika tidak ada file tersebut, maka secara otomatis akan menampilkan tulisan banner SpringBoot
     * berikut adalah tempat untuk membuat banner https://www.bagill.com/ascii-sig.php
     *
     */

    //jika menggunakan SpringBoot saat terjadi error, maka error akan diberi tahu descripsinya apa dan action yang bisa dilakukan apa

    /** StartUp Failure
     * salah satu yang menarik di SpringBoot adalah, SpringBoot memiliki fitur FailureAnalyzer
     * FailureAnalyzer digunakan untuk melakukan analisa ketika terjadi error startup yang menyebabkan aplikasi tidak mau berjalan saat pertama kali di jalankan
     * Spring sudah menyediakan banyak sekali class implementasi FailureAnalyzer yang bisa mempermudah kita menganalisa kesalahan ketika terjadi startup failure
     *
     */


    /** Spring Boot Application
     * sebelumnya kita selalu membuat ApplicationContext secara manual, dan kita belum menggunakan fitur otomatis SpringBoot
     * hal ini perlu dilakukan agar mengetahui cara kerja SpringBoot
     * pada saat membuat aplikasi SpringBoot, kita akan mengganti @Configuration utama menjadi @SpringBootApplication
     * isi dari @SpringBootApplication itu sendiri sebenarnya gabungan dari @Configuration dan banyak hal lain, seperti contohnya @ComponentScan
     *
     */

    /** @SpringApplication
     * selain @SpringBootApplication, untuk membuat ApplicationContextnya kita tidak perlu membuat manual, kita bisa gunakan class SpringApplication
     * Secara otomatis SpringApplication akan membuat ApplicationContext dan melakukan hal-hal yang dibutuhkan secara otomatis
     *
     */


    /** @SpringBootTest
     * untuk membuat unit test di SpringBoot, kita bisa menggunakan annotation @SpringBootTest(classes={className.class}
     * Selanjutnya kita tidak perlu mengambil bean secara manual lagi dengan menggunakan ApplicationContext, kita bisa menggunakan Dependency Injection secara langsung di unit testnya menggunakan @AutoWired
     */



    //sebelumnya untuk mendapatkan foo menggunakan applicationContext.getBean(Foo.class)
    //sekarang cukup tambahkan atribute contoh Foo foo lalu tambahnkan annotation @AutoWired maka secara otomatis akan di inject oleh spring bootnya

    //disarankan tikak menggunakan private

    @Autowired
    Foo foo;

    @Test
    void SpringBoot() {
        Assertions.assertNotNull(foo);
    }
}
