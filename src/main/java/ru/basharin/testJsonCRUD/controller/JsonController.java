package ru.basharin.testJsonCRUD.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.basharin.testJsonCRUD.service.JsonService;

import java.util.List;

@RestController
@RequestMapping("/")
public class JsonController {

    @Autowired
    private JsonService jsonService;

    @GetMapping
    public ResponseEntity<List<JSONObject>> getAllJson() {
        return ResponseEntity.ok(jsonService.getAllJson());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JSONObject> getJsonById(@PathVariable("id") int id) {
        return ResponseEntity.ok(jsonService.getJsonById(id));
    }

    @PostMapping(value = "/json")
    public ResponseEntity<Void> putJson(@RequestBody JSONObject json) {
        jsonService.putJson(json);
        return new ResponseEntity(HttpStatus.OK);
    }
}
