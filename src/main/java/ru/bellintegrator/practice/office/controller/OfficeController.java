package ru.bellintegrator.practice.office.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeController {

    /**
     * Add office
     * @param office
     * @return success value
     */
    Boolean addOffice(@RequestBody OfficeView office);

    /**
     * Update office
     * @param office
     * @return success value
     */
    Boolean updateOffice(OfficeView office);

    /**
     * Delete office
     * @param id
     * @return success value
     */
    Boolean deleteOffice(Long id);

    /**
     * Get office
     * @param id
     * @return JSON office value
     */
    OfficeView getOffice(@PathVariable(required = false) Long id);

    /**
     * Get all offices
     * @param office
     * @return JSON offices values
     */
    List<OfficeView> getAllOffices(OfficeView office);

}
