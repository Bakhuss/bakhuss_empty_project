package ru.bellintegrator.practice.dictionary.service;

import ru.bellintegrator.practice.dictionary.view.PositionView;

import java.util.List;

public interface PositionService {

    void add(PositionView position);

    PositionView findById(Long id);

    List<PositionView> positions();

    void update(PositionView position);

    void delete(PositionView position);

}
