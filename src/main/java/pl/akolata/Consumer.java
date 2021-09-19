package pl.akolata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.akolata.model.Message;

import static pl.akolata.config.RabbitMqConfig.QUEUE_NAME;

@Slf4j
@Service
public class Consumer {

    @RabbitListener(queues = {QUEUE_NAME})
    public void consume(Message message) {
        log.info("Received message [{}]", message);
    }

}
