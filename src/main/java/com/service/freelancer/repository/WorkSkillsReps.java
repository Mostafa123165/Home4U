package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.WorkSkills;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSkillsReps extends BaseLkpRepository<WorkSkills, Integer> {
}
