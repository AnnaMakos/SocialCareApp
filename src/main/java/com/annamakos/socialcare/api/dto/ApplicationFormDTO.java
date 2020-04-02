package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.ApplicationForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFormDTO {

    private long id;
    private String applicationStatus;
    private String maritalStatus;
    private String citizenship;
    private String phone;
    private String comments;
    private UserDTO user;
    private UserDTO official;
    private List<ChildFormDTO> children;

    public ApplicationFormDTO(ApplicationForm app) {
        this.id = app.getId();
        this.applicationStatus = app.getApplicationStatus();
        this.maritalStatus = app.getMaritalStatus();
        this.citizenship = app.getCitizenship();
        this.phone = app.getPhone();
        if (app.getComments() != null) {
            this.comments = app.getComments();
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
            System.out.println("tyle mam dzieci: " + size);
            List<ChildFormDTO> childrenDTO = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                childrenDTO.add(new ChildFormDTO(app.getChildren().get(i)));
            }
            this.children = childrenDTO;

//            }
        } else {
            this.children = null;
            System.out.println("jestem w elsie loliiiiik");
        }

    }
}
