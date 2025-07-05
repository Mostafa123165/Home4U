package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.repository.TechnicalWorkerReps;
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
public class TechnicalWorkerService extends BaseServiceImpl<TechnicalWorker, Long> {

    private final UserService userService;
    private final TechnicalWorkerReps technicalWorkerReps;

    public TechnicalWorker findByUserId(Long userId) {
        if (userId == null) userId = userService.getCurrentUser().getId();
        return technicalWorkerReps.findByUserId(userId);
    }

    public Page<TechnicalWorker> filterTop(Optional<SearchRequest> request) {
        SearchRequest req = request.orElse(new SearchRequest());

        Number governorateId = null;
        Number cityId = null;
        Number technicalWorkerTypeId = null;
        Number technicalWorkerServId = null;
        Integer yearsOfExperience = null;
        Integer rate = null;

        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            governorateId = (Integer) req.getSearchCriteria().getOrDefault("governorateId", null);
            cityId = (Integer) req.getSearchCriteria().getOrDefault("cityId", null);
            technicalWorkerTypeId = (Integer) req.getSearchCriteria().getOrDefault("technicalWorkerTypeId", null);
            yearsOfExperience = (Integer) req.getSearchCriteria().getOrDefault("yearsOfExperience", null);
            technicalWorkerServId = (Integer) req.getSearchCriteria().getOrDefault("technicalWorkerServId", null);
            rate = (Integer) req.getSearchCriteria().getOrDefault("rate", null);
        }

        Sort sort = Sort.by(req.getSortableType() == 2 ? Sort.Direction.DESC : Sort.Direction.ASC,
                req.getSortableColumn());

        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), sort);

        return technicalWorkerReps.filterTop(
                governorateId,
                cityId,
                technicalWorkerTypeId,
                yearsOfExperience,
                technicalWorkerServId,
                rate,
                pageable
        );
    }

    public List<TechnicalWorker> LandingPage() {
        return technicalWorkerReps.LandingPage();
    }
}
