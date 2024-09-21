package my.spring.core.event;

import lombok.Getter;
import my.spring.core.data.User;
import org.springframework.context.ApplicationEvent;

public class LoginSuccesEvent extends ApplicationEvent {

    @Getter
    private final User user;


    public LoginSuccesEvent(Object source) {
        super(source);
        this.user = (User) source;
    }
}
