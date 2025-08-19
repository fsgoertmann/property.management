package com.mycompany.propery.management.controller;

import com.mycompany.propery.management.model.Property;
import com.mycompany.propery.management.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<Property> saveProperty(@RequestBody Property property) {
        return new ResponseEntity<>(propertyService.saveProperty(property), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Property>> findAll() {
        return new ResponseEntity<>(propertyService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable Long id) {
        return new ResponseEntity<>(propertyService.updateProperty(property, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Property> deleteProperty(@PathVariable Long id) {
        return new ResponseEntity<>(propertyService.deleteProperty(id), HttpStatus.OK);
    }
}
