package ru.bellintegrator.practice.office.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.office.controller.OfficeController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    @Autowired
    private OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }


    @Override
    @PostMapping(value = "/save")
    public ResponseView addOffice(OfficeView office) {
        return officeService.add(office);
    }

    @Override
    @PostMapping(value = "/update")
    public ResponseView updateOffice(OfficeView office) {
        return officeService.update(office);
    }

    @Override
    @PostMapping(value = "/delete")
    public ResponseView deleteOffice(OfficeView office) {
        return officeService.delete(office);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseView getOffice(@PathVariable("id") String id) {
        return officeService.findById(id);
    }

    @Override
    @PostMapping(value = "/list")
    public ResponseView getAllOffices(@RequestBody OfficeFilter filter) {
        return officeService.offices(filter);
    }
}
