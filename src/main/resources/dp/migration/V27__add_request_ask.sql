
DROP TABLE IF EXISTS `fre_request_ask_worker`;
CREATE TABLE `fre_request_ask_worker` (
                                          `id` BIGINT NOT NULL AUTO_INCREMENT,
                                          `status_code` INT DEFAULT 5,
                                          `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
                                          `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
                                          `user_id` BIGINT NOT NULL,
                                          `ask_id` BIGINT NOT NULL,
                                          `comment` VARCHAR(255) NOT NULL,
                                          `is_accepted` BOOLEAN,
                                          `is_finished` BOOLEAN,
                                          `is_rejected` BOOLEAN,
                                          PRIMARY KEY (`id`),
                                          CONSTRAINT fk_user132564 FOREIGN KEY (user_id) REFERENCES user(id),
                                          CONSTRAINT fk_as89213k FOREIGN KEY (ask_id) REFERENCES fre_ask_worker(id)
);


DROP TABLE IF EXISTS `fre_request_ask_engineer`;
CREATE TABLE `fre_request_ask_engineer` (
                                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                                            `status_code` INT DEFAULT 5,
                                            `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
                                            `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
                                            `user_id` BIGINT NOT NULL,
                                            `ask_id` BIGINT NOT NULL,
                                            `comment` VARCHAR(255) NOT NULL,
                                            `is_accepted` BOOLEAN,
                                            `is_finished` BOOLEAN,
                                            `is_rejected` BOOLEAN,
                                            PRIMARY KEY (`id`),
                                            CONSTRAINT fk_user89456123 FOREIGN KEY (user_id) REFERENCES user(id),
                                            CONSTRAINT fk_as456123k FOREIGN KEY (ask_id) REFERENCES fre_ask_engineer(id)
);

