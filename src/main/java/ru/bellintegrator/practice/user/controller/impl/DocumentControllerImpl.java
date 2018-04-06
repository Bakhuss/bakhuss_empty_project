package ru.bellintegrator.practice.user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.user.controller.DocumentController;
import ru.bellintegrator.practice.user.model.Document;
import ru.bellintegrator.practice.user.service.DocumentService;
import ru.bellintegrator.practice.user.view.DocumentView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/document", produces = APPLICATION_JSON_VALUE)
public class DocumentControllerImpl implements DocumentController {

    private final DocumentService docService;

    @Autowired
    private DocumentControllerImpl(DocumentService docService) {
        this.docService = docService;
    }


    @Override
    public void addDocument(Document doc) {

    }

    @Override
    public void updateDocument(Document doc) {

    }

    @Override
    public Document getDocument(Long id) {
        return null;
    }

    @Override
    public DocumentView getAllDocuments() {
        return null;
    }

    @Override
    public void deleteDocument(Document doc) {

    }
}
