package ru.basharin.testJsonCRUD.dao.impl;

import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.basharin.testJsonCRUD.dao.JsonDao;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JsonDaoImpl implements JsonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public JsonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<JSONObject> getAllJson() {
        TypedQuery<String> query = sessionFactory.getCurrentSession().createNativeQuery("select * from json_table");
        List<String> res = query.getResultList();
        return convertToJson(res);
    }

    @Override
    public JSONObject getJsonById(int id) {
        TypedQuery<String> query = sessionFactory.getCurrentSession().createNativeQuery("select * from json_table where 'id' = id");
        String res = query.getSingleResult();
        return new JSONObject(res);
    }

    @Override
    public void putJson(JSONObject json) {
        TypedQuery<String> query = (TypedQuery<String>) sessionFactory.getCurrentSession().save(json);
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
