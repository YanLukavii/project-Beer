package ru.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.app.models.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
