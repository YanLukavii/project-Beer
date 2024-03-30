package ru.app.services.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import ru.app.dto.CommentDto;

import java.util.List;

public interface KafkaCommentConsumerService {

    void listen(List<ConsumerRecord<Long, List<CommentDto>>> records);

    List<CommentDto> getCommentsByBookIdFromCache(Long key);

}
