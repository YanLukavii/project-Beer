package ru.app.services.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.app.dto.CommentDto;
import ru.app.services.CommentsCacheServiceImpl;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaCommentConsumerServiceImpl implements KafkaCommentConsumerService {

    private final CommentsCacheServiceImpl commentsCacheServiceImpl;

    @KafkaListener(
            topics = "${application.kafka.topic2}",
            containerFactory = "listenerContainerFactory")
    public void listen(List<ConsumerRecord<Long, List<CommentDto>>> records) {
        log.info("Consumed ConsumerRecord :{}", records.toString());

        for (ConsumerRecord<Long, List<CommentDto>> record : records) {
            Long key = record.key();
            log.info("Consumed KEY-beerId :{}", key);

            List<CommentDto> value = record.value();
            log.info("Consumed value-List<CommentDto> :{}", value);

            commentsCacheServiceImpl.addMessageToCache(key, value);
        }

    }

    public List<CommentDto> getCommentsByBookIdFromCache(Long key) {
        return commentsCacheServiceImpl.getMessageFromCache(key);
    }

}