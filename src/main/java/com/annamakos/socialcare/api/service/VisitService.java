package com.annamakos.socialcare.api.service;

import com.annamakos.socialcare.api.dto.VisitDTO;
import com.annamakos.socialcare.api.model.Visit;
import com.annamakos.socialcare.api.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService {
    VisitRepository visitRepository;

    public List<VisitDTO> findAllVisits() {
        List<Visit> visits = visitRepository.findAll();
        List<VisitDTO> visitsDTO = new ArrayList<>();
        visits.forEach(visit -> {
            visitsDTO.add(new VisitDTO(visit));
        });
        return visitsDTO;

    }
}
