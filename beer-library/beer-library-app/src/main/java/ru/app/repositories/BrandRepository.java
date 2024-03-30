package ru.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
