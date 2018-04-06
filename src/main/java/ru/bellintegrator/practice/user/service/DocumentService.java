package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.model.Document;

public interface DocumentService {

    void add(Document doc);

    void update(Document doc);

    void delete(Long id);

    Document findById(Long id);

}
