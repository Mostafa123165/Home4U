

DROP TABLE IF EXISTS `fre_project`;
CREATE TABLE if NOT EXISTS `fre_project`(
                                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                                            `status_code` INT,
                                            `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) ,
    `start_date` date ,
    `end_date`    date ,
    `user_id` BIGINT NOT NULL,
    CONSTRAINT `fk_user_project_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    PRIMARY KEY (`id`)
    )auto_increment=1,engine=InnoDB;

ALTER TABLE fre_project ADD COLUMN tools VARCHAR(255);



DROP TABLE IF EXISTS `fre_project_image`;
CREATE TABLE if NOT EXISTS `fre_project_image`(
                                                  `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `status_code` INT,
                                                  `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `path` VARCHAR(255) NOT NULL,
    `project_id` BIGINT NOT NULL,
    CONSTRAINT `fk_path_project_id` FOREIGN KEY (`project_id`) REFERENCES `fre_project`(`id`),
    PRIMARY KEY (`id`)
    )auto_increment=1,engine=InnoDB;


DROP TABLE IF EXISTS `fre_certification`;
CREATE TABLE if NOT EXISTS `fre_certification`(
                                                  `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `status_code` INT,
                                                  `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) ,
    `path` VARCHAR(255) NOT NULL,
    `user_id` BIGINT NOT NULL,
    CONSTRAINT `fk_user_certification_id` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    PRIMARY KEY (`id`)
    )auto_increment=1,engine=InnoDB;


ALTER TABLE home4u.fre_certification MODIFY path VARCHAR(255) NULL;





ALTER TABLE fre_project
    ADD COLUMN cover_path VARCHAR(255);