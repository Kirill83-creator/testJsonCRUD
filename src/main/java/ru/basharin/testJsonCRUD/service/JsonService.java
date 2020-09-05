package ru.basharin.testJsonCRUD.service;

import org.json.JSONObject;

import java.util.List;

public interface JsonService {
    List<JSONObject> getAllJson();
    JSONObject getJsonById(int id);
    void putJson(JSONObject json);
}
