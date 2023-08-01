package com.example.rabbitMQconsumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final RabbitTemplate rabbitTemplate;

    public Controller(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/receive")
    public String get(){
//        Message message = rabbitTemplate.receive("mack");
        String message = (String) rabbitTemplate.receiveAndConvert("mack");
        return message;
    }

    @RabbitListener(queues = "fast")
    public void read(String s){
        System.out.println(s);
    }

}
