package com.example.spring.webfrontadminservice.service;

import com.example.spring.webfrontadminservice.config.RabbitMQConfig;
import com.example.spring.webfrontadminservice.dto.CreateCatalogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final RabbitTemplate rabbitTemplate;

    public void createCatalog(CreateCatalogRequestDTO createCatalogRequestDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                createCatalogRequestDTO
        );
    }

}
