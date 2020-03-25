package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {

    public List<ApplicationForm> findAllByApplicantUsername(String username);
}
