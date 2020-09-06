package ru.basharin.testJsonCRUD.dao;

import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.basharin.testJsonCRUD.model.JsonObject;

import java.util.List;

@Repository
public interface JsonDao extends CrudRepository<JsonObject, Integer> {

    List<JsonObject> findAll();

    JsonObject findById(int id);
}
