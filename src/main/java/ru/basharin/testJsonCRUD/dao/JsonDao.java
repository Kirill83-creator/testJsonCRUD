package ru.basharin.testJsonCRUD.dao;

import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;
import ru.basharin.testJsonCRUD.model.JsonObject;

import java.util.List;

public interface JsonDao extends CrudRepository<JsonObject, Integer> {

    List<JSONObject> getAllJson();

    JSONObject getJsonById(int id);

    void putJson(JSONObject json);

    List<JSONObject> convertToJson(List<String> strings);
}
