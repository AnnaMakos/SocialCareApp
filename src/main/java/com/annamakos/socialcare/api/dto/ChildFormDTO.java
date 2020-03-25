package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.ApplicationForm;
import com.annamakos.socialcare.api.model.ChildForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildFormDTO {

    private int id;
    private String name;
    private String surname;
    private String PESEL;
    private String citizenship;
    private ApplicationForm applicationForm;

    public ChildFormDTO(ChildForm child) {
        this.id = child.getId();
        this.name = child.getName();
        this.surname = child.getSurname();
        this.PESEL = child.getPESEL();
        this.citizenship = child.getCitizenship();
        if (child.getAppForm() != null) {
            this.applicationForm = child.getAppForm();
        } else {
            this.applicationForm = null;
        }

    }
}
