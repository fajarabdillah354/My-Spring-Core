package my.spring.core.service;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements ApplicationContextAware, BeanNameAware {

    /** interface Aware
     * ApplicationContextAware dan BeanNameAware adalah turunan dari interface Aware
     * masih banyak lagi yang lainnya
     */

    //dengan menggunakan ApplicationContextAware dan BeanNameAware saat setApplicationContext dan beanName akan di inject secara otomatis oleh Spring

    // kita tidak perlu menambahkan @AutoWired

    @Getter
    private String beanName;


    @Getter
    private ApplicationContext applicationContext;//untuk mengetes bisa applicationContext = getApplicationContext

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}
