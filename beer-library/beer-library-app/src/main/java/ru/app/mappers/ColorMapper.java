package ru.app.mappers;

import org.mapstruct.Mapper;
import ru.app.dto.ColorDto;
import ru.app.models.Color;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    ColorDto toDto(Color color);

}