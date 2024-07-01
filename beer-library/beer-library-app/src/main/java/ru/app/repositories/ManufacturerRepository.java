package ru.app.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.models.Manufacturer;
import ru.app.services.ManufacturerService;

import java.util.List;
import java.util.Optional;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    ManufacturerService findByName(String manufacturerName);

    @EntityGraph(value = "entity-manufacturer-gr")
    List<Manufacturer> findAll();

    @EntityGraph(value = "entity-manufacturer-gr")
    Optional<Manufacturer> findById(Long id);

}