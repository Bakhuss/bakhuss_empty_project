package ru.bellintegrator.practice.dictionary.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dictionary.controller.CountryController;
import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/countries", produces = APPLICATION_JSON_VALUE)
public class CountryControllerImpl implements CountryController {


    @Override
    @RequestMapping(method = {POST})
    public List<CountryView> getAllCountries() {
        return null;
    }
}
