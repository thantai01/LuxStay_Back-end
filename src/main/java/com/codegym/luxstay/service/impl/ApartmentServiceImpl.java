package com.codegym.luxstay.service.impl;

import com.codegym.luxstay.model.Apartment;
import com.codegym.luxstay.repository.IApartmentRepository;
import com.codegym.luxstay.service.iservice.IApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentServiceImpl implements IApartment {
    @Autowired
    IApartmentRepository iApartmentRepository;
    @Override
    public Iterable<Apartment> findAll() {
        return iApartmentRepository.findAll();
    }

    @Override
    public Optional<Apartment> findById(long id) {
        return iApartmentRepository.findById(id);
    }

    @Override
    public Apartment save(Apartment apartment) {
        return iApartmentRepository.save(apartment);
    }

    @Override
    public void delete(long id) {
        iApartmentRepository.deleteById(id);
    }

    @Override
    public Iterable<Apartment> findAllByNameContaining(String name) {
        return iApartmentRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Apartment> findAllByStatusContaining(String status) {
        return iApartmentRepository.findAllByStatusContaining(status);
    }

    @Override
    public Iterable<Apartment> findAllByPriceContaining(String price) {
        return iApartmentRepository.findAllByPriceContaining(price);
    }

    @Override
    public Iterable<Apartment> findAllByApartmentTypeContaining(String type) {
        return iApartmentRepository.findAllByApartmentTypeContaining(type);
    }

    @Override
    public Iterable<Apartment> findAllByDescriptionContaining(String description) {
        return iApartmentRepository.findAllByDescriptionContaining(description);
    }

    @Override
    public Iterable<Apartment> findTop5() {
        return iApartmentRepository.findTop5();
    }

    @Override
    public Iterable<Apartment> findApartmentNotAvailable() {
        return iApartmentRepository.findApartmentNotAvailable();
    }




}