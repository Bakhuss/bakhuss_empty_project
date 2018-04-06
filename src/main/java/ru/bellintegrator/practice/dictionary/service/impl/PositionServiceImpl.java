package ru.bellintegrator.practice.dictionary.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dictionary.dao.PositionDao;
import ru.bellintegrator.practice.dictionary.model.Position;
import ru.bellintegrator.practice.dictionary.service.PositionService;
import ru.bellintegrator.practice.dictionary.view.PositionView;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class PositionServiceImpl implements PositionService {
    private final Logger log = LoggerFactory.getLogger(Position.class);

    private final PositionDao positionDao;

    @Autowired
    public PositionServiceImpl(PositionDao dao) {
        this.positionDao = dao;
    }

    @Override
    public void add(Position position) {
        positionDao.save(position);
    }

    @Override
    public Position findById(Long id) {
        return positionDao.findOne(id);
    }

    @Override
    public Position findByName(String name) {
        return positionDao.findByName(name);
    }

    @Override
    public List<Position> positions() {


        return null;
    }

    @Override
    public void update(Position position) {
        positionDao.save(position);
    }

    @Override
    public void delete(Position position) {
        positionDao.delete(position.getId());
    }
}
