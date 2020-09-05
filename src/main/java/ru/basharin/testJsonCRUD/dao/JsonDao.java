package ru.basharin.testJsonCRUD.dao;

import org.json.JSONObject;

import java.util.List;

public interface JsonDao {
    List<JSONObject> getAllJson();
    JSONObject getJsonById(int id);
    void putJson(JSONObject json);
    List<JSONObject> convertToJson(List<String> strings);
}
