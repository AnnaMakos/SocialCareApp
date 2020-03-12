package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "application_form")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @NotBlank
    private String condition;

    @NotBlank
    private String citizenship;

    @NotBlank
    private String phone;

    @Column
    private String comments;

    @ManyToOne
    private User user;

    @ManyToOne
    private User official;

}
