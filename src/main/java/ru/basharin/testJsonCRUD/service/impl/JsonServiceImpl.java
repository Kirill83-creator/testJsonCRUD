package ru.basharin.testJsonCRUD.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basharin.testJsonCRUD.dao.JsonDao;
import ru.basharin.testJsonCRUD.service.JsonService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JsonServiceImpl implements JsonService {

    @Autowired
    private JsonDao jsonDao;

    @Override
    public List<JSONObject> getAllJson() {
        return jsonDao.getAllJson();
    }

    @Override
    public JSONObject getJsonById(int id) {
        return jsonDao.getJsonById(id);
    }

    @Override
    public void putJson(JSONObject json) {
        jsonDao.putJson(json);
    }
}
