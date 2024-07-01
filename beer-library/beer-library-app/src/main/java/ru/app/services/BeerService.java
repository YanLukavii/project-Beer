package ru.app.services;

import ru.app.dto.BeerCreateDto;
import ru.app.dto.BeerDto;
import ru.app.dto.BeerUpdateDto;
import ru.app.models.Beer;

import java.util.List;

public interface BeerService {

    List<BeerDto> findAll();

    List<Beer> findByBrandName(String brandName);

    List<BeerDto> findBeerByManufacturerName(String manufacturerName);

    void deleteById(Long beerId);

    BeerDto create(BeerCreateDto beerCreateDto);

    BeerDto update(BeerUpdateDto beerUpdateDto);


}
