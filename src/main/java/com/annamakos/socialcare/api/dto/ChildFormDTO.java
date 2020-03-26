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
    private String pesel;
    private String citizenship;

    public ChildFormDTO(ChildForm child) {
        this.id = child.getId();
        this.name = child.getName();
        this.surname = child.getSurname();
        this.pesel = child.getPesel();
        this.citizenship = child.getCitizenship();

    }
}
