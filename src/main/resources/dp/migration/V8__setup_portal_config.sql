DROP TABLE IF EXISTS common_portal_config;
CREATE TABLE IF NOT EXISTS common_portal_config (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT,
    `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `config_key` VARCHAR(255) NOT NULL,
    `config_value` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) auto_increment=1,engine=InnoDB;

INSERT INTO common_portal_config (created_date,modified_date,status_code,config_key,config_value) VALUES
    (now(),now(),NULL,'BUSINESS_PRODUCTS','business/products/');

