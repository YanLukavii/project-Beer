package ru.app.services;

import ru.app.dto.ColorDto;

import java.util.List;

public interface ColorService {

    List<ColorDto> findAllColors();

}
