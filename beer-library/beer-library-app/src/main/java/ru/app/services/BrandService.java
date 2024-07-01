package ru.app.services;

import ru.app.dto.BrandDto;

import java.util.List;

public interface BrandService {

    BrandDto findById(Long id);

    List<BrandDto> findAll();

}
