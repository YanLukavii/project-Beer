package ru.app.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.models.Comment;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    @EntityGraph(attributePaths = {"beer"})
    List<Comment> findByBeerId(Long beerId);
}