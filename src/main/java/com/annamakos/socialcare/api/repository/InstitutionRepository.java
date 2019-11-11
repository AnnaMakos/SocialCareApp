package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {


}
