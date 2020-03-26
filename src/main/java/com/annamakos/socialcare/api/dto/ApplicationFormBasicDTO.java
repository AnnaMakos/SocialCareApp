package com.annamakos.socialcare.api.dto;


import com.annamakos.socialcare.api.model.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFormBasicDTO {

    ApplicationStatus applicationStatus;
    String maritalStatus;
    String citizenship;
    String phone;
    String comments;
    String username;

}
