package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestDesign;
import com.service.freelancer.repository.RequestDesignReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestDesignService extends BaseServiceImpl<RequestDesign, Long> {

    private final UserService userService;
    private final RequestDesignReps requestDesignReps;

    @Override
    public RequestDesign insert(RequestDesign entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public RequestDesign update(RequestDesign entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }

    public Page<RequestDesign> filter(Optional<SearchRequest> request) {

        SearchRequest req = request.orElse(new SearchRequest());

        Number userId = null;
        Integer unitTypeId = null;
        Integer governorateId = null;
        Number unitAreaFrom = null;
        Number budgetFrom = null;
        Number budgetTo = null;
        Number unitAreaTo = null;
        Number requiredDurationFrom = null;
        Number requiredDurationTo = null;


        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            userId = (Number) req.getSearchCriteria().getOrDefault("userId", null);
            unitTypeId = (Integer) req.getSearchCriteria().getOrDefault("unitTypeId", null);
            governorateId = (Integer) req.getSearchCriteria().getOrDefault("governorateId", null);
            unitAreaFrom = (Number) req.getSearchCriteria().getOrDefault("unitAreaFrom", null);
            unitAreaTo = (Number) req.getSearchCriteria().getOrDefault("unitAreaTo", null);
            budgetFrom = (Number) req.getSearchCriteria().getOrDefault("budgetFrom", null);
            budgetTo = (Number) req.getSearchCriteria().getOrDefault("budgetTo", null);
            requiredDurationFrom = (Number) req.getSearchCriteria().getOrDefault("requiredDurationFrom", null);
            requiredDurationTo = (Number) req.getSearchCriteria().getOrDefault("requiredDurationTo", null);

        }

        Sort sort = Sort.by(req.getSortableType() == 2 ? Sort.Direction.DESC : Sort.Direction.ASC,
                req.getSortableColumn());

        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), sort);

        return requestDesignReps.filter(
                userId != null ? userId.longValue() : null,
                unitTypeId,
                governorateId,
                budgetFrom != null ? budgetFrom.longValue() : null,
                budgetTo != null ? budgetTo.longValue() : null,
                unitAreaFrom != null ? unitAreaFrom.longValue() : null,
                unitAreaTo != null ? unitAreaTo.longValue() : null,
                requiredDurationFrom != null ? requiredDurationFrom.longValue() : null,
                requiredDurationTo != null ? requiredDurationTo.longValue() : null,
                pageable
        );
    }

}
