package com.codegym.luxstay.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class ApartmentDayInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dayInOrder;
    @ManyToOne
    private Apartment apartment;

    public ApartmentDayInOrder(LocalDate dayInOrder, Apartment apartment) {
        this.dayInOrder = dayInOrder;
        this.apartment = apartment;
    }

    public ApartmentDayInOrder() {
    }
}
