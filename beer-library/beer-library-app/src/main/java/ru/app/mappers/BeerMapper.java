package ru.app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.app.dto.BeerDto;
import ru.app.models.Beer;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    @Mappings({
            @Mapping(target = "color", source = "color.name"),
            @Mapping(target = "brand", source = "brand.name"),
            @Mapping(target = "manufacturer", source = "brand.manufacturer.name"),
            @Mapping(target = "country", source = "brand.manufacturer.country.name")
    })
    BeerDto toDto(Beer beer);

}