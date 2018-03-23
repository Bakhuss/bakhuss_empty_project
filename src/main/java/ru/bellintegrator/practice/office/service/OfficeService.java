package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

public interface OfficeService {

    void addOffice(OfficeView office);

    void updateOffice(OfficeView office);

    OfficeView findById(Long id);

}
