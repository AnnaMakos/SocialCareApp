package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.ApplicationFormDTO;
import com.annamakos.socialcare.api.dto.ChildFormBasicDTO;
import com.annamakos.socialcare.api.dto.ChildFormDTO;
import com.annamakos.socialcare.api.dto.UserDTO;
import com.annamakos.socialcare.api.model.ApplicationForm;
import com.annamakos.socialcare.api.model.ChildForm;
import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.repository.ChildFormRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ChildFormService {
    ChildFormRepository childFormRepository;
    ApplicationFormService applicationFormService;

    public ChildFormService(ChildFormRepository childFormRepository, ApplicationFormService applicationFormService) {
        this.childFormRepository = childFormRepository;
        this.applicationFormService = applicationFormService;
    }

    public List<ChildForm> findByApplicationFormId(long id) {
        List<ChildForm> children = childFormRepository.findAllByAppFormId(id);
        return children;
    }

    public ChildFormDTO addChildForm(ChildFormBasicDTO childFormBasicDTO, int appFormId) {

        ApplicationForm appForm = applicationFormService.findById(appFormId);
        ChildForm childForm = new ChildForm(
                childFormBasicDTO.getName(),
                childFormBasicDTO.getSurname(),
                childFormBasicDTO.getPesel(),
                childFormBasicDTO.getCitizenship(),
                appForm
        );
        childFormRepository.save(childForm);

        return new ChildFormDTO(childForm);
    }

}
