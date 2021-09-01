package com.codegym.luxstay.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter @Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob

    private String imageUrl;


    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Image() {
    }
}
