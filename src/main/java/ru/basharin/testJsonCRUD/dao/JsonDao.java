package ru.basharin.testJsonCRUD.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import ru.basharin.testJsonCRUD.model.JsonObject;

import java.util.List;

@Repository
public interface JsonDao extends CrudRepository<JsonObject, Integer>, QueryByExampleExecutor<JsonObject> {

    List<JsonObject> findAll();

    JsonObject findById(int id);
}
