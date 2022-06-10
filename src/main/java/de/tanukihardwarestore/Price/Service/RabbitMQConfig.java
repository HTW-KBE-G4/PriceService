package de.tanukihardwarestore.Price.Service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"price-service"})
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("tanuki.price.requests");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tanuki.price");
    }

    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("price");
    }

    @Bean
    public PriceServer server() {
        return new PriceServer();
    }

}