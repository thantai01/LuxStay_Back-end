package com.codegym.luxstay.repository;

import com.codegym.luxstay.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepository extends JpaRepository<Order,Long> {
}
