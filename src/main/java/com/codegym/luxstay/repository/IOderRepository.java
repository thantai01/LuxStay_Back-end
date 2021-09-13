package com.codegym.luxstay.repository;

import com.codegym.luxstay.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IOderRepository extends JpaRepository<Order,Long> {
    @Query(value = "select * from orders where user_id =?1 ",nativeQuery = true)
    Iterable<Order> findAllByUserId(Long user_id);

    @Query(value = "select * from orders where apartment_id =?1",nativeQuery = true)
    Iterable<Order> findAllByApartmentId(Long apartment_id);


    @Query(value = "select * from orders join apartment on orders.apartment_id = apartment.id where apartment.user_id =?1",nativeQuery = true)
    Iterable<Order> findAllOrderOfUserHasApartment(long apartmentUserId);

    @Query(value = "select * from orders where apartment_id =?1 and order_status like 'Pending' order by id desc", nativeQuery = true)
    Iterable<Order> findAllOrderOfApartmentWithPending(long apartmentId);

}
