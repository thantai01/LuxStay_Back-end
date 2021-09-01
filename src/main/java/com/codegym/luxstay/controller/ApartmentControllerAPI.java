package com.codegym.luxstay.controller;

import com.codegym.luxstay.model.Apartment;
import com.codegym.luxstay.service.impl.ApartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/apartments")
public class ApartmentControllerAPI {
    @Autowired
    ApartmentServiceImpl apartmentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Apartment>> getAllApartment() {
        return new ResponseEntity<>(apartmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Apartment> saveApartment(@RequestBody Apartment apartment) {
        return new ResponseEntity<>(apartmentService.save(apartment), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Apartment> findById(@PathVariable Long id) {
        Optional<Apartment> apartmentOptional = apartmentService.findById(id);
        if(!apartmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(apartmentOptional.get(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Apartment> editById(@PathVariable Long id,@RequestBody Apartment apartment) {
        Optional<Apartment> apartmentOptional = apartmentService.findById(id);
        if(!apartmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        apartment.setId(apartmentOptional.get().getId());
        apartmentService.save(apartment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Apartment> deleteById(@PathVariable Long id) {
        Optional<Apartment>  apartmentOptional = apartmentService.findById(id);
        if(!apartmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        apartmentService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/top-5")
    public ResponseEntity<Iterable<Apartment>> findTop5(){
        return new ResponseEntity<>(apartmentService.findTop5(),HttpStatus.OK);
    }

    @GetMapping("/find-not-available")
    public ResponseEntity<Iterable<Apartment>> find(){
        return new ResponseEntity<>(apartmentService.findApartmentNotAvailable(),HttpStatus.OK);
    }
}
