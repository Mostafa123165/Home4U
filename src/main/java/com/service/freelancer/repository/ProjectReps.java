package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.Project;
import com.service.userManagement.model.User;
import lombok.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectReps extends BaseRepository<Project, Long> {


    @Query("""
        select p from Project p where p.user.id = :userId
        """)
    List<Project> findProjectsByUser(Long userId);


}
