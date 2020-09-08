package ru.basharin.testJsonCRUD.service.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basharin.testJsonCRUD.dao.JsonDao;
import ru.basharin.testJsonCRUD.model.JsonObject;
import ru.basharin.testJsonCRUD.service.JsonService;
import org.json.JSONObject;

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

    @Override
    public boolean validationJsonObj(String inputString) {
        try {
            new JSONObject(inputString);
        } catch (JSONException ex) {
            try {
                new JSONArray(inputString);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validationJsonObjoInt(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
