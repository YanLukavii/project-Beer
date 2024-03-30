package ru.app.services;

import ru.app.dto.CommentDto;

import java.util.List;

public interface CommentsCacheService {

    void addMessageToCache(Long key, List<CommentDto> message);

    List<CommentDto> getMessageFromCache(Long key);

}