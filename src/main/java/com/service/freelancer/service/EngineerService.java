package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.repository.EngineerReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EngineerService extends BaseServiceImpl<Engineer, Long> {

    private final UserService userService;

    private final EngineerReps engineerReps;

    public Engineer findByUserId(Long userId) {
        if (userId == null) userId = userService.getCurrentUser().getId();
        return engineerReps.findByUserId(userId);
    }

    public Page<Engineer> filterTop(Optional<SearchRequest> request) {
        SearchRequest req = request.orElse(new SearchRequest());

        Number governorateId = null;
        Number cityId = null;
        Number engineerTypeId = null;
        Number engineerServId = null;
        Integer yearsOfExperience = null;
        Integer rate = null;

        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            governorateId = (Integer) req.getSearchCriteria().getOrDefault("governorateId", null);
            cityId = (Integer) req.getSearchCriteria().getOrDefault("cityId", null);
            engineerTypeId = (Integer) req.getSearchCriteria().getOrDefault("engineerTypeId", null);
            yearsOfExperience = (Integer) req.getSearchCriteria().getOrDefault("yearsOfExperience", null);
            engineerServId = (Integer) req.getSearchCriteria().getOrDefault("engineerServId", null);
            rate = (Integer) req.getSearchCriteria().getOrDefault("rate", null);
        }

        Sort sort = Sort.by(req.getSortableType() == 2 ? Sort.Direction.DESC : Sort.Direction.ASC, req.getSortableColumn());

        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), sort);

        return engineerReps.filterTop(governorateId, cityId, engineerTypeId, yearsOfExperience, engineerServId, rate, pageable);
    }

    public List<Engineer> LandingPage() {
        return engineerReps.LandingPage();
    }
}