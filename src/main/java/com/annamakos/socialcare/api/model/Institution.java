package com.annamakos.socialcare.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "institution")
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

    @OneToMany(mappedBy = "institution")
    private Set<User> users;

    public Institution(@NotBlank String name, @NotBlank String address, @NotBlank float geoX, @NotBlank float geoY, Set<User> users) {
        this.name = name;
        this.address = address;
        this.geoX = geoX;
        this.geoY = geoY;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGeoX() {
        return geoX;
    }

    public void setGeoX(float geoX) {
        this.geoX = geoX;
    }

    public float getGeoY() {
        return geoY;
    }

    public void setGeoY(float geoY) {
        this.geoY = geoY;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Institution() {
    }
}
