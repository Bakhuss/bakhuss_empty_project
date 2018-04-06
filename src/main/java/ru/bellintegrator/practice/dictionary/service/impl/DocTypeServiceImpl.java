package ru.bellintegrator.practice.dictionary.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.dao.DocTypeDao;
import ru.bellintegrator.practice.dictionary.model.DocType;
import ru.bellintegrator.practice.dictionary.service.DocTypeService;
import ru.bellintegrator.practice.dictionary.view.DocTypeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DocTypeServiceImpl implements DocTypeService {
    private final Logger log = LoggerFactory.getLogger(DocTypeServiceImpl.class);

    private final DocTypeDao docTypeDao;

    @Autowired
    public DocTypeServiceImpl(DocTypeDao docTypeDao) {
        this.docTypeDao = docTypeDao;
    }


    @Override
    public ResponseView docTypes() {
        List<DocType> docTypeList = StreamSupport
                .stream(docTypeDao.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Function<DocType, DocTypeView> docTypeFunc = docType -> {
            DocTypeView v = new DocTypeView();
            v.name = docType.getName();
            v.code = docType.getCode();
            return v;
        };

        ResponseView view = new ResponseView();
        view.data = docTypeList.stream()
                .map(docTypeFunc)
                .collect(Collectors.toList());

        return view;
    }

    @Override
    public DocType getDocType(String name) {
        return docTypeDao.findByName(name);
    }
}
