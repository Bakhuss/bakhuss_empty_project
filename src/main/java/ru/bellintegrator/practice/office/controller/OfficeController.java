package ru.bellintegrator.practice.office.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeController {

    Boolean addOffice(@RequestBody OfficeView officec);

    Boolean updateOffice(OfficeView office);

    Boolean deleteOffice(Long id);

    OfficeView getOffice(@PathVariable(required = false) Long id);

    List<OfficeView> getAllOffices(OfficeView office);

}
