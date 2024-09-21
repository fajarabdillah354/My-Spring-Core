package my.spring.core;

import my.spring.core.data.cyclic.CyclicA;
import my.spring.core.data.cyclic.CyclicB;
import my.spring.core.data.cyclic.CyclidC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CyclicConfiguration {

    //ini adalah dependency circular A->B->C->A (lingkaran)

    @Bean
    private CyclicA cyclicA(CyclicB cyclicB){
        return new CyclicA(cyclicB);
    }

    @Bean
    private CyclicB cyclicB(CyclidC cyclidC){
        return new CyclicB(cyclidC);
    }

    @Bean
    private CyclidC cyclidC(CyclicA cyclicA){
        return new CyclidC(cyclicA);
    }



}
