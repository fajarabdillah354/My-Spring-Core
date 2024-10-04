package my.spring.core.processor;


import my.spring.core.data.Foo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class FooBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //kita bisa memodifakasi beanfactorynya dengan implement BeanFactoryPostProcessor

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //meregistrasikan bean baru dengan tipe Foo scope singleton dan nama bean foo

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setScope("singleton");
        beanDefinition.setBeanClass(Foo.class);

        registry.registerBeanDefinition("foo", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionRegistryPostProcessor.super.postProcessBeanFactory(beanFactory);
    }
}
