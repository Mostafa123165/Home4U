package com.service.freelancer.service;

import com.service.freelancer.model.AskWorkerPhotos;
import com.service.freelancer.repository.AskWorkerPhotosReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AskWorkerPhotosService {

    private final AskWorkerPhotosReps askWorkerPhotosReps;

    public List<AskWorkerPhotos> saveAll(List<AskWorkerPhotos> askWorkerPhotos) {
        return askWorkerPhotosReps.saveAll(askWorkerPhotos);
    }

}
