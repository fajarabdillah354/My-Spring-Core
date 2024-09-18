package my.spring.core.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * pada class ini depend ke class Foo dan Bar
 * pada constructor di kelas ini parameternya adalah class Foo dan Bar
 */


@AllArgsConstructor
@Data
public class FooBar {

    private Foo foo;

    private Bar bar;


}
