package com.mycompany.propery.management.controller;

import com.mycompany.propery.management.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public Double add(
            @RequestParam Double a,
            @RequestParam Double b) {
        return a+b;
    }

    @GetMapping("/sub/{a}/{b}")
    public Double sub(@PathVariable Double a, @PathVariable Double b) {
        return a-b;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody Calculator calculator) {
        Double result = calculator.getNum1()*calculator.getNum2()*calculator.getNum3();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
