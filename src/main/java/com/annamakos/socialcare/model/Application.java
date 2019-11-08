package com.annamakos.socialcare.model;

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

    @Enumerated(EnumType.STRING)
    private ApplicationName name;

    @NotBlank
    private Date postDate;

    @Column
    private Date considerDate;

    @ManyToOne
    private User applicant;

    @ManyToOne
    private User official;

    public Application(ApplicationName name, @NotBlank Date postDate, Date considerDate) {
        this.name = name;
        this.postDate = postDate;
        this.considerDate = considerDate;
    }
}
