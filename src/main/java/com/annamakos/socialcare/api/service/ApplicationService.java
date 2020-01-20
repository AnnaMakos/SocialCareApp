package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.ApplicationAddDTO;
import com.annamakos.socialcare.api.dto.ApplicationDTO;
import com.annamakos.socialcare.api.model.Application;
import com.annamakos.socialcare.api.repository.ApplicationRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Data
public class ApplicationService {
    private ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    public ApplicationDTO addApplication(ApplicationAddDTO applicationAddDTO){

        Application application = new Application(applicationAddDTO.getName(), applicationAddDTO.getPath());
        applicationRepository.save(application);
        ApplicationDTO applicationDTO = new ApplicationDTO(application);

        return applicationDTO;
    }

    public List<ApplicationDTO> findAllApplications(){
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationDTO> applicationDTOs = new ArrayList<>();

        applications.forEach(application -> {
            applicationDTOs.add(new ApplicationDTO(application));
        });

        return applicationDTOs;
    }

    public Application findApplicationById(long id) {
        Application application = applicationRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Wniosek nie znaleziony")
        );

        return application;
    }

    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }
}
