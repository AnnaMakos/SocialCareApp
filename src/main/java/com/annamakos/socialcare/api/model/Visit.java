package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "visit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private Date visitDate;

    @NotBlank
    private boolean taken;

    @ManyToOne
    private User user;

    @ManyToOne
    private User official;

    public Visit(Date visitDate, boolean taken) {
        this.visitDate = visitDate;
        this.taken = taken;
    }
}
