package my.spring.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class AppStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    /** Spring Application Event
     * sebelummnya kita sudah mengetahui tentang Listener
     * di SpringBoot, terdapat banyak sekali event yang dikirim ketika aplikasi SpringBoot berjalan
     * jika kita ingin, kita bisa membuat Listener untuk menerima Event tersebut
     * @param event
     */

    /** Daftar Event
     * ApplicationStartingEvent -> dikirim ketika start aplikasi
     * ApplicationContextInitializedEvent -> dikirim ketika ApplicationContext sudah di inisiasi
     * ApplicationStartedEvent ->dikirim ketika applikasi sudah berjalan
     * ApplicationFailedEvent -> dikirim ketika aplikasi gagal berjalan
     *
     * @param event
     */

    //ini contoh jika menggunakan bean

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("Application Starting");
    }
}
