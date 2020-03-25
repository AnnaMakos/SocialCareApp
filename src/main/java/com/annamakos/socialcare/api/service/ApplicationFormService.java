package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.ApplicationFormDTO;
import com.annamakos.socialcare.api.dto.VisitDTO;
import com.annamakos.socialcare.api.model.ApplicationForm;
import com.annamakos.socialcare.api.model.Visit;
import com.annamakos.socialcare.api.repository.ApplicationFormRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ApplicationFormService {

    private ApplicationFormRepository applicationFormRepository;

    public ApplicationFormService(ApplicationFormRepository applicationFormRepository) {
        this.applicationFormRepository = applicationFormRepository;
    }

    public List<ApplicationFormDTO> findByApplicantUsername(String name) {
        List<ApplicationForm> forms = applicationFormRepository.findAllByApplicantUsername(name);
        List<ApplicationFormDTO> formsDTO = new ArrayList<>();
        forms.forEach(form -> {
            formsDTO.add((new ApplicationFormDTO(form)));
        });
        return formsDTO;
    }

}
