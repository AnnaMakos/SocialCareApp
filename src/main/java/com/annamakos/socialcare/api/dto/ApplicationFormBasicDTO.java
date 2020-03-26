package com.annamakos.socialcare.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFormBasicDTO {

    String applicationStatus;
    String maritalStatus;
    String citizenship;
    String phone;
    String comments;
    String username;

}
