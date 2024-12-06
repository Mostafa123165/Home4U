ALTER TABLE engineer RENAME TO fre_engineer;

ALTER TABLE technical_worker RENAME TO fre_technical_worker;

ALTER TABLE engineer_type_lkp RENAME TO fre_engineer_type_lkp;

ALTER TABLE technical_worker_type_lkp RENAME TO fre_technical_worker_type_lkp;

INSERT INTO home4u.fre_engineer_type_lkp (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('CIVIL_ENGINEER', 'مهندس مدني', 'Civil Engineer', 5),
    ('MECHANICAL_ENGINEER', 'مهندس ميكانيكا', 'Mechanical Engineer', 5),
    ('PLUMBING_ENGINEER', 'مهندس شبكات المياه والصرف', 'Plumbing Engineer', 5),
    ('FINISHING_ENGINEER', 'مهندس تشطيبات', 'Finishing Engineer', 5),
    ('SURVEYOR', 'مهندس مساحة', 'Surveyor', 5),
    ('PROJECT_MANAGER', 'مهندس إدارة المشاريع', 'Project Manager', 5),
    ('ENVIRONMENTAL_ENGINEER', 'مهندس بيئة', 'Environmental Engineer', 5),
    ('LANDSCAPE_ARCHITECT', 'مهندس حدائق', 'Landscape Architect', 5);



DROP TABLE IF EXISTS `fre_engineer_service_lkp`;
CREATE TABLE IF NOT EXISTS `home4u`.`fre_engineer_service_lkp` (
                                                                   `id` INTEGER NOT NULL AUTO_INCREMENT,
                                                                   `code` VARCHAR(70) NOT NULL,
    `name_ar` VARCHAR(150) NOT NULL,
    `name_en` VARCHAR(150) NOT NULL,
    `engineer_id` INT,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY (`code`),
    PRIMARY KEY (`id`),
    CONSTRAINT fk_engineer1 FOREIGN KEY (engineer_id) REFERENCES fre_engineer_type_lkp(id)
    ) AUTO_INCREMENT=1, ENGINE=InnoDB;

INSERT INTO fre_engineer_service_lkp (code, name_ar, name_en, engineer_id, status_code) VALUES
('CIVIL_ENGINEERING_DESIGN_4', 'تصميم هندسي', 'Civil Engineering Design', 4, 5),
('STRUCTURAL_DESIGN_4', 'تصميم إنشائي', 'Structural Design', 4, 5),
('SURVEYING_4', 'المساحة', 'Surveying', 4, 5),
('SOIL_ANALYSIS_SERVICES_4', 'تحليل التربة', 'Soil Analysis Services', 4, 5),
('CONCRETE_ENGINEERING_4', 'هندسة الخرسانة', 'Concrete Engineering', 4, 5),
('CONSTRUCTION_PROJECT_MANAGEMENT_4', 'إدارة مشاريع البناء', 'Construction Project Management', 4, 5),
('RENOVATION_SERVICES_4', 'التجديدات', 'Renovation Services', 4, 5),

('HVAC_SERVICES_5', 'أنظمة التكييف', 'HVAC Services', 5, 5),
('VENTILATION_SYSTEM_5', 'نظام التهوية', 'Ventilation System', 5, 5),
('FIRE_PROTECTION_5', 'الحماية من الحريق', 'Fire Protection', 5, 5),
('RENEWABLE_ENERGY_CONSULTANCY_5', 'استشارات الطاقة المتجددة', 'Renewable Energy Consultancy', 5, 5),
('INSULATION_SERVICES_5', 'خدمات العزل', 'Insulation Services', 5, 5),
('SMART_BUILDING_SOLUTIONS_5', 'حلول المباني الذكية', 'Smart Building Solutions', 5, 5),

('PLUMBING_DESIGN+6', 'تصميم السباكة', 'Plumbing Design', 6, 5),
('FIRE_PROTECTION_6', 'الحماية من الحريق', 'Fire Protection', 6, 5),
('ENVIRONMENTAL_SERVICES_6', 'الخدمات البيئية', 'Environmental Services', 6, 5),
('RENOVATION_SERVICES_6', 'التجديدات', 'Renovation Services', 6, 5),
('INSULATION_SERVICES_6', 'خدمات العزل', 'Insulation Services', 6, 5),

('FINISHING_WORK_7', 'أعمال التشطيبات', 'Finishing Work', 7, 5),
('RENOVATION_SERVICES_7', 'التجديدات', 'Renovation Services', 7, 5),
('INTERIOR_DESIGN_7', 'تصميم داخلي', 'Interior Design', 7, 5),
('LIGHTING_DESIGN_7', 'تصميم الإضاءة', 'Lighting Design', 7, 5),
('FURNITURE_DESIGN_&', 'تصميم الأثاث', 'Furniture Design', 7, 5),


('SURVEYING_8', 'المساحة', 'Surveying', 8, 5),
('SOIL_ANALYSIS_SERVICES_8', 'تحليل التربة', 'Soil Analysis Services', 8, 5),
('ENVIRONMENTAL_SERVICES_8', 'الخدمات البيئية', 'Environmental Services', 8, 5),
('LANDSCAPING_SERVICES_8', 'تنسيق الحدائق', 'Landscaping Services', 8, 5),
('CONSTRUCTION_MANAGEMENT_8', 'إدارة البناء', 'Construction Management', 8, 5),


('PROJECT_MANAGEMENT_9', 'إدارة المشاريع', 'Project Management', 9, 5),
('CONSTRUCTION_MANAGEMENT_9', 'إدارة البناء', 'Construction Management', 9, 5),
('QUALITY_CONTROL_SERVICES_9', 'خدمات مراقبة الجودة', 'Quality Control Services', 9, 5),
('ENGINEERING_CONSULTANCY_9', 'الاستشارات الهندسية', 'Engineering Consultancy', 9, 5),
('ENVIRONMENTAL_BUILDING_MANAGEMENT_9', 'إدارة المباني البيئية', 'Environmental Building Management', 9, 5),


('ENVIRONMENTAL_SERVICES_10', 'الخدمات البيئية', 'Environmental Services', 10, 5),
('RENEWABLE_ENERGY_CONSULTANCY_10', 'استشارات الطاقة المتجددة', 'Renewable Energy Consultancy', 10, 5),
('ENVIRONMENTAL_BUILDING_MANAGEMENT_10', 'إدارة المباني البيئية', 'Environmental Building Management', 10, 5),
('SOIL_ANALYSIS_SERVICES_10', 'تحليل التربة', 'Soil Analysis Services', 10, 5),
('LANDSCAPING_SERVICES_10', 'تنسيق الحدائق', 'Landscaping Services', 10, 5),


('LANDSCAPING_SERVICES_11', 'تنسيق الحدائق', 'Landscaping Services', 11, 5),
('VERTICAL_FARMING_SERVICES_11', 'خدمات الزراعة العمودية', 'Vertical Farming Services', 11, 5),
('ENVIRONMENTAL_SERVICES_11', 'الخدمات البيئية', 'Environmental Services', 11, 5),
('SMART_BUILDING_SOLUTIONS_11', 'حلول المباني الذكية', 'Smart Building Solutions', 11, 5),


('ELECTRICAL_DESIGN_1', 'تصميم كهربائي', 'Electrical Design', 1, 5),
('ELECTRICAL_NETWORK_DESIGN_1', 'تصميم شبكات الكهرباء', 'Electrical Network Design', 1, 5),
('LIGHTING_DESIGN_1', 'تصميم الإضاءة', 'Lighting Design', 1, 5),
('SECURITY_SYSTEMS_1', 'أنظمة الأمان', 'Security Systems', 1, 5),
('SMART_BUILDING_SOLUTIONS_1', 'حلول المباني الذكية', 'Smart Building Solutions', 1, 5),


('INTERIOR_DESIGN_2', 'تصميم داخلي', 'Interior Design', 2, 5),
('FURNITURE_DESIGN_2', 'تصميم الأثاث', 'Furniture Design', 2, 5),
('LIGHTING_DESIGN_2', 'تصميم الإضاءة', 'Lighting Design', 2, 5),
('LUXURY_FURNITURE_SERVICES_2', 'خدمات الأثاث الفاخر', 'Luxury Furniture Services', 2, 5),


('ARCHITECTURAL_DESIGN_3', 'تصميم معماري', 'Architectural Design', 3, 5),
('INTERIOR_DESIGN_3', 'تصميم داخلي', 'Interior Design', 3, 5),
('EXTERIOR_DESIGN_3', 'تصميم خارجي', 'Exterior Design', 3, 5),
('COMMERCIAL_ARCHITECTURAL_DESIGN_3', 'تصميم معماري تجاري', 'Commercial Architectural Design', 3, 5),
('ACOUSTIC_DESIGN_3', 'تصميم الصوتيات', 'Acoustic Design', 3, 5),
('OTHER', 'أخرى', 'other',null, 5);



INSERT INTO `fre_technical_worker_type_lkp` (`code`, `name_ar`, `name_en`, `status_code`)
VALUES
    ('MASON', 'عامل بناء', 'Mason', 5),
    ('INTERIOR_CARPENTER', 'نجار داخلي', 'Interior Carpenter', 5),
    ('FLOORING_WORKER', 'عامل أرضيات', 'Flooring Worker', 5),
    ('ROOFER', 'عامل سقف', 'Roofer', 5),
    ('HVAC_TECHNICIAN', 'عامل التدفئة والتهوية', 'HVAC Technician', 5),
    ('INSULATION_WORKER', 'عامل عزل', 'Insulation Worker', 5),
    ('CONCRETE_WORKER', 'عامل خرسانة', 'Concrete Worker', 5),
    ('GYPSUM_WORKER', 'عامل جبس', 'Gypsum Worker', 5),
    ('GLASS_INSTALLER', 'عامل تركيب زجاج', 'Glass Installer', 5),
    ('DOOR_INSTALLER', 'عامل تركيب أبواب', 'Door Installer', 5),
    ('RENOVATION_WORKER', 'عامل ترميم', 'Renovation Worker', 5),
    ('ACOUSTIC_WORKER', 'عامل عزل صوتي', 'Acoustic Worker', 5),
    ('DECORATIVE_FINISH_WORKER', 'عامل تشطيب زخرفي', 'Decorative Finish Worker', 5);




DROP TABLE IF EXISTS `home4u`.`fre_technical_worker_service_lkp`;
CREATE TABLE IF NOT EXISTS `home4u`.`fre_technical_worker_service_lkp` (
                                                                           `id` INTEGER NOT NULL AUTO_INCREMENT,
                                                                           `code` VARCHAR(70) NOT NULL,
    `name_ar` VARCHAR(150) NOT NULL,
    `name_en` VARCHAR(150) NOT NULL,
    `worker_id` INT,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY (`code`),
    PRIMARY KEY (`id`),
    CONSTRAINT fk_worker FOREIGN KEY (worker_id) REFERENCES fre_technical_worker_type_lkp(id)
    ) AUTO_INCREMENT=1, ENGINE=InnoDB;

INSERT INTO `home4u`.`fre_technical_worker_service_lkp` (`code`, `name_ar`, `name_en`, `worker_id`, `status_code`) VALUES
    ('PLUMBING_INSTALLATION', 'تركيب السباكة', 'Plumbing Installation', 1, 5),
    ('PLUMBING_REPAIR', 'إصلاح السباكة', 'Plumbing Repair', 1, 5),
    ('SEWERAGE_SYSTEM', 'نظام المجاري', 'Sewerage System', 1, 5),

    ('FURNITURE_MANUFACTURING', 'تصنيع الأثاث', 'Furniture Manufacturing', 2, 5),
    ('DOOR_WINDOW_INSTALLATION', 'تركيب الأبواب والنوافذ', 'Door and Window Installation', 2, 5),
    ('CABINET_INSTALLATION', 'تركيب الخزائن', 'Cabinet Installation', 2, 5),

    ('INTERIOR_PAINTING', 'الطلاء الداخلي', 'Interior Painting', 3, 5),
    ('EXTERIOR_PAINTING', 'الطلاء الخارجي', 'Exterior Painting', 3, 5),
    ('DECORATIVE_PAINTING', 'الطلاء الزخرفي', 'Decorative Painting', 3, 5),

    ('FLOOR_TILE_INSTALLATION', 'تركيب بلاط الأرضيات', 'Floor Tile Installation', 4, 5),
    ('WALL_TILE_INSTALLATION', 'تركيب بلاط الجدران', 'Wall Tile Installation', 4, 5),
    ('TILE_REPAIR', 'إصلاح البلاط', 'Tile Repair', 4, 5),

    ('WALL_PLASTERING', 'محارة الجدران', 'Wall Plastering', 5, 5),
    ('CEILING_PLASTERING', 'محارة الأسقف', 'Ceiling Plastering', 5, 5),
    ('DECORATIVE_PLASTERING', 'المحارة الزخرفية', 'Decorative Plastering', 5, 5),

    ('ELECTRICAL_WIRING', 'الأسلاك الكهربائية', 'Electrical Wiring', 6, 5),
    ('LIGHTING_INSTALLATION', 'تركيب الإضاءة', 'Lighting Installation', 6, 5),
    ('SECURITY_SYSTEM', 'أنظمة الأمان', 'Security System', 6, 5),

    ('STEEL_FRAME_INSTALLATION', 'تركيب الإطار الفولاذي', 'Steel Frame Installation', 7, 5),
    ('WELDING_SERVICES', 'خدمات اللحام', 'Welding Services', 7, 5),
    ('METALWORK', 'أعمال المعادن', 'Metalwork', 7, 5),

    ('BRICKWORK', 'أعمال بلاط للطوب', 'Brickwork', 9, 5),
    ('FOUNDATION_WORK', 'أعمال الأساسات', 'Foundation Work', 9, 5),
    ('MASONRY_REPAIR', 'إصلاح الطوب', 'Masonry Repair', 9, 5),

    ('INTERIOR_FURNITURE_DESIGN', 'تصميم الأثاث الداخلي', 'Interior Furniture Design', 10, 5),
    ('CUSTOM_CARPENTRY', 'النجارة المخصصة', 'Custom Carpentry', 10, 5),
    ('CABINET_INSTALLATION_INTERIOR', 'تركيب الخزائن الداخلية', 'Interior Cabinet Installation', 10, 5),

    ('FLOORING_INSTALLATION', 'تركيب بلاط الأرضيات', 'Flooring Installation', 11, 5),
    ('WOODEN_FLOOR_INSTALLATION', 'تركيب الأرضيات الخشبية', 'Wooden Floor Installation', 11, 5),
    ('FLOOR_REPAIR', 'إصلاح الأرضيات', 'Floor Repair', 11, 5),

    ('ROOF_REPAIR', 'إصلاح السقف', 'Roof Repair', 12, 5),
    ('ROOF_INSTALLATION', 'تركيب السقف', 'Roof Installation', 12, 5),
    ('ROOF_WATERPROOFING', 'العزل المائي للسقف', 'Roof Waterproofing', 12, 5),

    ('HVAC_INSTALLATION', 'تركيب HVAC', 'HVAC Installation', 13, 5),
    ('HVAC_MAINTENANCE', 'صيانة HVAC', 'HVAC Maintenance', 13, 5),
    ('AIR_DUCT_SERVICES', 'أعمال مجاري الهواء', 'Air Duct Services', 13, 5),

    ('THERMAL_INSULATION', 'العزل الحراري', 'Thermal Insulation', 14, 5),
    ('SOUND_INSULATION', 'العزل الصوتي', 'Sound Insulation', 14, 5),
    ('INSULATION_REPAIR', 'إصلاح العزل', 'Insulation Repair', 14, 5),

    ('CONCRETE_FORMING', 'صب الخرسانة', 'Concrete Forming', 15, 5),
    ('CONCRETE_REPAIR', 'إصلاح الخرسانة', 'Concrete Repair', 15, 5),
    ('CONCRETE_FOUNDATION', 'أعمال الأساسات الخرسانية', 'Concrete Foundation Work', 15, 5),

    ('GYPSUM_PLASTERING', 'محارة جبس', 'Gypsum Plastering', 16, 5),
    ('DECORATIVE_GYPSUM', 'أعمال زخرفية جبسية', 'Decorative Gypsum Work', 16, 5),

    ('GLASS_INSTALLATION', 'تركيب الزجاج', 'Glass Installation', 17, 5),
    ('GLASS_REPAIR', 'إصلاح الزجاج', 'Glass Repair', 17, 5),

    ('DOOR_INSTALLATION', 'تركيب الأبواب', 'Door Installation', 18, 5),
    ('DOOR_REPAIR', 'إصلاح الأبواب', 'Door Repair', 18, 5),

    ('RENOVATION_SERVICES', 'خدمات الترميم', 'Renovation Services', 19, 5),
    ('RENOVATION_REPAIR', 'إصلاح الترميم', 'Renovation Repair', 19, 5),

    ('SOUND_INSULATION_WORK', 'العزل الصوتي', 'Sound Insulation Work', 20, 5),

    ('DECORATIVE_FINISHING', 'التشطيب الزخرفي', 'Decorative Finishing', 21, 5),
    ('OTHER', 'أخرى', 'other',null, 5);



CREATE TABLE fre_engineer_service (
                                      engineer_id BIGINT NOT NULL,
                                      service_id INT NOT NULL,
                                      PRIMARY KEY (engineer_id, service_id),
                                      CONSTRAINT fre_fk_engineer FOREIGN KEY (engineer_id) REFERENCES fre_engineer(id) ON DELETE CASCADE,
                                      CONSTRAINT fre_fk_service FOREIGN KEY (service_id) REFERENCES fre_engineer_service_lkp(id) ON DELETE CASCADE,
                                      CONSTRAINT unique_engineer_service UNIQUE (engineer_id, service_id)
);

CREATE TABLE fre_worker_service (
                                    worker_id BIGINT NOT NULL,
                                    service_id INT NOT NULL,
                                    PRIMARY KEY (worker_id, service_id),
                                    CONSTRAINT fre_fk_worker FOREIGN KEY (worker_id) REFERENCES fre_technical_worker(id) ON DELETE CASCADE,
                                    CONSTRAINT fre_fk_service_worker FOREIGN KEY (service_id) REFERENCES fre_technical_worker_service_lkp(id) ON DELETE CASCADE,
                                    CONSTRAINT unique_worker_service UNIQUE (worker_id, service_id)
);

ALTER TABLE fre_technical_worker
    ADD COLUMN years_of_experience INT NOT NULL;

ALTER TABLE fre_engineer
    ADD COLUMN years_of_experience INT NOT NULL;



ALTER TABLE fre_engineer
    ADD COLUMN status_code INT DEFAULT 5,
ADD COLUMN created_date TIMESTAMP,
ADD COLUMN modified_date TIMESTAMP;


ALTER TABLE fre_technical_worker
    ADD COLUMN status_code INT DEFAULT 5,
ADD COLUMN created_date TIMESTAMP,
ADD COLUMN modified_date TIMESTAMP;









