package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

    private long id;
    private String name;
    private String path;

    public ApplicationDTO(Application application){
        this.id = application.getId();
        this.name = application.getName();
        this.path = application.getPath();
    }

}
