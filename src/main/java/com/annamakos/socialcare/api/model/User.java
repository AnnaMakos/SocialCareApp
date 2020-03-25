package com.annamakos.socialcare.api.model;

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
    private String pesel;

    @NotBlank
    private String street;

    @NotBlank
    private String streetNumber;

    @Column
    private String localNumber;

    @NotBlank
    private String postcode;

    @NotBlank
    private String city;

    @NotBlank
    @Size(min = 5)
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Role> roles;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Institution institution;                    // for official

    @OneToMany(mappedBy = "receiver")
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "official")
    private List<Visit> visitOfficial;      // for official

    @OneToMany(mappedBy = "user")
    private List<Visit> visitApplicant;          // for applicant

    @OneToMany(mappedBy = "official")
    private List<ApplicationForm> applicationFormOfficial;      // for official

    @OneToMany(mappedBy = "applicant")
    private List<ApplicationForm> applicationFormUser;          // for applicant


    public User(@NotBlank String name, @NotBlank String surname, @NotBlank String username, @Email String email, @NotBlank String pesel, @NotBlank String street, @NotBlank String streetNumber, String localNumber, @NotBlank String postcode, @NotBlank String city, @NotBlank @Size(min = 5) String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.pesel = pesel;
        this.street = street;
        this.streetNumber = streetNumber;
        this.localNumber = localNumber;
        this.postcode = postcode;
        this.city = city;
        this.password = password;
    }
}
