package ru.bellintegrator.practice.office.controller;

import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

/**
 * Controller для работы с Office
 */
public interface OfficeController {

    /**
     * Add office
     * @param office
     * @return success value
     */
    void addOffice(OfficeView office);

    /**
     * Update office
     * @param office
     * @return success value
     */
    void updateOffice(OfficeView office);

    /**
     * Delete office
     * @param id
     * @return success value
     */
    void deleteOffice(Long id);

    /**
     * Get office
     * @param id
     * @return JSON office value
     */
    OfficeView getOffice(Long id);

    /**
     * Get all offices
     * @param office
     * @return JSON offices values
     */
    List<OfficeView> getAllOffices(OfficeView office);

}
