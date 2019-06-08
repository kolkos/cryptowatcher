package nl.kolkos.cryptowatcher.receivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.kolkos.cryptowatcher.Models.TelegramMessage;
import nl.kolkos.cryptowatcher.restclient.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RabbitListener(queues = "telegram.out")
public class Receiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(Receiver.class);


    @Autowired
    private RestClient restClient;

    @RabbitHandler
    public void receive(String in) {
        LOGGER.info("Received: {}", in);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TelegramMessage telegramMessage = objectMapper.readValue(in, TelegramMessage.class);

            LOGGER.info("Text: {}", telegramMessage.getText());

        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.info(restClient.getRequestJSON());
    }



}
