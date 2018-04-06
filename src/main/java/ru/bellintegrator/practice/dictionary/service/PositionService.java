package ru.bellintegrator.practice.dictionary.service;

import ru.bellintegrator.practice.dictionary.model.Position;
import ru.bellintegrator.practice.dictionary.view.PositionView;

import java.util.List;

public interface PositionService {

    void add(Position position);

    Position findById(Long id);

    Position findByName(String name);

    List<Position> positions();

    void update(Position position);

    void delete(Position position);

}
