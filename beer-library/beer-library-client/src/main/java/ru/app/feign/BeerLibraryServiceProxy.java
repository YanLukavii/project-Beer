package ru.app.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.app.dto.BeerDto;
import ru.app.dto.BrandDto;
import ru.app.dto.ColorDto;
import ru.app.dto.BeerCreateDto;
import ru.app.dto.BeerUpdateDto;

import java.util.List;

@FeignClient(name = "beer-library-app")
public interface BeerLibraryServiceProxy {

    @CircuitBreaker(name = "beer-library-app", fallbackMethod = "fallbackGetAllBeer")
    @GetMapping("/api/beers")
    List<BeerDto> getAllBeer();

    default List<BeerDto> fallbackGetAllBeer(Throwable throwable) {
        return List.of(new BeerDto());
    }

    @CircuitBreaker(name = "beer-library-app", fallbackMethod = "fallbackGetAllBrand")
    @GetMapping("/api/brands")
    List<BrandDto> getAllBrands();

    default List<BrandDto> fallbackGetAllBrand(Throwable throwable) {
        return List.of(new BrandDto());
    }

    @CircuitBreaker(name = "beer-library-app", fallbackMethod = "fallbackGetAllColor")
    @GetMapping("/api/colors")
    List<ColorDto> getAllColors();

    default List<ColorDto> fallbackGetAllColor(Throwable throwable) {
        return List.of(new ColorDto());
    }

    @PostMapping("/api/beers")
    @ResponseStatus(HttpStatus.CREATED)
    BeerDto createBeer(@Valid @RequestBody BeerCreateDto beerCreateDto);

    @DeleteMapping("/api/beers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBeer(@PathVariable("id") Long id);

    @PutMapping("/api/beers/{id}")
    BeerDto updateBeer(@PathVariable("id") Long id,
                       @Valid @RequestBody BeerUpdateDto beerUpdateDto);

}