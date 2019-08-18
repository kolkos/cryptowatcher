package nl.kolkos.cryptowatcher.controllers;

import nl.kolkos.cryptowatcher.senders.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMessageController {
    private final MessageSenderService orderMessageSender;

    @Autowired
    public TestMessageController(MessageSenderService orderMessageSender) {
        this.orderMessageSender = orderMessageSender;
    }

    @PostMapping("/sendMsg")
    public String handleMessage(String order) {
        orderMessageSender.sendOrder(order);

        return "Done";
    }
}
