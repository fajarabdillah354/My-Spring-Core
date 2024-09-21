package my.spring.core;

import lombok.Data;
import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import my.spring.core.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Data
public class DependencyInjectionConfiguration {

    @Primary
    @Bean
    public Foo fooFirst(){
        return new Foo();
    }


    @Bean
    public Foo fooSecond(){//bean hanya boleh 1 jika duplicate yang satunya primary
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }



    //ini kebetulan disatu file yang sama
    @Bean
    public FooBar fooBar (@Qualifier("fooSecond") Foo foo, Bar bar){//kita tinggal set foo dan bar, nanti spring akan depand dengan otomatis dan mencari otomatis ke bean yang bernama foo dan bar
        return new FooBar(foo, bar);
    }

    /** Memilih Dependency
     * Kadang saat menggunakan Dependency Injection kita ingin memilih object mana yang ingin kita gunakan
     * saat terdapat duplicate bead dengan tipe data yang sama, secara otomatis Spring akan memilih baen yang primary
     * namun kita juga bisa memilih secara manual jika diperlukan
     * Dengan menggunakan annotation @Qualifier(value="namaBean") pada parameter di methodnya
     *
     */


}
