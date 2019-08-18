package nl.kolkos.cryptowatcher.senders;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.kolkos.cryptowatcher.configurations.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public MessageSenderService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendOrder(String order) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TELEGRAM, RabbitConfig.TELEGRAM_OUT_QUEUE, order);
        /*
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            Message message = MessageBuilder
                                .withBody(orderJson.getBytes())
                                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                                .build();
            this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        */
    }

}
