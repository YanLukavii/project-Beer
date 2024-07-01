package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.dto.BrandDto;
import ru.app.feign.BeerLibraryServiceProxy;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BeerLibraryServiceProxy beerLibraryServiceProxy;

    @Override
    public List<BrandDto> getAllBrands() {
        return beerLibraryServiceProxy.getAllBrands();
    }
}