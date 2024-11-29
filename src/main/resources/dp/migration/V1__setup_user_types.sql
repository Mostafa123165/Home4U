SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE if NOT EXISTS `user`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT,
    `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `email`    VARCHAR(255) UNIQUE,
    `phone`    VARCHAR(255) UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `user_type_id` BIGINT NOT NULL,
    CONSTRAINT `fk_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type_lkp`(`id`),
    CHECK (`email` IS NOT NULL OR `phone` IS NOT NULL),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `user_type_lkp`;
CREATE TABLE if NOT EXISTS `user_type_lkp` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `code` 	      VARCHAR(70) NOT NULL,
    `name_ar` 	  VARCHAR(70) NOT NULL,
    `name_en` 	  VARCHAR(70) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE  KEY (`code`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;


DROP TABLE IF EXISTS `engineer`;
CREATE TABLE if NOT EXISTS `engineer` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `engineer_type_id` INTEGER NOT NULL,
    `user_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT `fk_engineer_type` FOREIGN KEY (`engineer_type_id`) REFERENCES `engineer_type_lkp`(`id`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `engineer_type_lkp`;
CREATE TABLE if NOT EXISTS `engineer_type_lkp` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `code` 		  VARCHAR(70) NOT NULL,
    `name_ar` 	  VARCHAR(70) NOT NULL,
    `name_en` 	  VARCHAR(70) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE  KEY (`code`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `technical_worker`;
CREATE TABLE if NOT EXISTS `technical_worker` (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `technical_worker_type_id` INTEGER NOT NULL,
     `user_id` BIGINT NOT NULL,
     FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
     CONSTRAINT `fk_technical_worker_type` FOREIGN KEY (`technical_worker_type_id`) REFERENCES `technical_worker_type_lkp`(`id`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `technical_worker_type_lkp`;
CREATE TABLE if NOT EXISTS `technical_worker_type_lkp` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `code` 		  VARCHAR(70) NOT NULL,
    `name_ar` 	  VARCHAR(70) NOT NULL,
    `name_en` 	  VARCHAR(70) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE  KEY (`code`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `store`;
CREATE TABLE if NOT EXISTS `store` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `store_type_id` INTEGER NOT NULL,
    `user_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT `fk_store` FOREIGN KEY (`store_type_id`) REFERENCES `store_type_lkp`(`id`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `store_type_lkp`;
CREATE TABLE if NOT EXISTS `store_type_lkp` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `code` 		  VARCHAR(70) NOT NULL,
    `name_ar` 	  VARCHAR(70) NOT NULL,
    `name_en` 	  VARCHAR(70) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE  KEY (`code`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `exhibition`;
CREATE TABLE if NOT EXISTS `exhibition` (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `exhibition_type_id` INTEGER NOT NULL,
     `user_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
     CONSTRAINT `fk_exhibition` FOREIGN KEY (`exhibition_type_id`) REFERENCES `exhibition_type_lkp`(`id`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `exhibition_type_lkp`;
CREATE TABLE if NOT EXISTS `exhibition_type_lkp` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `code` 		  VARCHAR(70) NOT NULL,
    `name_ar` 	  VARCHAR(70) NOT NULL,
    `name_en` 	  VARCHAR(70) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE  KEY (`code`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS `building_materials_supplier`;
CREATE TABLE if NOT EXISTS `building_materials_supplier` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;


DROP TABLE IF EXISTS `engineering_office`;
CREATE TABLE if NOT EXISTS `engineering_office` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    PRIMARY KEY (`id`)
)auto_increment=1,engine=InnoDB;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user_type_lkp` (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('ENGINEER', 'مهندس', 'engineer', 5),
    ('TECHNICAL_WORKER', 'عامل فني', 'technical worker', 5),
    ('EXHIBITION', 'معرض', 'exhibition', 5),
    ('ENGINEERING_OFFICE', 'مكتب هندسي', 'engineering office', 5),
    ('STORE', 'متجر', 'store', 5),
    ('BUILDING_MATERIALS_SUPPLIER', 'مورد مواد بناء', 'building materials supplier', 5),
    ('GENERAL_USER', 'مستخدم عام', 'general user', 1),
    ('ADMIN', 'ادمن', 'admin', 1);


INSERT INTO `engineer_type_lkp` (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('ELECTRICAL_ENGINEER', 'مهندس كهرباء', 'Electrical Engineer', 5),
    ('INTERIOR DESIGNER', 'مصمم داخلي', 'Interior Designer', 5),
    ('ARCHITECT', 'مهندس معماري', 'Architect', 5);

INSERT INTO `technical_worker_type_lkp` (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('PLUMBER', 'سباك', 'plumber', 5),
    ('CARPENTER', 'نجار', 'carpenter', 5),
    ('PAINTER', 'نقاش', 'painter', 5),
    ('TILER', 'بلاط', 'tiler', 5),
    ('PLASTERER', 'محار', 'plasterer', 5),
    ('ELECTRICIAN', 'كهربائي', 'electrician', 5),
    ('IRON_WORKER', 'حداد مسلح', 'iron-worker', 5),
    ('OTHER', 'أخرى', 'other', 5);

INSERT INTO `store_type_lkp` (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('ELECTRICAL_TOOLS', 'أدوات كهربائية', 'electrical tools', 5),
    ('FURNITURE', 'مفروشات', 'furniture', 5),
    ('PAINT_MATERIALS', 'مواد طلاء', 'paint materials', 5),
    ('OTHER', 'أخرى', 'other', 5);

INSERT INTO `exhibition_type_lkp` (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('FURNITURE', 'أثاث', 'furniture', 5),
    ('KITCHENS_DRESSINGS', 'مطابخ ودريسينج', 'kitchens and dressing', 5),
    ('ALL', 'الكل', 'all', 5);
