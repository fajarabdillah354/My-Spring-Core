package my.spring.core.factory;

import my.spring.core.client.PaymentGatewayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryPaymentGateway implements FactoryBean<PaymentGatewayClient> {

    //dengan implement ke FactoryBean kita dapet membuat Component dari class2 yang tidak kita ubah atau dari thirt party

    @Override
    public PaymentGatewayClient getObject() throws Exception {
        PaymentGatewayClient paymentGatewayClient = new PaymentGatewayClient();
        paymentGatewayClient.setEndPoint("https://fajar.com");
        paymentGatewayClient.setPublicKey("public");
        paymentGatewayClient.setPrivateKey("private");
        return paymentGatewayClient;


    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
