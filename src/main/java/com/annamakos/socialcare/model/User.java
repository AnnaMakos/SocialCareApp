package com.annamakos.socialcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @ManyToMany
    private Set<Role> roles;

    public User(@NotBlank String username, @Email String email, @NotBlank @Size(min = 5) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
