package my.spring.core.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Data
public class CyclicA {


    //ini adalah conth dari circular dependency. ini akan error dan berbahaya

    private CyclicB cyclicB;


}
