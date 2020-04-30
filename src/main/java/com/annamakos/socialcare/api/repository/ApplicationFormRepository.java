package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {

    List<ApplicationForm> findAllByApplicantUsername(String username);

    Optional<ApplicationForm> findById(long id);

    List<ApplicationForm> findAllByOfficialUsername(String username);


}
