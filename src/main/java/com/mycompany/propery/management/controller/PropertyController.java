package com.mycompany.propery.management.controller;

import com.mycompany.propery.management.model.Property;
import com.mycompany.propery.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<Property> saveProperty(@RequestBody Property property) {
        return new ResponseEntity<Property>(propertyService.saveProperty(property), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Property>> findAll() {
        return new ResponseEntity<List<Property>>(propertyService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable Long id) {
        return new ResponseEntity<Property>(propertyService.updateProperty(property, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Property> deleteProperty(@PathVariable Long id) {
        return new ResponseEntity<Property>(propertyService.deleteProperty(id), HttpStatus.OK);
    }
}
