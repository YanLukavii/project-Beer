package ru.app.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;
import ru.app.dto.CommentDto;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CommentsCacheServiceImpl implements CommentsCacheService {
    private final Cache<Long, List<CommentDto>> messageCache = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build();

    public void addMessageToCache(Long key, List<CommentDto> message) {
        messageCache.put(key, message);
    }

    public List<CommentDto> getMessageFromCache(Long key) {
        return messageCache.getIfPresent(key);
    }

}