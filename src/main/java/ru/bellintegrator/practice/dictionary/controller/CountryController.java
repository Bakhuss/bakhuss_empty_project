package ru.bellintegrator.practice.dictionary.controller;

import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;

/**
 * Controller для работы с Country
 */
public interface CountryController {

    /**
     * Get all countries
     * @return JSON countries values
     */
    List<CountryView> getAllCountries();

}
