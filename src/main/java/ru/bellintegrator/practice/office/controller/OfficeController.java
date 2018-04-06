package ru.bellintegrator.practice.office.controller;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeView;

/**
 * Controller для работы с Office
 */
public interface OfficeController {

    /**
     * Add office
     * @param office
     * @return success value
     */
    ResponseView addOffice(OfficeView office);

    /**
     * Update office
     * @param office
     * @return success value
     */
    ResponseView updateOffice(OfficeView office);

    /**
     * Delete office
     * @param office
     * @return success value
     */
    ResponseView deleteOffice(OfficeView office);

    /**
     * Get office
     * @param id
     * @return JSON office value
     */
    ResponseView getOffice(String id);

    /**
     * Get all offices
     * @param filter
     * @return JSON offices values
     */
    ResponseView getAllOffices(OfficeFilter filter);

}
