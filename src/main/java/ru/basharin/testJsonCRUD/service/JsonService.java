package ru.basharin.testJsonCRUD.service;

import ru.basharin.testJsonCRUD.model.JsonObject;

import java.util.List;
import java.util.Optional;

public interface JsonService {
    List<JsonObject> getAllJson();
    Optional<JsonObject> getJsonById(Integer id);
    void putJson(JsonObject json);
    boolean validationJsonObj(String inputString);
    boolean validationJsonObjoInt(String inputString);
}
