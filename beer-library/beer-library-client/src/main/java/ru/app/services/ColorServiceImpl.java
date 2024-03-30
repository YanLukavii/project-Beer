package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.dto.ColorDto;
import ru.app.feign.BeerLibraryServiceProxy;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final BeerLibraryServiceProxy beerLibraryServiceProxy;

    @Override
    public List<ColorDto> findAllColors() {
        return beerLibraryServiceProxy.getAllColors();
    }
}
