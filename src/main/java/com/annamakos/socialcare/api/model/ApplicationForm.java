package com.annamakos.socialcare.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

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
    private ApplicationStatus applicationStatus;

    @NotBlank
    private String maritalStatus;

    @NotBlank
    private String citizenship;

    @NotBlank
    private String phone;

    @Column
    private String comments;

    @OneToMany(mappedBy = "appForm")
    private List<ChildForm> children;

    @ManyToOne
    private User applicant;

    @ManyToOne
    private User official;

    public ApplicationForm(
            ApplicationStatus applicationStatus,
            String maritalStatus,
            String citizenship,
            String phone,
            String comments,
            User applicant
    ) {
        this.applicationStatus = applicationStatus;
        this.maritalStatus = maritalStatus;
        this.citizenship = citizenship;
        this.phone = phone;
        this.comments = comments;
        this.applicant = applicant;
    }
}
