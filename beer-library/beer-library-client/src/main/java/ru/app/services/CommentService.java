package ru.app.services;

import ru.app.dto.CommentDto;

import java.util.List;

public interface CommentService {


    List<CommentDto> findByBeerId(Long beerId);


}
