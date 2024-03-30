package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.app.dto.ColorDto;
import ru.app.exceptions.NotFoundException;
import ru.app.mappers.ColorMapper;
import ru.app.repositories.ColorRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    private final ColorMapper colorMapper;

    @Transactional(readOnly = true)
    @Override
    public ColorDto findById(Long id) {
        return colorMapper.toDto(colorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Color with id %d not found".formatted(id))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ColorDto> findAll() {

        return colorRepository.findAll()
                .stream()
                .map(colorMapper::toDto)
                .collect(Collectors.toList());
    }
}