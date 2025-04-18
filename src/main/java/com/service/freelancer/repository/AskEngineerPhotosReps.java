package com.service.freelancer.repository;

import com.service.freelancer.model.AskEngineerPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskEngineerPhotosReps extends JpaRepository<AskEngineerPhotos, Long> {
}
