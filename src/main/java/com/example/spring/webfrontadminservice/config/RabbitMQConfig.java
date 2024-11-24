package com.example.spring.webfrontadminservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "polar.admin";
    public static final String QUEUE_NAME = "polar.admin.catalog";
    public static final String ROUTING_KEY = "catalog.create";

    @Bean
    public DirectExchange catalogExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue catalogQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Binding binding(Queue catalogQueue, DirectExchange catalogExchange) {
        return BindingBuilder
                .bind(catalogQueue)
                .to(catalogExchange)
                .with(ROUTING_KEY);
    }

    // MessageConverter 설정 추가
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // RabbitTemplate에 MessageConverter 설정
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
