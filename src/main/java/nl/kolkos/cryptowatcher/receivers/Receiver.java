package nl.kolkos.cryptowatcher.receivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.kolkos.cryptowatcher.models.TelegramMessage;
import nl.kolkos.cryptowatcher.restcalls.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Arrays;

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

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String response = restClient.doRestRequest(headers, HttpMethod.GET, "https://api.blockcypher.com/v1/btc/main/addrs/1DEP8i3QJCsomS4BSMY2RpU1upv62aGvhD/balance");
        if(response != null){
            LOGGER.info(response);
        }

    }



}
