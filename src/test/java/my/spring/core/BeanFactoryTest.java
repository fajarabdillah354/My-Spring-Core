package my.spring.core;

import my.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTest {


    /** Bean Factory
     * ApplicationContext adalah interface dari BeanFactory
     * Bean Factory merupakan kontrak untuk management bean di spring
     * method yang sebelumnya kita gunakan untuk mengambil bean, sebenernya merupakan method kontrak darri interfacce BeanFactory
     *
     */

    /** Listable Bean Factory
     * Bean Factory hanya bisa digunakan untuk mengakses single bean ,artinya jika terdapat bean dengan tipe yang sama, kita harus sebutkan satu per satu nama beannya
     * Listable Bean Factory adalah turunan dari Bean Factory yang bisa kita gunakan untuk mengakses beberapa bean sekaligus
     * dalam beberapa kasus, ini sangat berguna, seperti misalnya kita ingin mengambil semua bean dengan tipe tertentu
     * Application Context juga merupakan turunan dari interface dari Interface Listable Bean Factory
     *
     */

    private ConfigurableApplicationContext applicationContext;

    //kita bisa mengambil beberapa bean atau menseleksi beberapa bean dari ApplicationContext, karna dia turunan dari Bean Factory

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ScanComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }


    @Test
    void testBeanFactory() {
        //untuk hanya mendapatkan jumlah bean nya saja tanpa mendapatkan nama beannya kita bisa menggunakan ObjectProvider dengan method getBeanProvider()

        ObjectProvider<Foo> provider = applicationContext.getBeanProvider(Foo.class);
        List<Foo> foos = provider.stream().collect(Collectors.toList());
        System.out.println(foos);



        //jika kita mau mengambil bean dengan nama beannya kita menggunakan Map<String, ObjectBean> dengan method getBeanOfType()
        Map<String, Foo> beans = applicationContext.getBeansOfType(Foo.class);
        System.out.println(beans);


    }
}
