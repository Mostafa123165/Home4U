package com.service.freelancer.repository;

import com.service.freelancer.model.AskWorkerPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskWorkerPhotosReps extends JpaRepository<AskWorkerPhotos, Long> {
}
