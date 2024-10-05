package my.spring.core;

import my.spring.core.client.PaymentGatewayClient;
import my.spring.core.factory.FactoryPaymentGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(FactoryPaymentGateway.class);
        applicationContext.registerShutdownHook();
    }


    @Test
    void testFactory() {

        /** FactoryBean
         * kadang ada kasus dimana sebuah class yang bukan milik kita contoh third party library
         * sehingga agak sulit jika kita harus menambahkan annotation pada class tersebut
         * pada kasus seperti ini, cara terbaik untuk membuat beannya adalah dengan menggunakan @Bean method
         * atau di Spring, kita juga bisa menggunakan @Componen,namun kita perlu wrap dalam clas FactoryBean
         */


        PaymentGatewayClient client = applicationContext.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(client);
        Assertions.assertEquals("https://fajar.com", client.getEndPoint());


    }
}
