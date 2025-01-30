DROP TABLE IF EXISTS `fre_engineering_office_department`;
DROP TABLE IF EXISTS `fre_engineering_office`;
DROP TABLE IF EXISTS `fre_engineering_office_departments_lkp`;
DROP TABLE IF EXISTS `fre_engineering_offices_fields_lkp`;
CREATE TABLE IF NOT EXISTS `home4u`.`fre_engineering_offices_fields_lkp` (
                                                                             `id` INTEGER NOT NULL AUTO_INCREMENT,
                                                                             `code` VARCHAR(70) NOT NULL,
    `name_ar` VARCHAR(150) NOT NULL,
    `name_en` VARCHAR(150) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY (`code`),
    PRIMARY KEY (`id`)
    ) AUTO_INCREMENT=1, ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `home4u`.`fre_engineering_office_departments_lkp` (
                                                                                 `id` INTEGER NOT NULL AUTO_INCREMENT,
                                                                                 `code` VARCHAR(70) NOT NULL,
    `name_ar` VARCHAR(150) NOT NULL,
    `name_en` VARCHAR(150) NOT NULL,
    `engineer_office_field_id` INT,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY (`code`),
    PRIMARY KEY (`id`),
    CONSTRAINT fk_engineer_office_field_id FOREIGN KEY (engineer_office_field_id) REFERENCES fre_engineering_offices_fields_lkp(id)
    ) AUTO_INCREMENT=1, ENGINE=InnoDB;

INSERT INTO fre_engineering_offices_fields_lkp (code, name_ar, name_en, status_code) VALUES
                                                                                         ('FURNITURE', 'الأثاث', 'Furniture', 5),
                                                                                         ('NATURAL_RESOURCES', 'الموارد الطبيعية', 'Natural Resources', 5),
                                                                                         ('BUILDING_MATERIALS', 'مواد البناء', 'Building Materials', 5),
                                                                                         ('ACCESSORIES_AND_DECORATIONS', 'إكسسوارات وديكورات', 'Accessories and Decorations', 5),
                                                                                         ('FINISHES', 'التشطيبات', 'Finishes', 5),
                                                                                         ('DOORS', 'الأبواب', 'Doors', 5),
                                                                                         ('LIGHTING', 'الإضاءة', 'Lighting', 5),
                                                                                         ('ALUMINUM', 'الألوميتال', 'Aluminum', 5),
                                                                                         ('FABRICS_AND_UPHOLSTERY', 'الأقمشة والمفروشات', 'Fabrics and Upholstery', 5),
                                                                                         ('HOME_APPLIANCES', 'الأجهزة المنزلية', 'Home Appliances', 5),
                                                                                         ('HANDICRAFTS', 'الصناعات اليدوية', 'Handicrafts', 5),
                                                                                         ('EXTERNAL_FINISHES', 'التشطيبات الخارجية', 'External Finishes', 5),
                                                                                         ('MACHINES', 'ماكينات', 'Machines', 5),
                                                                                         ('SECURITY', 'الأمن', 'Security', 5),
                                                                                         ('CONSTRUCTIONS', 'إنشاءات', 'Constructions', 5),
                                                                                         ('OTHER', 'اخري', 'other', 5);

INSERT INTO home4u.fre_engineering_office_departments_lkp (code, name_ar, name_en, engineer_office_field_id, status_code) VALUES
                                                                                                                              ('OFFICE_FURNITURE', 'أثاث المكاتب', 'Office Furniture', 1, 5),
                                                                                                                              ('STORAGE_UNITS', 'وحدات تخزين', 'Storage Units', 1, 5),
                                                                                                                              ('HOME_FURNITURE', 'أثاث منزلي', 'Home Furniture', 1, 5),
                                                                                                                              ('OUTDOOR_FURNITURE', 'أثاث خارجي', 'Outdoor Furniture', 1, 5),
                                                                                                                              ('METAL_FURNITURE', 'أثاث معدني', 'Metal Furniture', 1, 5),
                                                                                                                              ('KITCHENS', 'مطابخ', 'Kitchens', 1, 5),
                                                                                                                              ('DRESSING_ROOMS', 'دريسنج', 'Dressing Rooms', 1, 5),
                                                                                                                              ('CHILDRENS_FURNITURE', 'اثاث اطفال', 'Children\'s Furniture', 1, 5),
