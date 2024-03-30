package ru.app.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.app.dto.CommentDto;
import ru.app.services.kafka.KafkaCommentConsumerService;
import ru.app.services.kafka.KafkaCommentProducerService;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final KafkaCommentProducerService kafkaCommentProducerService;

    private final KafkaCommentConsumerService kafkaCommentConsumerService;


    @Override
    public List<CommentDto> findByBeerId(Long beerId) {

        List<CommentDto> comments = kafkaCommentConsumerService
                .getCommentsByBookIdFromCache(beerId);

        if (comments == null) {

            kafkaCommentProducerService.send(beerId);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return kafkaCommentConsumerService
                    .getCommentsByBookIdFromCache(beerId);
        }

        return comments;
    }

}