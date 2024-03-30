package ru.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.app.dto.CommentDto;
import ru.app.exceptions.NotFoundException;

import java.util.List;

@Service
@Slf4j
public class KafkaCommentService {

    private final CommentService commentService;

    private final KafkaTemplate <Long, List<CommentDto>> kafkaTemplate;

    private final String topicName;

    @Autowired
    public KafkaCommentService(CommentService commentService,
                               KafkaTemplate<Long, List<CommentDto>> kafkaTemplate,
                               @Value("${application.kafka.topic2}")String topicName) {
        this.commentService = commentService;
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @KafkaListener(
            topics = "${application.kafka.topic}",
            containerFactory = "listenerContainerFactory")
    public void listen(Long beerId) {

        log.info("Consumed beerId :{}", beerId);

        try {
            List<CommentDto> commentDtos = commentService.findByBeerId(beerId);
            kafkaTemplate.send(topicName, beerId, commentDtos);
            log.info("Send List<CommentDto> :{}", commentDtos.toString());
        } catch (NotFoundException e) {
            log.error("Error processing message for beerId {}: {}", beerId, e.getMessage());
        }
    }
}