('RAW_MATERIALS', 'المواد الخام', 'Raw Materials', 2, 5),
('BUILDING_MATERIALS', 'مواد البناء', 'Building Materials', 3, 5),
('ACCESSORIES_AND_DECORATIONS', 'اكسسورات وديكورات', 'Accessories and Decorations', 4, 5),
('WALLPAPER', 'ورق حائط', 'Wallpaper', 4, 5),
('PAINTS1', 'دهانات', 'Paints', 4, 5),
('FLOORING', 'الأرضيات', 'Flooring', 5, 5),
('PAINTS2', 'الدهانات', 'Paints', 5, 5),
('PLUMBING', 'صحي', 'Plumbing', 5, 5),
('ELECTRICAL_SUPPLIES', 'مستلزمات الكهرباء', 'Electrical Supplies', 5, 5),
('WALLS', 'حوائط', 'Walls', 5, 5),
('CEILINGS', 'الاسقف', 'Ceilings', 5, 5),
('PLUMBING_SUPPLIES', 'مستلزمات سباكه', 'Plumbing Supplies', 5, 5),
('FINISHING_EQUIPMENT', 'معدات التشطيبات', 'Finishing Equipment', 5, 5),
('IRONWORKS', 'حدايد', 'Ironworks', 5, 5),
('ALUMINUM', 'الوميتال', 'Aluminum', 5, 5),
('WOOD_ALTERNATIVE', 'بديل خشب', 'Wood Alternative', 5, 5),
('MARBLE_ALTERNATIVE', 'بديل رخام', 'Marble Alternative', 5, 5),
('GLASS', 'زجاج', 'Glass', 5, 5),
('MARBLE', 'رخام', 'Marble', 5, 5),
('SMART_HOME', 'سمارت هوم', 'Smart Home', 5, 5),
('INTERIOR_DOORS', 'الابواب الداخليه', 'Interior Doors', 6, 5),
('EXTERIOR_DOORS', 'الابواب الخارجيه', 'Exterior Doors', 6, 5),
('LIGHTING', 'الاضاءه', 'Lighting', 7, 5),
('ALUMINUM_DOORS', 'الالوميتال', 'Aluminum Doors', 8, 5),
('FABRICS_AND_UPHOLSTERY', 'الاقمشه والمفروشات', 'Fabrics and Upholstery', 9, 5),
('HOME_APPLIANCES', 'الاجهزة المنزليه', 'Home Appliances', 10, 5),
('HANDICRAFTS', 'الصناعات اليدويه', 'Handicrafts', 11, 5),
('SWIMMING_POOLS', 'حمامات السباحه', 'Swimming Pools', 12, 5),
('WOOD_CUTTING', 'تقطيع اخشاب', 'Wood Cutting', 13, 5),
('FIRE_SYSTEMS', 'نظام الاطفاء', 'Fire Systems', 14, 5),
('CONCRETE', 'خرسانه', 'Concrete', 15, 5),
('OTHER', 'اخري', 'other', null, 5);



CREATE TABLE if NOT EXISTS `fre_engineering_office`(
	  `id` BIGINT NOT NULL AUTO_INCREMENT,
	  `status_code` INT,
	  `created_date`   TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `trade_name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) ,
    `commercial_register_path` VARCHAR(255) NOT NULL,
	`tax_card_path` VARCHAR(255) NOT NULL,
    `personal_card_path` VARCHAR(255) NOT NULL,
    `user_id` BIGINT NOT NULL,
    `fields_id` INT NOT NULL,
    CONSTRAINT `fk_user_74165` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
	CONSTRAINT `fk_engineering_offices_fields_8456` FOREIGN KEY (`fields_id`) REFERENCES `fre_engineering_offices_fields_lkp`(`id`),
    PRIMARY KEY (`id`)
    )auto_increment=1,engine=InnoDB;


    CREATE TABLE fre_engineering_office_department (
                                      engineering_office_id BIGINT NOT NULL,
                                      department_id INT NOT NULL,
                                      PRIMARY KEY (engineering_office_id, department_id),
                                      CONSTRAINT fk_engineering_office_218 FOREIGN KEY (engineering_office_id) REFERENCES fre_engineering_office(id) ON DELETE CASCADE,
                                      CONSTRAINT fk_fre_engineering_office_departments_65423 FOREIGN KEY (department_id) REFERENCES fre_engineering_office_departments_lkp(id) ON DELETE CASCADE,
                                      CONSTRAINT unique_engineering_department_2465421 UNIQUE (engineering_office_id, department_id)
);

