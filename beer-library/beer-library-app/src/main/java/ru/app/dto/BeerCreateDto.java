package ru.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BeerCreateDto {

    @NotBlank
    private String title;

    @NotBlank
    private String alcoholPercentage;

    @NotBlank
    private String volume;

    @NotNull
    private Long colorId;

    @NotNull
    private Long brandId;

}