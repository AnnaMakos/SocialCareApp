package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "institution")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private float geoX;

    @NotBlank
    private float geoY;

    @OneToMany
    private Set<User> users;

    public Institution(@NotBlank String name, @NotBlank String address, @NotBlank float geoX, @NotBlank float geoY) {
        this.name = name;
        this.address = address;
        this.geoX = geoX;
        this.geoY = geoY;
    }
}
