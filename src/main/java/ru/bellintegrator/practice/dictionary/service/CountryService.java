package ru.bellintegrator.practice.dictionary.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.model.Country;

/**
 * Service для работы с Country
 */
public interface CountryService {

    Country getById(Long id);

    Country getByName(String name);

    /**
     * Получение списка всех стран из справочника Country
     * @return
     */
    ResponseView getAllCountries();

}
