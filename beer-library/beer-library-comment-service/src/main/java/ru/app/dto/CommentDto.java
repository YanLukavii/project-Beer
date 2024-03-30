package ru.app.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommentDto {

    private Long id;

    private String text;
}
