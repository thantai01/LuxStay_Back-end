package com.codegym.luxstay.service.iservice;

import com.codegym.luxstay.model.Apartment;
import com.codegym.luxstay.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IApartment extends IGeneralService<Apartment> {
    Iterable<Apartment> findAllByNameContaining(String name);
    Iterable<Apartment> findAllByStatusContaining(String status);
    Iterable<Apartment> findAllByPriceContaining(String price);
    Iterable<Apartment> findAllByApartmentTypeContaining(String type);
    Iterable<Apartment> findAllByDescriptionContaining(String description);
    Iterable<Apartment> findTop5();
    Iterable<Apartment> findApartmentNotAvailable();
    Iterable<Apartment> findApartmentAvailable();
    Iterable<Apartment> searchMany1(String name, Date startDate);
    Iterable<Apartment> searchManyDate(@Param("startDate") Date startDate);
    Iterable<Apartment> searchByString(@Param("name") String name);
}
