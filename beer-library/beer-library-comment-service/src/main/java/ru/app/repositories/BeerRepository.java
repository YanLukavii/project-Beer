package ru.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.models.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}