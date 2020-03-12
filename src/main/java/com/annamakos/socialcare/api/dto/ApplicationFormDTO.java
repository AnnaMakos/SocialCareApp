package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.ApplicationForm;
import com.annamakos.socialcare.api.model.ApplicationStatus;
import com.annamakos.socialcare.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFormDTO {

    private long id;
    private ApplicationStatus status;
    private String condition;
    private String citizenship;
    private String phone;
    private String comments;
    private UserDTO user;
    private UserDTO official;

    public ApplicationFormDTO(ApplicationForm app) {
        this.id = app.getId();
        this.status = app.getStatus();
        this.condition = app.getCondition();
        this.citizenship = app.getCitizenship();
        this.phone = app.getPhone();
        if(app.getComments() != null){
            this.comments = comments;
        } else {
            this.comments = null;
        }
        this.user = new UserDTO(app.getUser());
        if(app.getOfficial() != null){
            this.official = new UserDTO(app.getUser());
        } else {
            this.official = null;
        }
    }
}
