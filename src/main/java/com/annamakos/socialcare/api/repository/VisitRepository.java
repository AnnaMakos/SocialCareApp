package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

}
