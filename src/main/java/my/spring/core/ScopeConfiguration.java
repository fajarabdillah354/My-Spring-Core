package my.spring.core;


import lombok.extern.slf4j.Slf4j;
import my.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {
    /** @Scope
     * Scope merupakan stratgy caara sebuuah object dibuat
     * Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses akan mengembalikan objecct yang sama
     * namun kita juga bisa mengubah scope bean yang kita mau di Spring
     * untuk mengubah scope sebuat bean, kita bisa tambahkan annotation @Scope(value="")
     * @return
     *
     *
     ** Bean Scope
     * Singleton -> default hanya dibuat sekali dalam spring IoC
     * Prototype -> selalu dibuat object baru setiap kali bean di akses
     * Request -> dibuat baru per HTTP Request (hanya untuk WEB APP)
     * Session -> dibuat baru per HTTP Session (hanya untuk Web App)
     * Application -> dibuat baru per ServletContext(hanya untuk Web App)
     * WebSocket -> dibuat baru per WebSocket(hanya untuk Web App)
     */






    @Bean
    @Scope("prototype")
    public Foo foo(){
        log.info("create new foo");
        return new Foo();
    }


}
