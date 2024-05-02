package com.ms.user.producer;

import com.ms.user.DTO.EmailDTO;
import com.ms.user.config.RabbitMQConfig;
import com.ms.user.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user) {
        var emailDto = new EmailDTO();
        emailDto.setUserId(user.getUserId());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso");
        emailDto.setText(user.getUsername() + ", Seja bem-vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recusos da nossa paltaforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }


}
