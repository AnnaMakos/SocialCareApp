package com.annamakos.socialcare.api.dto;

import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.model.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private long id;
    private Date visitDate;
    private boolean taken;
    private UserDTO user;
    private UserDTO official;

    public VisitDTO(Visit visit){
        this.id = visit.getId();
        this.visitDate = visit.getVisitDate();
        this.taken = visit.isTaken();
        this.official = new UserDTO(visit.getOfficial());
        if(visit.getUser() != null) {
            this.user = new UserDTO(visit.getUser());
        } else {
            this.user = null;
        }
    }
}
