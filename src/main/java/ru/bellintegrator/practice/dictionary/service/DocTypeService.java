package ru.bellintegrator.practice.dictionary.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.model.DocType;

public interface DocTypeService {

    ResponseView docTypes();

    DocType getDocType(String name);

}
