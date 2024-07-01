package ru.app.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.app.models.Beer;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    @EntityGraph(attributePaths = {"color", "brand.manufacturer", "brand.manufacturer.country"})
    List<Beer> findAll();

    List<Beer> findByBrandName(String brandName);

    @Query(" SELECT b" +
            " FROM Beer b" +
            " JOIN b.brand br JOIN br.manufacturer m" +
            " WHERE m.name = :manufacturerName")
    List<Beer> findByManufacturerName(@Param("manufacturerName") String manufacturerName);

}
