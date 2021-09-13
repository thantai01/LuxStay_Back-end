package com.codegym.luxstay.service.iservice;

import com.codegym.luxstay.model.Order;
import com.codegym.luxstay.service.IGeneralService;

public interface IOrder extends IGeneralService<Order> {
    Iterable<Order>findAllByUserId(Long id);
    Iterable<Order> findAllByApartment(Long apartmentID);
}
