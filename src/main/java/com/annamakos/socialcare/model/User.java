package com.annamakos.socialcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
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
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @ManyToMany
    private Set<Role> roles;

    @ManyToOne
    private Institution institution;                    // for official

    @OneToMany
    private List<Message> receivedMessages;

    @OneToMany
    private List<Message> sentMessages;

    @OneToMany
    private List<Application> receivedApplication;      // for official

    @OneToMany
    private List<Application> sentApplication;          // for applicant

    public User(@NotBlank String name, @NotBlank String surname, @NotBlank String username, @Email String email, @NotBlank @Size(min = 5) String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
