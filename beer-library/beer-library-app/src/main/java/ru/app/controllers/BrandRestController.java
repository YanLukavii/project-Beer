package ru.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.app.dto.BrandDto;
import ru.app.services.BrandService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrandRestController {

    private final BrandService brandService;

    @GetMapping("/api/brands")
    public List<BrandDto> getAllBrands() {
        return brandService.findAll();
    }


}
