package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.app.repositories.ManufacturerRepository;

@RequiredArgsConstructor
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public ManufacturerService findByName(String manufacturerName) {
        return manufacturerRepository.findByName(manufacturerName);
    }

}