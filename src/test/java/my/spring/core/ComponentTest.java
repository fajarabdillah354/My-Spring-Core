package my.spring.core;

import my.spring.core.repository.CategoryRepository;
import my.spring.core.repository.ProductRepository;
import my.spring.core.service.CategoryService;
import my.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    /**@Component
     * ketika menggunakana annotation ini kita tidak perlu lagi menggunakan @Bean
     * @Bean akan secara otomatis dibuatkan oleh Spring dari @Component dimana dibuat dari nama classnya yang di camelCase (ex = ProductService -> productService)
     * @Component hanya mendukung 1 @Bean saja,jadi jika kita ingin membuat beberapa bean dengan tipe yang sama ,kita tetep harus menggunakan @Bean method
     *
     */

    private ConfigurableApplicationContext applicationContext;


    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testComponentConstructor() {

        ProductService service1 = applicationContext.getBean(ProductService.class);
        ProductService service2 = applicationContext.getBean("productService",ProductService.class);

        Assertions.assertSame(service1,service2);
    }

    @Test
    void testInjectDependencyComponent() {

        //Dependency Injection to Component dengan Constructor
        ProductService service = applicationContext.getBean(ProductService.class);
        ProductRepository repository = applicationContext.getBean(ProductRepository.class);

        //jika terdapat multiple constructor, kita harus menandai constructor mana yang akan digunakan oleh Spring dengan menggunakan annotation @AutoWired

        Assertions.assertSame(service.getProductRepository(),repository);

    }


    @Test
    void testComponentSetterDependencyIn() {
        //Dependency Injection to Component dengan Setter method

        CategoryService service = applicationContext.getBean(CategoryService.class);
        CategoryRepository repository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(repository, service.getCategoryRepository());
    }


}
