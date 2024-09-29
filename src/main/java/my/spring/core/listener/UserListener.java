package my.spring.core.listener;

import lombok.extern.slf4j.Slf4j;
import my.spring.core.event.LoginSuccesEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {

    /** Cara kerja Event Listener Annotation
     * Annotation @EventListener bekerja dengan menggunakan Bean Post Processor bernama EventListenerMethodProcessor
     * EventListenerMethodProcessor mendeteksi jika ada bean yang memiliki method dengan annotation @EventListener, maka secara otomatis akan membuat listener baru lalu meregistrasikan ke applicationContext.addApplication(listener)
     *
     * @param loginSuccesEvent
     */


    //dengan menggunakan annotation @EventListener membuat pembuatan Event jadi fleksibel dan bisa membuat banyak event sekaligus dengan tipe Event yang berbeda2

    @EventListener(LoginSuccesEvent.class)//ini lebih mudah karena bisa membuat beberapa method yang ada annotation @EventListenernya
    public void onLoginSuccessEvent(LoginSuccesEvent loginSuccesEvent){

        log.info("Success login for username {}",loginSuccesEvent.getUser());

    }


    @EventListener(LoginSuccesEvent.class)
    public void onLoginSuccessEvent2(LoginSuccesEvent loginSuccesEvent){

        log.info("Success login for username {}",loginSuccesEvent.getUser());

    }


    @EventListener(LoginSuccesEvent.class)
    public void onLoginSuccessEvent3(LoginSuccesEvent loginSuccesEvent){

        log.info("Success login for username {}",loginSuccesEvent.getUser());

    }


}
