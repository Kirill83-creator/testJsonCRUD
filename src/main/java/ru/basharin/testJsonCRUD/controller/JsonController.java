package ru.basharin.testJsonCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basharin.testJsonCRUD.model.JsonObject;
import ru.basharin.testJsonCRUD.service.JsonService;

import java.util.List;

@RestController
@RequestMapping("/")
public class JsonController {

    @Autowired
    private JsonService jsonService;

    @GetMapping
    public ResponseEntity<List<JsonObject>> getAllJson() {
        return ResponseEntity.ok(jsonService.getAllJson());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JsonObject> getJsonById(@PathVariable("id") int id) {
        return ResponseEntity.ok(jsonService.getJsonById(id));
    }

    @PostMapping(value = "/json")
    public ResponseEntity<Void> putJson(@RequestBody String json) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.setJsonObject(json);
        jsonService.putJson(jsonObject);
        return new ResponseEntity(HttpStatus.OK);
    }
}
