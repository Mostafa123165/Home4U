package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.dto.HomeRenovateDto;
import com.service.freelancer.model.AskEngineer;
import com.service.freelancer.model.HomeRenovate;
import com.service.freelancer.repository.HomeRenovateReps;
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
public class HomeRenovateService extends BaseServiceImpl<HomeRenovate, Long> {

    private final UserService userService;
    private final HomeRenovateReps homeRenovateReps;

    public List<HomeRenovate> getMyAsks() {
        Long userId = userService.getCurrentUser().getId();
        return homeRenovateReps.getMyAsks(userId);
    }

    @Override
    public HomeRenovate insert(HomeRenovate entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public HomeRenovate update(HomeRenovate entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }

    public Page<HomeRenovate> filter(Optional<SearchRequest> request) {
        SearchRequest req = request.orElse(new SearchRequest());

        Number userId = null;
        Integer unitTypeId = null;
        Integer governorateId = null;
        Integer unitWorkTypeId = null;
        Integer workSkillId = null;
        Integer unitStatusId = null;
        Integer cityId = null;
        Number unitAreaFrom = null;
        Number unitAreaTo = null;
        Number budgetFrom = null;
        Number budgetTo = null;
        Number requiredDurationFrom = null;
        Number requiredDurationTo = null;


        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            userId = (Integer) req.getSearchCriteria().getOrDefault("userId", null);
            unitTypeId = (Integer) req.getSearchCriteria().getOrDefault("unitTypeId", null);
            governorateId = (Integer) req.getSearchCriteria().getOrDefault("governorateId", null);
            unitWorkTypeId = (Integer) req.getSearchCriteria().getOrDefault("unitWorkTypeId", null);
            workSkillId = (Integer) req.getSearchCriteria().getOrDefault("workSkillId", null);
            unitStatusId = (Integer) req.getSearchCriteria().getOrDefault("unitStatusId", null);
            cityId = (Integer) req.getSearchCriteria().getOrDefault("cityId", null);
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

        return homeRenovateReps.filter(
                userId != null ? userId.longValue() : null,
                unitTypeId,
                governorateId,
                cityId,
                unitStatusId,
                workSkillId,
                unitWorkTypeId,
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
