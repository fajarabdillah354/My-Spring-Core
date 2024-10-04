package my.spring.core;

import my.spring.core.data.Bar;
import my.spring.core.data.Foo;
import my.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

public class OptionalConfiguration {

    @Bean
    public Foo foo(){
        return new Foo();
    }


    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar){//membuat parameter menjadi tidak wajib dengan Class Optional<>
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }

}
