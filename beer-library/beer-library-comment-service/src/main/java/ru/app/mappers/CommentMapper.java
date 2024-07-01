package ru.app.mappers;

import org.mapstruct.Mapper;
import ru.app.dto.CommentDto;
import ru.app.models.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto toDto(Comment comment);

}