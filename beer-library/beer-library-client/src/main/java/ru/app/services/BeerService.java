package ru.app.services;

import ru.app.dto.BeerCreateDto;
import ru.app.dto.BeerDto;
import ru.app.dto.BeerUpdateDto;

import java.util.List;

public interface BeerService {

    List<BeerDto> findAll();

    void deleteById(Long beerId);

    BeerDto create(BeerCreateDto beerCreateDto);

    BeerDto update(Long id,BeerUpdateDto beerUpdateDto);

}