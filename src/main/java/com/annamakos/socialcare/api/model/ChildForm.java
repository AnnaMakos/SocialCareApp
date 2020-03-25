package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="child_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String PESEL;

    @Column
    private String citizenship;

    @ManyToOne
    private ApplicationForm appForm;

}
