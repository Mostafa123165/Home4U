SET FOREIGN_KEY_CHECKS =0 ;
DROP TABLE IF EXISTS `home_furnishing_requests`;
CREATE TABLE IF NOT EXISTS `home_furnishing_requests` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT DEFAULT 5,
    `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `phone_number` VARCHAR(11) NOT NULL,
    `time_frame_days` INT NOT NULL,
    `budget` double NOT NULL,
    `attachment_file_url` VARCHAR(255) ,
    `note` TEXT,
    `user_id` BIGINT NOT NULL,
    `request_type_id` INT NOT NULL,
    `government_id` INT NOT NULL,
    `kitchen_type_id` INT,
    `kitchen_size` BIGINT,
    `furniture_type_id` INT,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_government` FOREIGN KEY (`government_id`) REFERENCES `governorate_lkp`(`id`),
    CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT `fk_furniture_type` FOREIGN KEY (`furniture_type_id`) REFERENCES `furniture_type_lkp`(`id`),
    CONSTRAINT `fk_request_type` FOREIGN KEY (`request_type_id`) REFERENCES `home_furnishing_request_type_lkp`(`id`),
    CONSTRAINT `fk_kitchen_type` FOREIGN KEY (`kitchen_type_id`) REFERENCES `kitchen_type_lkp`(`id`)
    ) ENGINE=InnoDB;

DROP TABLE IF EXISTS `furnishing_request_product_materials`;

CREATE TABLE IF NOT EXISTS furnishing_request_product_materials (
    furnishing_request_id BIGINT NOT NULL,
    product_material_id INT NOT NULL,
    CONSTRAINT pk_furnishing_request_product_materials PRIMARY KEY (furnishing_request_id, product_material_id),
    CONSTRAINT fk_furnishing_request FOREIGN KEY (furnishing_request_id) REFERENCES home_furnishing_requests(id),
    CONSTRAINT fk_product_material FOREIGN KEY (product_material_id) REFERENCES product_material_lkp(id)
    );

CREATE INDEX idx_furnishing_request ON furnishing_request_product_materials(furnishing_request_id);
CREATE INDEX idx_product_material ON furnishing_request_product_materials(product_material_id);

DROP TABLE IF EXISTS `furnishing_request_devices_attacheds`;
CREATE TABLE if not exists furnishing_request_devices_attacheds (
    furnishing_request_id BIGINT NOT NULL,
    devices_attached_id INT NOT NULL,
    CONSTRAINT  PRIMARY KEY (furnishing_request_id, devices_attached_id),
    CONSTRAINT  FOREIGN KEY (furnishing_request_id) REFERENCES home_furnishing_requests(id),
    CONSTRAINT  FOREIGN KEY (devices_attached_id) REFERENCES devices_attached_lkp(id)
);


CREATE INDEX idx_furnishing_request ON furnishing_request_devices_attacheds(furnishing_request_id);
CREATE INDEX idx_devices_attached ON furnishing_request_devices_attacheds(devices_attached_id);


SET FOREIGN_KEY_CHECKS =1 ;