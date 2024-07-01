package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.dto.BrandDto;
import ru.app.exceptions.NotFoundException;
import ru.app.mappers.BrandMapper;
import ru.app.repositories.BrandRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;

    @Override
    public BrandDto findById(Long id) {
        return brandMapper.toDto(brandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Brand with id %d not found".formatted(id))));
    }

    @Override
    public List<BrandDto> findAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toDto)
                .collect(Collectors.toList());
    }
}
