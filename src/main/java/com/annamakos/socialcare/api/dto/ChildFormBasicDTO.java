package com.annamakos.socialcare.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildFormBasicDTO {

    private String name;
    private String surname;
    private String pesel;
    private String citizenship;
}
