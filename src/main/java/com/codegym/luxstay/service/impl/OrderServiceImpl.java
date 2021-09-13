package com.codegym.luxstay.service.impl;

import com.codegym.luxstay.model.Order;
import com.codegym.luxstay.repository.IOderRepository;
import com.codegym.luxstay.service.iservice.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrder {
    @Autowired
    private IOderRepository oderRepository;

    @Override
    public Iterable<Order> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return oderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return oderRepository.save(order);
    }

    @Override
    public void delete(long id) {
        oderRepository.deleteById(id);
    }

    @Override
    public Iterable<Order> findAllByUserId(Long id) {
        return oderRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Order> findAllByApartment(Long apartmentID) {
        return oderRepository.findAllByApartment(apartmentID);
    }
}
