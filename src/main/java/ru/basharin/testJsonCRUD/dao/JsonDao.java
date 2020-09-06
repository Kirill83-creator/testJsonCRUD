package ru.basharin.testJsonCRUD.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.basharin.testJsonCRUD.model.JsonObject;

@Repository
public interface JsonDao extends CrudRepository<JsonObject, Integer>{
}
