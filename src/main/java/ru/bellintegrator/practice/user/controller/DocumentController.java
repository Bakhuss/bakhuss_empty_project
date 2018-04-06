package ru.bellintegrator.practice.user.controller;

import ru.bellintegrator.practice.user.model.Document;
import ru.bellintegrator.practice.user.view.DocumentView;

/**
 * Controller для работы с Document
 */
public interface DocumentController {

    void addDocument(Document doc);

    void updateDocument(Document doc);

    Document getDocument(Long id);

    DocumentView getAllDocuments();

    void deleteDocument(Document doc);

}
