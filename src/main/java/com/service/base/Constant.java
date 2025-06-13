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


    public class OrderStatusEnum {
        public static final String PENDING = "PENDING";
        public static final String CANCELED = "CANCELED";
        public static final String DELIVERED = "DELIVERED";
    }
}
