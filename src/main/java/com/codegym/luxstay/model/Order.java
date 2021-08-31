package com.codegym.luxstay.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private LocalDate startDate;
    @NotBlank
    private LocalDate endDate;
    @NotBlank
    private String userFullName;
    @NotBlank
    private String userPhoneNums;
    private String orderStatus;
    @NotBlank
    private long totalPaid;

    private double rating;

    private String comment;
    private boolean checkIn;

    public Order(LocalDate startDate, LocalDate endDate, String userFullName, String userPhoneNums, String orderStatus, long totalPaid, double rating, String comment) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.userFullName = userFullName;
        this.userPhoneNums = userPhoneNums;
        this.orderStatus = orderStatus;
        this.totalPaid = totalPaid;
        this.rating = rating;
        this.comment = comment;
        this.checkIn = false;
    }

    public Order() {
    }
}
