package ru.basharin.testJsonCRUD.service;

import ru.basharin.testJsonCRUD.model.JsonObject;

import java.util.List;

public interface JsonService {
    List<JsonObject> getAllJson();
    JsonObject getJsonById(int id);
    void putJson(JsonObject json);
}
