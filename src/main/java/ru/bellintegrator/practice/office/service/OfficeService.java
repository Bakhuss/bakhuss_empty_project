package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeService {

    void add(OfficeView office);

    OfficeView findById(Long id);

    List<OfficeView> offices();

    void update(OfficeView office);

    void delete(OfficeView office);

}
