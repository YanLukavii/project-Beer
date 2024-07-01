package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.app.dto.BeerCreateDto;
import ru.app.dto.BeerDto;
import ru.app.dto.BeerUpdateDto;
import ru.app.exceptions.NotFoundException;
import ru.app.mappers.BeerMapper;
import ru.app.models.Beer;
import ru.app.repositories.BeerRepository;
import ru.app.repositories.BrandRepository;
import ru.app.repositories.ColorRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    private final ColorRepository colorRepository;

    private final BrandRepository brandRepository;

    private final BeerMapper beerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<BeerDto> findAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDto)
                .sorted(Comparator.comparing(BeerDto::getId))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Beer> findByBrandName(String brandName) {

        return beerRepository.findByBrandName(brandName);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BeerDto> findBeerByManufacturerName(String manufacturerName) {

        return beerRepository.findByManufacturerName(manufacturerName)
                .stream()
                .map(beerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long beerId) {
        beerRepository.deleteById(beerId);
    }

    @Transactional
    @Override
    public BeerDto create(BeerCreateDto beerCreateDto) {

        var brand = brandRepository.findById(beerCreateDto.getBrandId())
                .orElseThrow(() -> new NotFoundException("Brand with id %d not found"
                        .formatted(beerCreateDto.getBrandId())));

        var color = colorRepository.findById(beerCreateDto.getColorId())
                .orElseThrow(() -> new NotFoundException("Color with id %d not found"
                        .formatted(beerCreateDto.getColorId())));

        var beer = new Beer(0L, beerCreateDto.getTitle(), beerCreateDto.getAlcoholPercentage(),
                beerCreateDto.getVolume(),color , brand);

        return beerMapper.toDto(beerRepository.save(beer));
    }

    @Transactional
    @Override
    public BeerDto update(BeerUpdateDto beerUpdateDto) {

        var beer = beerRepository.findById(beerUpdateDto.getId())
                .orElseThrow(() -> new NotFoundException("Beer with id %d not found"
                        .formatted(beerUpdateDto.getId())));

        var brand = brandRepository.findById(beerUpdateDto.getBrandId())
                .orElseThrow(() -> new NotFoundException("Brand with id %d not found"
                        .formatted(beerUpdateDto.getBrandId())));

        var color = colorRepository.findById(beerUpdateDto.getColorId())
                .orElseThrow(() -> new NotFoundException("Color with id %d not found"
                        .formatted(beerUpdateDto.getColorId())));

        beer.setTitle(beerUpdateDto.getTitle());
        beer.setBrand(brand);
        beer.setColor(color);
        beer.setAlcoholPercentage(beerUpdateDto.getAlcoholPercentage());
        beer.setVolume(beerUpdateDto.getVolume());

        return beerMapper.toDto(beerRepository.save(beer));
    }
}