package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.AskEngineer;
import com.service.freelancer.model.SelectCustomPackage;
import com.service.freelancer.repository.SelectCustomPackageReps;
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
public class SelectCustomPackageService extends BaseServiceImpl<SelectCustomPackage, Long> {

    private final UserService userService;

    private final SelectCustomPackageReps selectCustomPackageReps;

    public List<SelectCustomPackage> getMyAsks() {
        Long userId = userService.getCurrentUser().getId();
        return selectCustomPackageReps.getMyAsks(userId);
    }

    @Override
    public SelectCustomPackage insert(SelectCustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public SelectCustomPackage update(SelectCustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }

    public Page<SelectCustomPackage> filter(Optional<SearchRequest> request) {

        SearchRequest req = request.orElse(new SearchRequest());

        Number userId = null;
        Integer unitTypeId = null;
        Integer customPackageId = null;
        Boolean isInsideCompound = null;


        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            userId = (Number) req.getSearchCriteria().getOrDefault("userId", null);
            unitTypeId = (Integer) req.getSearchCriteria().getOrDefault("unitTypeId", null);
            customPackageId = (Integer) req.getSearchCriteria().getOrDefault("customPackageId", null);
            isInsideCompound = (Boolean) req.getSearchCriteria().getOrDefault("isInsideCompound", null);
        }

        Sort sort = Sort.by(req.getSortableType() == 2 ? Sort.Direction.DESC : Sort.Direction.ASC,
                req.getSortableColumn());

        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), sort);

        assert isInsideCompound != null;
        return selectCustomPackageReps.filter(
                userId != null ? userId.longValue() : null,
                unitTypeId,
                customPackageId,
                isInsideCompound,
                pageable
        );
    }
}
