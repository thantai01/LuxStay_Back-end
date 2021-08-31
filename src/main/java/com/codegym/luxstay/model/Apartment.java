package com.codegym.luxstay.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Size(min = 6,max = 48)
    private String name;
    @ManyToOne
    private ApartmentType apartmentType;
    @NotBlank
    @Min(value = 1)
    @Max(value = 10)
    private long bethRoom;
    @NotBlank
    @Min(value = 1) @Max(value = 3)
    private long bathRoom;
    @NotBlank
    @Size(min = 1)
    private String description;
    @NotBlank
    private long price;
    @NotBlank
    private String status;
    @OneToMany
    private List<Image> imageList;

    public Apartment() {
    }

    public Apartment(String name, ApartmentType apartmentType, long bethRoom, long bathRoom, String description, long price,String status) {
        this.name = name;
        this.apartmentType = apartmentType;
        this.bethRoom = bethRoom;
        this.bathRoom = bathRoom;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public Apartment(String name, ApartmentType apartmentType, long bethRoom, long bathRoom, String description, long price,String status ,List<Image> imageList) {
        this.name = name;
        this.apartmentType = apartmentType;
        this.bethRoom = bethRoom;
        this.bathRoom = bathRoom;
        this.description = description;
        this.price = price;
        this.status = status;
        this.imageList = imageList;
    }
}
