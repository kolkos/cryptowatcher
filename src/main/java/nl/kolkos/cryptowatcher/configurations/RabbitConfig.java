package nl.kolkos.cryptowatcher.configurations;

import nl.kolkos.cryptowatcher.receivers.Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String TELEGRAM_OUT_QUEUE = "telegram-out";
    public static final String QUEUE_DEAD_MESSAGES = "dead-msgs-queue";
    public static final String EXCHANGE_TELEGRAM = "telegram-exchange";


    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_TELEGRAM);
    }

    @Bean
    Queue queue() {
        return new Queue(TELEGRAM_OUT_QUEUE, true);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(TELEGRAM_OUT_QUEUE);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(TELEGRAM_OUT_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}