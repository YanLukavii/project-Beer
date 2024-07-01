package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.dto.BeerCreateDto;
import ru.app.dto.BeerDto;
import ru.app.dto.BeerUpdateDto;
import ru.app.feign.BeerLibraryServiceProxy;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerLibraryServiceProxy beerLibraryServiceProxy;

    @Override
    public List<BeerDto> findAll() {
        return beerLibraryServiceProxy.getAllBeer();
    }

    @Override
    public void deleteById(Long beerId) {
        beerLibraryServiceProxy.deleteBeer(beerId);
    }

    @Override
    public BeerDto create(BeerCreateDto beerCreateDto) {
        return beerLibraryServiceProxy.createBeer(beerCreateDto);
    }

    @Override
    public BeerDto update(Long id, BeerUpdateDto beerUpdateDto) {
        beerUpdateDto.setId(id);
        return beerLibraryServiceProxy.updateBeer(id, beerUpdateDto);
    }
}