package ru.app.services.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaCommentProducerServiceImpl implements KafkaCommentProducerService {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    private final String topic;

    public KafkaCommentProducerServiceImpl(KafkaTemplate<String, Long> kafkaTemplate,
                                           @Value("${application.kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(Long beerId) {
        kafkaTemplate.send(topic, beerId);
        log.info("Send message :{}", beerId.toString());
    }

}