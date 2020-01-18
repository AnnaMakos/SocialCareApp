package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Optional<Visit> findById(long id);

    List<Visit> findAllByUserUsername(String username);
}
