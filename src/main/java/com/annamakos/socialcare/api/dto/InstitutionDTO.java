package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.Institution;
import com.annamakos.socialcare.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionDTO {

    private int id;
    private String name;
    private String address;
    private float geoX;
    private float geoY;

    public InstitutionDTO(Institution institution){
        this.id = institution.getId();
        this.name = institution.getName();
        this.address = institution.getAddress();
        this.geoX = institution.getGeoX();
        this.geoY = institution.getGeoY();
    }
}
