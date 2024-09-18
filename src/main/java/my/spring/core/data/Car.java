package my.spring.core.data;

import lombok.Getter;
import my.spring.core.aware.IdAware;
import org.springframework.stereotype.Component;

@Component
public class Car implements IdAware {

    @Getter
    private String id;

    //ketika car ini dibuat sebagai bean otomatis akan diset IDnya oleh IdGeneratorBeanPostProcessor
    @Override
    public void setId(String id) {
        this.id = id;
    }
}
