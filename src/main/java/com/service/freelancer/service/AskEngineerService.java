package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.dto.AskEngineerDto;
import com.service.freelancer.model.AskEngineer;
import com.service.freelancer.repository.AskEngineerReps;
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
public class AskEngineerService extends BaseServiceImpl<AskEngineer, Long> {

    private final UserService userService;

    private final AskEngineerReps askEngineerReps;

    @Override
    public AskEngineer insert(AskEngineer entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public AskEngineer update(AskEngineer entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }

    public Page<AskEngineer> filter(Optional<SearchRequest> request) {
        SearchRequest req = request.orElse(new SearchRequest());

        Number userId = null;
        String projectName = null;
        Integer engineerTypeId = null;
        Integer unitTypeId = null;
        Integer governorateId = null;
        Integer cityId = null;
        Integer urgencyLevelId = null;
        Number budgetFrom = null;
        Number budgetTo = null;



        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            userId = (Number) req.getSearchCriteria().getOrDefault("userId", null);
            unitTypeId = (Integer) req.getSearchCriteria().getOrDefault("unitTypeId", null);
            governorateId = (Integer) req.getSearchCriteria().getOrDefault("governorateId", null);
            cityId = (Integer) req.getSearchCriteria().getOrDefault("cityId", null);
            projectName = (String) req.getSearchCriteria().getOrDefault("projectName", null);
            engineerTypeId = (Integer) req.getSearchCriteria().getOrDefault("engineerTypeId", null);
            urgencyLevelId = (Integer) req.getSearchCriteria().getOrDefault("urgencyLevelId", null);
            budgetFrom = (Number) req.getSearchCriteria().getOrDefault("budgetFrom", null);
            budgetTo = (Number) req.getSearchCriteria().getOrDefault("budgetTo", null);

        }

        Sort sort = Sort.by(req.getSortableType() == 2 ? Sort.Direction.DESC : Sort.Direction.ASC,
                req.getSortableColumn());

        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), sort);

        return askEngineerReps.filter(
                userId != null ? userId.longValue() : null,
                unitTypeId,
                governorateId,
                cityId,
                projectName,
                engineerTypeId,
                urgencyLevelId,
                budgetFrom != null ? budgetFrom.longValue() : null,
                budgetTo != null ? budgetTo.longValue() : null,
                pageable
        );
    }

    public List<AskEngineer> getMyAsks() {
        Long userId = userService.getCurrentUser().getId();
        return askEngineerReps.getMyAsks(userId);
    }
}
