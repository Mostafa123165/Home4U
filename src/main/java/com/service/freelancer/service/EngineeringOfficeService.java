package com.service.freelancer.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.mapper.EngineeringOfficeMapper;
import com.service.freelancer.model.EngineeringOffice;
import com.service.freelancer.repository.EngineeringOfficeReps;
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
public class EngineeringOfficeService extends BaseServiceImpl<EngineeringOffice, Long> {

    private final UserService userService;
    private final EngineeringOfficeReps engineeringOfficeReps;

    public EngineeringOffice findByUserId(Long userId) {
        if (userId == null) userId = userService.getCurrentUser().getId();
        EngineeringOffice engineeringOffice = engineeringOfficeReps.findByUserId(userId);
        return engineeringOffice;
    }


    public Page<EngineeringOffice> filterTop(Optional<SearchRequest> request) {
        SearchRequest req = request.orElse(new SearchRequest());

        Number governorateId = null;
        Number cityId = null;
        Number engineeringOfficeFieldId = null;
        Number engineeringOfficeDepartmentId = null;
        Integer rate = null;

        if (req.getSearchCriteria() != null && !req.getSearchCriteria().isEmpty()) {
            governorateId = (Integer) req.getSearchCriteria().getOrDefault("governorateId", null);
            cityId = (Integer) req.getSearchCriteria().getOrDefault("cityId", null);
            engineeringOfficeFieldId = (Integer) req.getSearchCriteria().getOrDefault("engineeringOfficeFieldId", null);
            engineeringOfficeDepartmentId = (Integer) req.getSearchCriteria().getOrDefault("engineeringOfficeDepartmentId", null);
            rate = (Integer) req.getSearchCriteria().getOrDefault("rate", null);
        }

        Sort sort = Sort.by(req.getSortableType() == 2 ? Sort.Direction.DESC : Sort.Direction.ASC,
                req.getSortableColumn());

        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), sort);

        return engineeringOfficeReps.filterTop(
                governorateId,
                cityId,
                engineeringOfficeFieldId,
                engineeringOfficeDepartmentId,
                rate,
                pageable
        );
    }
}
