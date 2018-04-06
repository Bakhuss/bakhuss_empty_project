package ru.bellintegrator.practice.dictionary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dictionary.model.Country;

/**
 * DAO для работы с Country
 */
@Repository
public interface CountryDao extends CrudRepository<Country, Long> {

    Country findByName(String name);

}
