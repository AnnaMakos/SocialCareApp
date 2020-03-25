package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.ApplicationForm;
import com.annamakos.socialcare.api.model.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<ChildFormDTO> children;

    public ApplicationFormDTO(ApplicationForm app) {
        this.id = app.getId();
        this.status = app.getApplicationStatus();
        this.condition = app.getMaritalStatus();
        this.citizenship = app.getCitizenship();
        this.phone = app.getPhone();
        if (app.getComments() != null) {
            this.comments = comments;
        } else {
            this.comments = null;
        }
        this.user = new UserDTO(app.getApplicant());
        if (app.getOfficial() != null) {
            this.official = new UserDTO(app.getApplicant());
        } else {
            this.official = null;
        }
        if (app.getChildren() != null) {
            int size = app.getChildren().size();
            for (int i = 0; i < size; i++) {
                children.add(new ChildFormDTO(app.getChildren().get(i)));
            }
        }
    }
}
