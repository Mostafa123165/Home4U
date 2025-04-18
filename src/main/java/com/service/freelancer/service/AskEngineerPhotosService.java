package com.service.freelancer.service;

import com.service.freelancer.model.AskEngineerPhotos;
import com.service.freelancer.repository.AskEngineerPhotosReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AskEngineerPhotosService {
    private final AskEngineerPhotosReps askEngineerPhotosReps;

    public List<AskEngineerPhotos> saveAll(List<AskEngineerPhotos> askEngineerPhotos) {
        return askEngineerPhotosReps.saveAll(askEngineerPhotos);
    }
}
