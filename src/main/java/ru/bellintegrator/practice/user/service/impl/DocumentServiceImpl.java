package ru.bellintegrator.practice.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.user.dao.DocumentDao;
import ru.bellintegrator.practice.user.model.Document;
import ru.bellintegrator.practice.user.service.DocumentService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DocumentServiceImpl implements DocumentService {
    private final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);

    private final DocumentDao docDao;

    @Autowired
    public DocumentServiceImpl(DocumentDao docDao) {
        this.docDao = docDao;
    }


    @Override
    public void add(Document doc) {
        docDao.save(doc);
    }

    @Override
    public void update(Document doc) {
        docDao.save(doc);
    }

    @Override
    public void delete(Long id) {
        docDao.delete(id);
    }

    @Override
    public Document findById(Long id) {
        return docDao.findOne(id);
    }
}
