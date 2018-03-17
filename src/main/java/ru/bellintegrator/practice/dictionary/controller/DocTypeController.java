package ru.bellintegrator.practice.dictionary.controller;

import ru.bellintegrator.practice.dictionary.view.DocTypeView;

import java.util.List;

/**
 * Controller для работы с DocType
 */
public interface DocTypeController {

    /**
     * Get all types of documents
     * @return JSON types of documents values
     */
    List<DocTypeView> getAllDocTypes();

}
