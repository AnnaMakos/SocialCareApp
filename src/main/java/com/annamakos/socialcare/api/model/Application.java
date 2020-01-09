package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "application")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private Date postDate;

    @Column
    private Date considerDate;

    @ManyToOne
    private User applicant;

    @ManyToOne
    private User official;

    public Application(String name, @NotBlank Date postDate, Date considerDate) {
        this.name = name;
        this.postDate = postDate;
        this.considerDate = considerDate;
    }
}
