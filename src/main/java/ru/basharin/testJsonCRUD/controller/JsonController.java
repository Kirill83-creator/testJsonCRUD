package ru.basharin.testJsonCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basharin.testJsonCRUD.model.JsonObject;
import ru.basharin.testJsonCRUD.service.JsonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class JsonController {

    private final JsonService jsonService;

    public JsonController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping
    public ResponseEntity<List<JsonObject>> getAllJson() {
        if (jsonService.getAllJson().isEmpty()) {
            return  new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(jsonService.getAllJson());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<JsonObject>> getJsonById(@PathVariable("id") Integer id) {
        if (jsonService.getJsonById(id).isEmpty()) {
            return  new ResponseEntity(HttpStatus.NO_CONTENT);
        }
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
