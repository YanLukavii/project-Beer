package ru.app.services.kafka;

public interface KafkaCommentProducerService {
    void send(Long beerId);
}
