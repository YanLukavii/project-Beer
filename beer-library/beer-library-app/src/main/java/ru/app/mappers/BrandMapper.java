package ru.app.mappers;

import org.mapstruct.Mapper;
import ru.app.dto.BrandDto;
import ru.app.models.Brand;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDto toDto(Brand brand);

}