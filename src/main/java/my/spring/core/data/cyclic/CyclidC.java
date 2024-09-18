package my.spring.core.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplicationRunListener;

@AllArgsConstructor
@Data
public class CyclidC {

    private CyclicA cyclicA;


}
