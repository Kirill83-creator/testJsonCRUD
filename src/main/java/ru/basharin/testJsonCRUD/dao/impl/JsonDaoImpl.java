package ru.basharin.testJsonCRUD.dao.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import ru.basharin.testJsonCRUD.dao.JsonDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JsonDaoImpl implements JsonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<JSONObject> getAllJson() {
        TypedQuery<String> query = (TypedQuery<String>) entityManager.createNativeQuery("select json_obj from `json_table`");
        List<String> res = query.getResultList();
        return convertToJson(res);
    }

    @Override
    public JSONObject getJsonById(int id) {
        TypedQuery<String> query = (TypedQuery<String>) entityManager.createNativeQuery("select * from `json_table` where 'id' = id");
        String res = query.getSingleResult();
        return new JSONObject(res);
    }

    @Override
    public void putJson(JSONObject json) {
        entityManager.persist(json);
    }

    @Override
    public List<JSONObject> convertToJson(List<String> strings) {
        List<JSONObject> tempJsonObjects = new ArrayList<>();
        for (String res :
                strings) {
            JSONObject convertObj = new JSONObject(res);
            tempJsonObjects.add(convertObj);
        }
        return tempJsonObjects;
    }
}
