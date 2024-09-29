package my.spring.core.listener;

import lombok.extern.slf4j.Slf4j;
import my.spring.core.event.LoginSuccesEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginAgainListener implements ApplicationListener<LoginSuccesEvent> {
    @Override
    public void onApplicationEvent(LoginSuccesEvent event) {
        log.info("Login Success again fo User {} ", event.getUser());
    }
}
