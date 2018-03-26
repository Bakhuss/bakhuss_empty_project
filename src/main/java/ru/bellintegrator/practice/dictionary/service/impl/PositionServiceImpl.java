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
    private PositionServiceImpl(PositionDao dao) {
        this.positionDao = dao;
    }

    @Override
    public void add(PositionView position) {
        Position tempPos = new Position();
        tempPos.setName(position.name);

        positionDao.save(tempPos);
    }

    @Override
    public PositionView findById(Long id) {
        Position pos = positionDao.findOne(id);
        PositionView posView = new PositionView();
        posView.id = pos.getId();
        posView.name = pos.getName();

        return posView;
    }

    @Override
    public List<PositionView> positions() {


        return null;
    }

    @Override
    public void update(PositionView position) {
        Position pos = positionDao.findOne(position.id);
        pos.setName(position.name);

        positionDao.save(pos);
    }

    @Override
    public void delete(PositionView position) {
        positionDao.delete(position.id);
    }
}
