package my.spring.core.configuration;

import my.spring.core.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomerConfiguration {

    //INGAT TIDAK BOLEH MEMBUAT LEBIH DARI 1 BEAN jika lebih kita harus menambahkan @Primary pada salah satunya

    @Primary
    @Bean
    public CustomerRepository normalCustomerRepository(){
        return new CustomerRepository();
    }

    @Bean
    public CustomerRepository premiumCustomerRepository(){
        return new CustomerRepository();
    }


}
