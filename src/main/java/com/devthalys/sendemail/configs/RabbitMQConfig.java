package com.devthalys.sendemail.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value(("${spring.rabbitmq.queue}"))
    private String queue;

    // durable = true -> If rabbitmq interrupted, will not lose messages from the queue
    @Bean
    public Queue queue(){
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
