package my.spring.core.service;


import my.spring.core.data.User;
import my.spring.core.event.LoginSuccesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;


    }

    public boolean login(String username, String password){
        if (isLoginSuccess(username, password)){
            publisher.publishEvent(new LoginSuccesEvent(new User(username)));
            return true;
        }else {
            return false;
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        return "fajar".equals(username) && "fajar".equals(password);
    }
}
