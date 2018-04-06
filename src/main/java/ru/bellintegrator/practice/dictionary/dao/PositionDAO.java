package ru.bellintegrator.practice.dictionary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dictionary.model.Position;

/**
 * DAO для работы с Position
 */
@Repository
public interface PositionDao extends CrudRepository<Position, Long> {

    Position findByName(String name);

}
