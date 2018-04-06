package ru.bellintegrator.practice.dictionary.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.controller.CountryController;
import ru.bellintegrator.practice.dictionary.service.CountryService;
import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/countries", produces = APPLICATION_JSON_VALUE)
public class CountryControllerImpl implements CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryControllerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @PostMapping
    public ResponseView getAllCountries() {
        return countryService.getAllCountries();
    }
}
