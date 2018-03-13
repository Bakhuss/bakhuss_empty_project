package ru.bellintegrator.practice.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.user.dao.DocumentDAO;
import ru.bellintegrator.practice.user.service.DocumentService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DocumentServiceImpl implements DocumentService {
    private final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);

    private final DocumentDAO docDao;

    @Autowired
    private DocumentServiceImpl(DocumentDAO docDao) {
        this.docDao = docDao;
    }
}
