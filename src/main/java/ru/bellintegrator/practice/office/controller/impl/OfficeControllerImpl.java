package ru.bellintegrator.practice.office.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.controller.OfficeController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    @Autowired
    private OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }


    @Override
    @RequestMapping(value = "/save", method = {POST})
    public void addOffice(OfficeView office) {

    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public void updateOffice(OfficeView office) {

    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public void deleteOffice(Long id) {

    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public OfficeView getOffice(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<OfficeView> getAllOffices() {
        return officeService.offices();
    }
}
