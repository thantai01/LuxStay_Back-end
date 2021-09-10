package com.codegym.luxstay.controller;

import com.codegym.luxstay.model.Order;
import com.codegym.luxstay.service.iservice.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/orders")
@CrossOrigin("*")

public class OrderControllerAPI {

    @Autowired
    private IOrder orderService;

    @GetMapping("")
    public ResponseEntity<Iterable<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Order> create (@RequestBody Order order){
        orderService.save(order);
        return new ResponseEntity<>(orderService.save(order),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id,@RequestBody Order order) {
        Optional<Order> optionalOrder = orderService.findById(id);
        if(!optionalOrder.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.setId(optionalOrder.get().getId());
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable Long id){
        Optional<Order> optionalOrder = orderService.findById(id);
        if(!optionalOrder.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
