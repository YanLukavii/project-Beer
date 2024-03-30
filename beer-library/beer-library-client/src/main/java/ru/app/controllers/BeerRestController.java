package ru.app.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.app.dto.BeerCreateDto;
import ru.app.dto.BeerDto;
import ru.app.dto.BeerUpdateDto;
import ru.app.services.BeerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BeerRestController {

    private final BeerService beerService;

    @GetMapping("/api/beers")
    public List<BeerDto> getAllBeers() {
        return beerService.findAll();
    }

    @PostMapping("/api/beers")
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDto createBeer(@Valid @RequestBody BeerCreateDto beerCreateDto) {
        return beerService.create(beerCreateDto);
    }

    @DeleteMapping("/api/beers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("id") Long id) {
        beerService.deleteById(id);
    }

    @PutMapping("/api/beers/{id}")
    public BeerDto updateBeer(@PathVariable("id") Long id,
                              @Valid @RequestBody BeerUpdateDto beerUpdateDto) {
        return beerService.update(id, beerUpdateDto);
    }
}