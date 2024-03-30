package ru.app.dto;

import lombok.Data;

@Data
public class BeerDto {

    private Long id;

    private String title;

    private String alcoholPercentage;

    private String volume;

    private String color;

    private String brand;

    private String manufacturer;

    private String country;

}