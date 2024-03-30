package ru.app.services;

import ru.app.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto findById (Long id);

    List<CommentDto> findByBeerId (Long beerId);

    void deleteById(Long id);

}
