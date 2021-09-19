package pl.akolata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import java.time.LocalDateTime;

import static pl.akolata.config.RabbitMqConfig.EXCHANGE_NAME;
import static pl.akolata.config.RabbitMqConfig.QUEUE_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() {
        Message msg = new Message();
        msg.setMsg("Message from " + LocalDateTime.now());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, QUEUE_NAME, msg);
        log.info("Message with id [{}] send to [{}] exchange with routing key [{}]", msg.getId(), EXCHANGE_NAME, QUEUE_NAME);
    }

}
