package com.codegym.luxstay.repository;

import com.codegym.luxstay.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderRepository extends JpaRepository<Order,Long> {
    @Modifying
    @Query(value = "select * from Order where user_id = :id", nativeQuery = true)
    Iterable<Order>findAllByUserId(@Param("id") Long id);
}
