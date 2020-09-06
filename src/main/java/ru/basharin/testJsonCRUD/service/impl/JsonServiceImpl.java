package ru.basharin.testJsonCRUD.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basharin.testJsonCRUD.dao.JsonDao;
import ru.basharin.testJsonCRUD.model.JsonObject;
import ru.basharin.testJsonCRUD.service.JsonService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class JsonServiceImpl implements JsonService {

    @Autowired
    private JsonDao jsonDao;

    @Transactional
    @Override
    public List<JsonObject> getAllJson() {
        return (List<JsonObject>) jsonDao.findAll();
    }

    @Transactional
    @Override
    public Optional<JsonObject> getJsonById(Integer id) {
        return jsonDao.findById(id);
    }

    @Transactional
    @Override
    public void putJson(JsonObject json) {
        jsonDao.save(json);
    }
}
