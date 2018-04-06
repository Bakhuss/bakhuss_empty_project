package ru.bellintegrator.practice.dictionary.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.dao.CountryDao;
import ru.bellintegrator.practice.dictionary.model.Country;
import ru.bellintegrator.practice.dictionary.service.CountryService;
import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CountryServiceImpl implements CountryService {
    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }


    @Override
    public Country getById(Long id) {
        return countryDao.findOne(id);
    }

    @Override
    public Country getByName(String name) {
        return countryDao.findByName(name);
    }

    @Override
    public ResponseView getAllCountries() {
        List<Country> countries = StreamSupport
                .stream(countryDao.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Function<Country, CountryView> countryViewFunc = country -> {
            CountryView v = new CountryView();
            v.name = country.getName();
            v.code = country.getCode();
            return v;
        };

        ResponseView view = new ResponseView();
        view.data = countries
                .stream()
                .map(countryViewFunc)
                .collect(Collectors.toList());

        return view;
    }
}
