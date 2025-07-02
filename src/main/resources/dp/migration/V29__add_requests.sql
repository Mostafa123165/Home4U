
DROP TABLE IF EXISTS `fre_request_home_renovate`;
CREATE TABLE `fre_request_home_renovate` (
                 `id` BIGINT NOT NULL AUTO_INCREMENT,
                 `status_code` INT DEFAULT 5,
                 `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
                 `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
                 `user_id` BIGINT NOT NULL,
                 `renovate_id` BIGINT NOT NULL,
                 `comment` VARCHAR(255) NOT NULL,
                 `is_accepted` BOOLEAN,
                 `is_finished` BOOLEAN,
                 `is_rejected` BOOLEAN,
                 PRIMARY KEY (`id`),
                 CONSTRAINT fk_user13278564 FOREIGN KEY (user_id) REFERENCES user(id),
                 CONSTRAINT fk_as8925413k FOREIGN KEY (renovate_id) REFERENCES fre_home_renovate(id)
);


DROP TABLE IF EXISTS `fre_request_request_design`;
CREATE TABLE `fre_request_request_design` (
              `id` BIGINT NOT NULL AUTO_INCREMENT,
              `status_code` INT DEFAULT 5,
              `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
              `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
              `user_id` BIGINT NOT NULL,
              `request_id` BIGINT NOT NULL,
              `comment` VARCHAR(255) NOT NULL,
              `is_accepted` BOOLEAN,
              `is_finished` BOOLEAN,
              `is_rejected` BOOLEAN,
              PRIMARY KEY (`id`),
              CONSTRAINT fk_use47r89456123 FOREIGN KEY (user_id) REFERENCES user(id),
              CONSTRAINT fk_as45612853k FOREIGN KEY (request_id) REFERENCES fre_request_design(id)
);

DROP TABLE IF EXISTS `fre_request_select_custom_package`;
CREATE TABLE `fre_request_select_custom_package` (
             `id` BIGINT NOT NULL AUTO_INCREMENT,
             `status_code` INT DEFAULT 5,
             `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
             `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
             `user_id` BIGINT NOT NULL,
             `select_package_id` BIGINT NOT NULL,
             `comment` VARCHAR(255) NOT NULL,
             `is_accepted` BOOLEAN,
             `is_finished` BOOLEAN,
             `is_rejected` BOOLEAN,
             PRIMARY KEY (`id`),
             CONSTRAINT fk_use56r89456123 FOREIGN KEY (user_id) REFERENCES user(id),
             CONSTRAINT fk_as454566123k FOREIGN KEY (select_package_id) REFERENCES fre_select_custom_package(id)
);

