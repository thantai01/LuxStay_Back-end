package com.codegym.luxstay.controller;

import com.codegym.luxstay.model.ApartmentType;
import com.codegym.luxstay.service.impl.ApartmentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/apartmenttypes")
public class ApartmentTypeControllerAPI {
    @Autowired
    ApartmentTypeServiceImpl apartmentTypeService;

    @GetMapping("")
    public ResponseEntity<Iterable<ApartmentType>> getAll() {
        return new ResponseEntity<>(apartmentTypeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ApartmentType> save(@RequestBody ApartmentType apartmentType) {
        return new ResponseEntity<>(apartmentTypeService.save(apartmentType), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApartmentType> findById(@PathVariable Long id) {
        Optional<ApartmentType> apartmentTypeOptional = apartmentTypeService.findById(id);
        if(!apartmentTypeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(apartmentTypeOptional.get(),HttpStatus.OK);
    }
}
