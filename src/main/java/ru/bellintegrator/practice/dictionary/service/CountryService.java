package ru.bellintegrator.practice.dictionary.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.model.Country;

public interface CountryService {

    Country getById(Long id);

    Country getByName(String name);

    ResponseView getAllCountries();

}
