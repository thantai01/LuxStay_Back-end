package com.codegym.luxstay.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter @Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Lob
    private String imageUrl;


    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Image() {
    }
}
