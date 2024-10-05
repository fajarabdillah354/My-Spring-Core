package my.spring.core;

import my.spring.core.configuration.CustomerConfiguration;
import my.spring.core.repository.CustomerRepository;
import my.spring.core.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierTest {

    /** Qualifier
     * seperti yang sudah dijelaskan di awal, jika terdapat bean dengan tipe data yang sama lebih dari satu, maka secara otomatis Spring akan bingung memilih bean yang mana yang akan digunakan
     * kita perlu memilih salah satu menjadi primary, yang secara otomatis akand pilih oleh Spring
     * namun jika kita ingin memilih bean secara manual kita juga bisa menggunakan @Qualifier
     * kita bisa tambahkan @Qualifier di constructor parameter, di setter method atau di field
     * @AutoWired untuk menulis multiple constructor
     */


    private ConfigurableApplicationContext applicationContext;


    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();

    }


    @Test
    void testErrorBeanQualifier() {

        //ini akan error jika terdapat 2 bean dalam 1 component

        CustomerService service = applicationContext.getBean(CustomerService.class);

        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository",CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository",CustomerRepository.class);

        Assertions.assertSame(normalCustomerRepository, service.getNormalCustomer());
        Assertions.assertSame(premiumCustomerRepository, service.getPremiumCustomer());


    }
}
