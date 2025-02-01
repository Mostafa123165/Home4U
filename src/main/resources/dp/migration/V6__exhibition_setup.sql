DROP TABLE IF EXISTS exhibition;

SET FOREIGN_KEY_CHECKS = 0;

SET @table_exists = (SELECT EXISTS(SELECT 1 FROM information_schema.tables WHERE table_name = 'exhibition_type_lkp'));

-- If the table exists, rename it
SET @sql = IF(@table_exists > 0, 'RENAME TABLE exhibition_type_lkp TO ret_exhibition_type_lkp;', 'select 1');

-- Execute the SQL statement if it was generated
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;


DROP TABLE IF EXISTS ret_exhibitions;
CREATE TABLE IF NOT EXISTS ret_exhibitions (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT,
    `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `trad_name` VARCHAR(255) NOT NULL,
    `bio_ar` TEXT NOT NULL,
    `bio_en` TEXT NOT NULL,
    `image_path` VARCHAR(1000),
    `user_id` BIGINT NOT NULL,
    CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    PRIMARY KEY (`id`)
) auto_increment=1,engine=InnoDB;

DROP TABLE IF EXISTS ret_exhibitions_types;
CREATE TABLE IF NOT EXISTS ret_exhibitions_types (
    `exhibition_id` BIGINT NOT NULL,
    `exhibition_type_id` integer NOT NULL,
    CONSTRAINT `fk_exhibition` FOREIGN KEY (`exhibition_id`) REFERENCES `ret_exhibitions`(`id`),
    CONSTRAINT `fk_exhibition_id` FOREIGN KEY (`exhibition_type_id`) REFERENCES `ret_exhibition_type_lkp`(`id`),
    PRIMARY KEY (`exhibition_id`,`exhibition_type_id`)
) auto_increment=1,engine=InnoDB;


DELETE FROM ret_exhibition_type_lkp where code = 'ALL';

SET FOREIGN_KEY_CHECKS = 1;