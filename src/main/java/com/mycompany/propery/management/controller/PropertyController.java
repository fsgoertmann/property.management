package com.mycompany.propery.management.controller;

import com.mycompany.propery.management.model.Property;
import com.mycompany.propery.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping("/properties")
    public ResponseEntity<Property> saveProperty(@RequestBody Property property) {
        return new ResponseEntity<Property>(propertyService.saveProperty(property), HttpStatus.CREATED);
    }
}
