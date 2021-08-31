package com.codegym.luxstay.service.iservice;

import com.codegym.luxstay.model.Apartment;
import com.codegym.luxstay.service.IGeneralService;

public interface IApartment extends IGeneralService<Apartment> {
    Iterable<Apartment> findAllByNameContaining(String name);
    Iterable<Apartment> findAllByStatusContaining(String status);
    Iterable<Apartment> findAllByPriceContaining(String price);
    Iterable<Apartment> findAllByApartmentTypeContaining(String type);
    Iterable<Apartment> findAllByDescriptionContaining(String description);
}
