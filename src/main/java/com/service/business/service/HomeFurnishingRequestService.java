package com.service.business.service;

import com.service.base.Constant;
import com.service.base.service.BaseServiceImpl;
import com.service.business.model.HomeFurnishingRequest;
import com.service.business.model.HomeFurnishingRequestType;
import com.service.error.BadRequestException;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeFurnishingRequestService extends BaseServiceImpl<HomeFurnishingRequest, Long> {

    private final HomeFurnishingRequestTypeService homeFurnishingRequestTypeService;
    private final UserService userService;

    @Override
    public HomeFurnishingRequest insert(HomeFurnishingRequest entity) {
        associateHomeFurnishingRequestTypeWithUser(entity);
        HomeFurnishingRequestType requestType = homeFurnishingRequestTypeService.findById(entity.getRequestType().getId());
        validateRequestDateByType(entity, requestType);

        return super.insert(entity);
    }

    @Override
    public HomeFurnishingRequest update(HomeFurnishingRequest entity) {
        associateHomeFurnishingRequestTypeWithUser(entity);
        validateRequestDateByType(entity, entity.getRequestType());
        return super.update(entity);
    }

    private void validateRequestDateByType(HomeFurnishingRequest entity, HomeFurnishingRequestType requestType) {
        switch (requestType.getCode()) {
            case Constant.HomeFurnishingRequestTypeEnum.KITCHEN ->
                validateKitchenRequest(entity);
            case Constant.HomeFurnishingRequestTypeEnum.DRESSING_ROOM ->
                validateDressingRoomRequest(entity);
            case Constant.HomeFurnishingRequestTypeEnum.FURNISH_HOUSE ->
                validateFurnishHouseRequest(entity);
        }
    }

    private void validateKitchenRequest(HomeFurnishingRequest entity) {
        if (entity.getKitchenSize() == null || entity.getKitchenSize() == 0) {
            throw new BadRequestException("Kitchen size is required and must be greater than zero");
        }
        if (entity.getDevicesAttacheds() == null || entity.getDevicesAttacheds().isEmpty()) {
            throw new BadRequestException("At least one kitchen device must be attached");
        }
        if (entity.getProductMaterial() == null) {
            throw new BadRequestException("Product material must be specified for kitchen");
        }
        if (entity.getKitchenType() == null) {
            throw new BadRequestException("Kitchen type must be specified");
        }
    }

    private void validateDressingRoomRequest(HomeFurnishingRequest entity) {
        if (entity.getProductMaterial() == null || entity.getProductMaterial().isEmpty()) {
            throw new BadRequestException("Product material must be specified for dressing room");
        }
    }

    private void validateFurnishHouseRequest(HomeFurnishingRequest entity) {
        if (entity.getFurnitureType() == null) {
            throw new BadRequestException("Furniture type must be specified for furnish house");
        }
    }

    private void associateHomeFurnishingRequestTypeWithUser(HomeFurnishingRequest furnishingRequest) {
        User user = userService.getCurrentUser();
        furnishingRequest.setUser(user);
    }

}
