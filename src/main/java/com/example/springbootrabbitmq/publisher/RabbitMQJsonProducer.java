package com.example.springbootrabbitmq.publisher;

import com.example.springbootrabbitmq.dto.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.json.name}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    public void sendJsonMessage(User user) {
        LOGGER.info(String.format("Message sent => %s", user.toString()) );
        rabbitTemplate.convertAndSend(exchange, routingKey, user );
    }

}
