package ru.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.dto.ColorDto;
import ru.app.services.ColorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ColorRestController {

    private final ColorService colorService;

    @GetMapping("/api/colors")
    public List<ColorDto> getColors() {
        return colorService.findAllColors();
    }
}