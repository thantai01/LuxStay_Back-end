package com.codegym.luxstay.repository;

import com.codegym.luxstay.model.ApartmentDayInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApartmentDayInOrderRepository extends JpaRepository<ApartmentDayInOrder, Long> {
}
