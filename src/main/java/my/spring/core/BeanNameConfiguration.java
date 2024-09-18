package my.spring.core;

import my.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class BeanNameConfiguration {

    @Primary
    @Bean(name = "firstFoo")//dengan parameter name kita bisa mengubah nama bean berbeda dengan nama method
    public Foo foo1(){
        return new Foo();
    }

    @Bean(name = "secondFoo")
    public Foo foo2(){
        return new Foo();
    }


}
