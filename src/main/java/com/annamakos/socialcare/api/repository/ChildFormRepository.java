package com.annamakos.socialcare.api.repository;

import com.annamakos.socialcare.api.model.ChildForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildFormRepository extends JpaRepository<ChildForm, Integer> {


    List<ChildForm> findAllByAppFormId(long id);
}
