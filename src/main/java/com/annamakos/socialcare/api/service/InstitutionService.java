package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.InstitutionDTO;
import com.annamakos.socialcare.api.model.Institution;
import com.annamakos.socialcare.api.repository.InstitutionRepository;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InstitutionService {
    InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Institution findInstitutionById(int id) {
        Institution institution = institutionRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Institution not found")
        );
        return institution;
    }

    public List<InstitutionDTO> findAllInstitutions() {
        List<Institution> institutions = institutionRepository.findAll();
        List<InstitutionDTO> institutionsDTO = new ArrayList<>();
        institutions.forEach(institution -> {
            institutionsDTO.add(new InstitutionDTO(institution));
        });
        return institutionsDTO;
    }


}
