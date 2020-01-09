package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicDTO {

    private String username;
    private String name;
    private String surname;
    private String email;
    private InstitutionDTO institution;

    public UserBasicDTO(User user){
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        if (user.getInstitution() != null) {
            this.institution = new InstitutionDTO(user.getInstitution());
        } else {
            this.institution = null;
        }
    }

}
