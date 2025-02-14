SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS ret_store_type_lkp;
DROP TABLE IF EXISTS ret_stores;
DROP TABLE IF EXISTS ret_stores_types;
DROP TABLE IF EXISTS ret_exhibition_type_lkp;
DROP TABLE IF EXISTS ret_exhibitions;

DROP TABLE IF EXISTS store_type_lkp;
DROP TABLE IF EXISTS stores;
DROP TABLE IF EXISTS stores_types;
DROP TABLE IF EXISTS exhibition_type_lkp;
DROP TABLE IF EXISTS exhibitions;
DROP TABLE IF EXISTS building_materials_supplier;



DROP TABLE IF EXISTS businesses;
CREATE TABLE IF NOT EXISTS businesses (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT,
    `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `trad_name` VARCHAR(255) NOT NULL,
    `bio_ar` TEXT NOT NULL,
    `bio_en` TEXT NOT NULL,
    `image_path` VARCHAR(1000),
    `user_id` BIGINT NOT NULL,
    `user_type_id` BIGINT NOT NULL,
    CONSTRAINT `fk_businesses_user` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT `fk_businesses_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type_lkp`(`id`),
    PRIMARY KEY (`id`)
    ) auto_increment=1,engine=InnoDB;


DROP TABLE IF EXISTS `business_type_lkp`;
CREATE TABLE IF NOT EXISTS `business_type_lkp`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `code` 	  VARCHAR(70) NOT NULL,
    `name_ar` VARCHAR(70) NOT NULL,
    `name_en` VARCHAR(70) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    `user_type_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_type_id`) REFERENCES `user_type_lkp`(`id`),
    PRIMARY KEY (`id`)
    ) AUTO_INCREMENT=1, ENGINE=InnoDB;


DROP TABLE IF EXISTS businesses_types;
CREATE TABLE IF NOT EXISTS businesses_types (
    `business_id` BIGINT NOT NULL ,
    `business_type_id` INT NOT NULL ,

    FOREIGN KEY (`business_id`) REFERENCES `businesses`(`id`),
    FOREIGN KEY (`business_type_id`) REFERENCES `business_type_lkp`(`id`),
    PRIMARY KEY (`business_id`,`business_type_id`)
    )engine=InnoDB;

INSERT INTO `business_type_lkp` (`code`, `name_ar`, `name_en`,`user_type_id`,`status_code`)
VALUES
    ('FURNITURE', 'أثاث', 'furniture',(select id from user_type_lkp where code = 'EXHIBITION'), 5),
    ('KITCHENS_DRESSINGS', 'مطابخ ودريسينج', 'kitchens and dressing',(select id from user_type_lkp where code = 'EXHIBITION'), 5),
    ('ELECTRICAL_TOOLS', 'أدوات كهربائية', 'electrical tools',(select id from user_type_lkp where code = 'STORE'), 5),
    ('FURNITURE', 'مفروشات', 'furniture',(select id from user_type_lkp where code = 'STORE'), 5),
    ('PAINT_MATERIALS', 'مواد طلاء', 'paint materials',(select id from user_type_lkp where code = 'STORE'), 5);
SET FOREIGN_KEY_CHECKS = 1;
