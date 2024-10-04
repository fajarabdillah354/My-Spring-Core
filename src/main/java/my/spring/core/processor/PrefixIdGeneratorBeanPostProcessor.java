package my.spring.core.processor;

import lombok.extern.slf4j.Slf4j;
import my.spring.core.aware.IdAware;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class PrefixIdGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {

    //Dengan menggunakan interface Ordered kita bisa menentukan urutas eksekusinya

    @Override
    public int getOrder() {
        return 2;//urutas eksekusi ini di nomor2
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("prefix generator processor",beanName);
        if(bean instanceof IdAware){
            log.info("prefix set id generator for bean {}",beanName);
            IdAware idAware = (IdAware) bean;
            idAware.setId("FJR -"+idAware.getId());
        }
        return bean;
    }
}
