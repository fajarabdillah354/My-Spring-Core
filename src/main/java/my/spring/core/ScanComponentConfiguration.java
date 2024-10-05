package my.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {//dengan menggunakan ini kita dapat meng import semua isi dari suatu package dengan otomatis contoh disini semua yang ada di dalam configuration di import (ini bisa lebih dari 1)
        "my.spring.core.configuration",
})
public class ScanComponentConfiguration {


    /** @ComponentScan
     * import adalah hal yang penting, karena kita bisa memecah configuration class menjadi banyak class
     * namun semakin lama, configuration class pasti akan semakin banyak karena semakin besar aplikasi kita
     * melakukan import satu persatu tidak disarankan
     * Spring memiliki fitur @ComponentScan, dimana kita bisa secara otomatis mengimport Configuration di sebuah package dan sub package secara otomatis
     *
     */

}
