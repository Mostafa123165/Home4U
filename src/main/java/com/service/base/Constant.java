package com.service.base;

import lombok.Getter;

public class Constant {

    @Getter
    public enum StatusCodeEnum {
        DRAFT(1),
        CONFIRMED(2),
        APPROVED(3),
        REJECTED(4),
        ACTIVE(5),
        INACTIVE(6);

        private final Integer code;
        StatusCodeEnum(Integer code){
            this.code = code;
        }
    }

    public enum UserTypeEnum {
        ENGINEER,
        TECHNICAL_WORKER,
        EXHIBITION,
        ENGINEERING_OFFICE,
        STORE,
        BUILDING_MATERIALS_SUPPLIER,
        GENERAL_USER,
    }

    public class DateFormate {
        public static final String DEFAULT_TIMEZONE = "GMT+2";
        public static final String UTC = "UTC";
        public static final String TIME_FORMAT_HOURANDMINUTES =  "HH:mm"; //"hh:mm aa";
        public static final String TIME_FORMAT_HOURANDMINUTESSECOND =  "HH:mm:ss";
        public static final String TIME_FORMAT_HOUR_MINUTES_AM =  "hh:mm aa";
        public static final String FULL_DATE_FORMAT = "EEE, d MMM yyyy hh:mm:ss aaa";
        public static final String FULL_DATE_FORMAT2 = "d MMM yyyy, hh:mm:ss aaa";
        public static final String DATE_TIME_FORMAT_AM = "yyyy-MM-dd hh:mm:ss a";
        public static final String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";
        public static final String LOCAL_DATE_TIME_FORMAT = "EEE, dd MMM yyyy hh:mm:ss a";

        public static final String DATE_FORMAT = "yyyy-MM-dd";
        public static final String STRING_DATE_FORMAT = "yyyyMMdd";
        public static final String DAY_MONTH_FORMAT = "dd MMMM";
        public static final String TIME_FORMAT = "HH:mm:ss";
        public static final String DATE_FORMAT_UTC= "yyyy-MM-dd'T'HH:mm:ss'Z'";
    }

    public class ImageTableNameEunm {
        public static final String BUSINESS_PRODUCTS = "product_images";
        public static final String USER = "user";
        public static final String ENGINEERING_OFFICE = "fre_engineering_office";
        public static final String ASK_ENGINEER_PHOTOS = "fre_ask_engineer_photos";
        public static final String ASK_WORKER_PHOTOS = "fre_ask_worker_photos";

    }

    public class ConfigKeyEnum {
        public static final String BUSINESS_PRODUCTS = "BUSINESS_PRODUCTS";
        public static final String COVER_PHOTO = "COVER_PHOTO";
        public static final String PERSONAL_CARD = "PERSONAL_CARD";
        public static final String TAX_CARD = "TAX_CARD";
        public static final String COMMERCIAL_REGISTER = "COMMERCIAL_REGISTER";
        public static final String ASK_ENGINEER = "ASK_ENGINEER";
        public static final String ASK_WORKER = "ASK_WORKER";
    }


    public static class OrderStatusEnum {
        public static final String PENDING = "PENDING";
        public static final String CANCELED = "CANCELED";
        public static final String DELIVERED = "DELIVERED";
    }


    public static class KitchenDeviceEnum {
        public static final String FRIDGE = "FRIDGE";
        public static final String OVEN = "OVEN";
        public static final String MICROWAVE = "MICROWAVE";
        public static final String DISHWASHER = "DISHWASHER";
        public static final String COOKER = "COOKER";
        public static final String HOOD = "HOOD";
        public static final String FREEZER = "FREEZER";
        public static final String WASHING_MACHINE = "WASHING_MACHINE";
    }

    public static class HomeFurnishingRequestTypeEnum {
        public static final String FURNISH_HOUSE = "FURNISH_HOUSE";
        public static final String DRESSING_ROOM = "DRESSING_ROOM";
        public static final String KITCHEN = "KITCHEN";
    }

    public static class KitchenTypeEnum {
        public static final String AMERICAN = "AMERICAN";
        public static final String NORMAL = "NORMAL";
    }

    public static class FurnitureTypeEnum {
        public static final String MASTER_BEDROOM_SET = "MASTER_BEDROOM_SET";
        public static final String YOUTH_BEDROOM = "YOUTH_BEDROOM";
        public static final String CHILDREN_BEDROOM = "CHILDREN_BEDROOM";
        public static final String SEPARATE_BED = "SEPARATE_BED";
        public static final String WARDROBE = "WARDROBE";
        public static final String DESK = "DESK";
        public static final String DRESSING_TABLE = "DRESSING_TABLE";
        public static final String CABINET = "CABINET";
        public static final String COMPLETE_SOFA_SET = "COMPLETE_SOFA_SET";
        public static final String TWO_SEAT_SOFA = "TWO_SEAT_SOFA";
        public static final String THREE_SEAT_SOFA = "THREE_SEAT_SOFA";
        public static final String TOP_PIECE = "TOP_PIECE";
        public static final String L_SHAPED_SOFA = "L_SHAPED_SOFA";
        public static final String CENTER_TABLE = "CENTER_TABLE";
        public static final String SIDE_TABLE = "SIDE_TABLE";
        public static final String DINING_SET = "DINING_SET";
        public static final String DINING_SET_4 = "DINING_SET_4";
        public static final String DINING_SET_6 = "DINING_SET_6";
        public static final String DINING_SET_8 = "DINING_SET_8";
    }
}
