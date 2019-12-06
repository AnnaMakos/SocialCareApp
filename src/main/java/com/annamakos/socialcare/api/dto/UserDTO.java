package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String pesel;
    private String street;
    private String streetNumber;
    private String localNumber;
    private String postcode;
    private String city;
    private Set<String> roles;
    private InstitutionDTO institution;

    public UserDTO(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.pesel = user.getPesel();
        this.street = user.getStreet();
        this.streetNumber = user.getStreetNumber();
        this.localNumber = user.getLocalNumber();
        this.postcode = user.getPostcode();
        this.city = user.getCity();
        Set<String> roles = new HashSet<>();
        user.getRoles().forEach(role -> {
            roles.add(role.getName().name());
        });
        this.roles = roles;
        if (user.getInstitution() != null) {
            this.institution = new InstitutionDTO(user.getInstitution());
        } else {
            this.institution = null;
        }
    }


}
