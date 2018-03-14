package ru.bellintegrator.practice.dictionary.controller;

import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;

public interface CountryController {

    /**
     * Get all countries
     * @return JSON countries values
     */
    List<CountryView> getAllCountries();

}
