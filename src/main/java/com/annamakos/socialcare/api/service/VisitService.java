package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.UserDTO;
import com.annamakos.socialcare.api.dto.VisitDTO;
import com.annamakos.socialcare.api.model.User;
import com.annamakos.socialcare.api.model.Visit;
import com.annamakos.socialcare.api.repository.VisitRepository;
import com.annamakos.socialcare.security.service.MailService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService {
    private VisitRepository visitRepository;
    private UserService userService;
    private MailService mailService;

    public VisitService(VisitRepository visitRepository, UserService userService, MailService mailService){
        this.visitRepository = visitRepository;
        this.userService = userService;
        this.mailService = mailService;
    }

    public List<VisitDTO> findAllVisits() {
        List<Visit> visits = visitRepository.findAll();
        List<VisitDTO> visitsDTO = new ArrayList<>();
        visits.forEach(visit -> {
            visitsDTO.add(new VisitDTO(visit));
        });
        return visitsDTO;
    }

    public VisitDTO findById(long id){
        Visit visit = visitRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        VisitDTO visitDTO = new VisitDTO(visit);
        return visitDTO;
    }

    public VisitDTO alterVisitToTaken(String username, long visitId){
        User user = userService.findByUsername2(username);
        Visit visit = visitRepository.findById(visitId).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        visit.setTaken(true);
        visit.setUser(user);
        visitRepository.save(visit);
        VisitDTO visitDTO = new VisitDTO(visit);

        mailService.sendVisitConfirmation(visitDTO);

        return visitDTO;
    }


}
