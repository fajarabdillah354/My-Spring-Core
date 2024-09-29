package my.spring.core;


import my.spring.core.data.MercantServiceImpl;
import my.spring.core.service.MercantService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MercantServiceImpl.class)
public class InheritanceConfiguration {
}
