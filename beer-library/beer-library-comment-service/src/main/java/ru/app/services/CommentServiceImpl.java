package ru.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.app.dto.CommentDto;
import ru.app.exceptions.NotFoundException;
import ru.app.mappers.CommentMapper;
import ru.app.repositories.BeerRepository;
import ru.app.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final BeerRepository beerRepository;

    private final CommentMapper commentMapper;

    @Transactional(readOnly = true)
    @Override
    public CommentDto findById(Long id) {
        return commentMapper.toDto(commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment with id %d not found".formatted(id))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommentDto> findByBeerId(Long beerId) {

        beerRepository.findById(beerId)
                .orElseThrow(() -> new NotFoundException("Beer with id %d not found".formatted(beerId)));

        return commentRepository.findByBeerId(beerId)
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

}