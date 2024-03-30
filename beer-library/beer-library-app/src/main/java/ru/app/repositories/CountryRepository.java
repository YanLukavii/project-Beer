package ru.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
