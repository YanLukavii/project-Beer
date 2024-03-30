package ru.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.app.dto.CommentDto;
import ru.app.services.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @GetMapping("/api/comments")
    public List<CommentDto> getCommentsByBeerId(@RequestParam Long beerId) {
        return commentService.findByBeerId(beerId);
    }
}
