DROP TABLE IF EXISTS `fre_engineer_rating`;
CREATE TABLE `fre_engineer_rating`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `status_code` INTEGER NOT NULL DEFAULT 5,
    `rate` INT,
    `comment` VARCHAR(255),
    `engineer_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fre_engineer_id_1365421` FOREIGN KEY (`engineer_id`) REFERENCES `fre_engineer` (`id`)
);

DROP TABLE IF EXISTS `fre_engineering_office_rate`;
CREATE TABLE `fre_engineering_office_rate`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `status_code` INTEGER NOT NULL DEFAULT 5,
    `rate` INT,
    `comment` VARCHAR(255),
    `office_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fre_office_id_1365421` FOREIGN KEY (`office_id`) REFERENCES `fre_technical_worker` (`id`)
);

DROP TABLE IF EXISTS `fre_technical_worker_rating`;

CREATE TABLE `fre_technical_worker_rating` (
       `id` BIGINT NOT NULL AUTO_INCREMENT,
       `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
       `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
       `status_code` INTEGER NOT NULL DEFAULT 5,
       `business_type_id` INT NOT NULL,
       `rate` INT,
       `comment` VARCHAR(255),
       `worker_id` BIGINT NOT NULL,
       PRIMARY KEY (`id`),
       CONSTRAINT `fre_worker_id_1365421` FOREIGN KEY (`worker_id`) REFERENCES `fre_technical_worker` (`id`)
);

