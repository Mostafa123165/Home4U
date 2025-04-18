DROP TABLE IF EXISTS `fre_home_renovate`;
DROP TABLE IF EXISTS `fre_select_custom_package`;
DROP TABLE IF EXISTS `fre_custom_package`;
DROP TABLE IF EXISTS `fre_request_design`;
DROP TABLE IF EXISTS `fre_ask_worker_photos`;
DROP TABLE IF EXISTS `fre_ask_engineer_photos`;

DROP TABLE IF EXISTS `fre_ask_engineer`;
DROP TABLE IF EXISTS `fre_ask_worker`;

DROP TABLE IF EXISTS `fre_unit_types_lkp`;
CREATE TABLE if NOT EXISTS `fre_unit_types_lkp`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `code`
    VARCHAR
(
    70
) NOT NULL,
    `name_ar` VARCHAR
(
    70
) NOT NULL,
    `name_en` VARCHAR
(
    70
) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY
(
    `code`
),
    PRIMARY KEY
(
    `id`
)
    ) auto_increment=1,engine=InnoDB;
INSERT INTO fre_unit_types_lkp (code, name_ar, name_en, status_code)
VALUES ('APARTMENT', 'شقة', 'Apartment', 5),
       ('VILLA', 'فيلا', 'Villa', 5),
       ('DUPLEX', 'دوبلكس', 'Duplex', 5),
       ('STUDIO', 'استوديو', 'Studio', 5),
       ('PENTHOUSE', 'بنتهاوس', 'Penthouse', 5),
       ('TOWNHOUSE', 'تاون هاوس', 'Townhouse', 5),
       ('FULL FLOOR', 'طابق كامل', 'Full Floor', 5),
       ('ROOF UNIT', 'روف', 'Roof Unit', 5),
       ('LOFT', 'لوفت', 'Loft', 5);

DROP TABLE IF EXISTS `fre_unit_work_types_lkp`;
CREATE TABLE if NOT EXISTS `fre_unit_work_types_lkp`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `code`
    VARCHAR
(
    70
) NOT NULL,
    `name_ar` VARCHAR
(
    70
) NOT NULL,
    `name_en` VARCHAR
(
    70
) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY
(
    `code`
),
    PRIMARY KEY
(
    `id`
)
    ) auto_increment=1,engine=InnoDB;
INSERT INTO fre_unit_work_types_lkp (code, name_ar, name_en, status_code)
VALUES ('CONSTRUCTION', 'الأعمال الإنشائية', 'Construction Works', 5),
       ('FINISHING', 'أعمال التشطيب', 'Finishing Works', 5),
       ('ELECTROMECH', 'الأعمال الكهروميكانيكية', 'Electromechanical Works', 5),
       ('FACADE', 'أعمال الواجهات', 'Façade Works', 5),
       ('RENOVATION', 'أعمال الترميم والصيانة', 'Renovation & Maintenance', 5);

DROP TABLE IF EXISTS `fre_work_skills_lkp`;
CREATE TABLE if NOT EXISTS `fre_work_skills_lkp`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `code`
    VARCHAR
(
    70
) NOT NULL,
    `name_ar` VARCHAR
(
    70
) NOT NULL,
    `name_en` VARCHAR
(
    70
) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY
(
    `code`
),
    PRIMARY KEY
(
    `id`
)
    ) auto_increment=1,engine=InnoDB;
INSERT INTO fre_work_skills_lkp (code, name_ar, name_en, status_code)
VALUES ('FAST_EXECUTION', 'سرعة التنفيذ', 'Fast Execution', 5),
       ('MATERIAL_EFFICIENCY', 'كفاءة استخدام المواد', 'Material Efficiency', 5),
       ('INNOVATIVE_DESIGN', 'تصاميم مبتكرة', 'Innovative Design', 5),
       ('TIME_COMMITMENT', 'الالتزام بالمواعيد', 'Time Commitment', 5),
       ('QUALITY_FINISHING', 'تشطيب عالي الجودة', 'High Quality Finishing', 5),
       ('TEAMWORK', 'العمل الجماعي', 'Teamwork', 5),
       ('PROBLEM_SOLVING', 'حل المشكلات', 'Problem Solving', 5),
       ('COST_EFFICIENCY', 'تقليل التكاليف', 'Cost Efficiency', 5),
       ('CLIENT_ORIENTATION', 'التركيز على رضا العميل', 'Client Orientation', 5),
       ('FLEXIBILITY', 'المرونة والتكيف', 'Flexibility & Adaptability', 5);

DROP TABLE IF EXISTS `fre_unit_statuses_lkp`;
CREATE TABLE if NOT EXISTS `fre_unit_statuses_lkp`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `code`
    VARCHAR
(
    70
) NOT NULL,
    `name_ar` VARCHAR
(
    70
) NOT NULL,
    `name_en` VARCHAR
(
    70
) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY
(
    `code`
),
    PRIMARY KEY
(
    `id`
)
    ) auto_increment=1,engine=InnoDB;
INSERT INTO fre_unit_statuses_lkp (code, name_ar, name_en, status_code)
VALUES ('NEEDS_FULL_FINISHING', 'تحتاج تشطيب كامل', 'Needs Full Finishing', 5),
       ('HALF_FINISHED', 'نصف تشطيب', 'Half Finished', 5),
       ('NEEDS_REPAIR', 'تحتاج تصليحات', 'Needs Repair', 5),
       ('UNDER_CONSTRUCTION', 'تحت الإنشاء', 'Under Construction', 5),
       ('IN_PROGRESS', 'في قيد التنفيذ', 'In Progress', 5);

DROP TABLE IF EXISTS `fre_urgency_level_lkp`;
CREATE TABLE if NOT EXISTS `fre_urgency_level_lkp`
(
    `id`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `code`
    VARCHAR
(
    70
) NOT NULL,
    `name_ar` VARCHAR
(
    70
) NOT NULL,
    `name_en` VARCHAR
(
    70
) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    UNIQUE KEY
(
    `code`
),
    PRIMARY KEY
(
    `id`
)
    ) auto_increment=1,engine=InnoDB;
INSERT INTO fre_urgency_level_lkp (code, name_ar, name_en, status_code)
VALUES ('LOW', 'منخفض', 'Low', 1),
       ('MEDIUM', 'متوسط', 'Medium', 1),
       ('HIGH', 'عالي', 'High', 1),
       ('URGENT', 'عاجل', 'Urgent', 1);

CREATE TABLE fre_home_renovate
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    phone_number        VARCHAR(255),
    is_inside_compound  BOOLEAN,
    unit_type_id        INT    NOT NULL,
    user_id             BIGINT NOT NULL,
    unit_work_types_id  INT    NOT NULL,
    work_skills_id      INT    NOT NULL,
    unit_statuses_id    INT    NOT NULL,
    city_id             INT    NOT NULL,
    governorate_id      INT    NOT NULL,
    unit_area           BIGINT,
    budget              BIGINT,
    region              BIGINT,
    number_of_rooms     BIGINT,
    number_of_bathrooms BIGINT,
    required_duration   BIGINT,
    notes               VARCHAR(255),
    status_code         INT       DEFAULT 5,
    created_date        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_unit_type FOREIGN KEY (unit_type_id) REFERENCES fre_unit_types_lkp (id),
    CONSTRAINT fk_unit_work_type FOREIGN KEY (unit_work_types_id) REFERENCES fre_unit_work_types_lkp (id),
    CONSTRAINT fk_work_skills FOREIGN KEY (work_skills_id) REFERENCES fre_work_skills_lkp (id),
    CONSTRAINT fk_unit_statuses FOREIGN KEY (unit_statuses_id) REFERENCES fre_unit_statuses_lkp (id),
    CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES city_lkp (id),
    CONSTRAINT fk_governorate FOREIGN KEY (governorate_id) REFERENCES governorate_lkp (id),
    CONSTRAINT fk_user_id1 FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE fre_request_design
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    phone_number      VARCHAR(255),
    unit_type_id      INT    NOT NULL,
    user_id           BIGINT NOT NULL,
    governorate_id    INT    NOT NULL,
    unit_area         BIGINT,
    budget            BIGINT,
    required_duration BIGINT,
    notes             VARCHAR(255),
    status_code       INT       DEFAULT 5,
    created_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_unit_type1 FOREIGN KEY (unit_type_id) REFERENCES fre_unit_types_lkp (id),
    CONSTRAINT fk_governorate1 FOREIGN KEY (governorate_id) REFERENCES governorate_lkp (id),
    CONSTRAINT fk_user_id3 FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE fre_custom_package
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id       BIGINT       NOT NULL,
    name_ar       VARCHAR(255) NOT NULL,
    name_en       VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    details_ar    TEXT,
    details_en    TEXT,
    status_code   INT       DEFAULT 5,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_id2 FOREIGN KEY (user_id) REFERENCES user (id)
);
INSERT INTO fre_custom_package (user_id, name_ar, name_en, price, details_ar, details_en, status_code)
VALUES ((SELECT s.id FROM user s WHERE s.user_type_id = 8 LIMIT 1), 'الباقة الماسية', 'Diamond Package', 11000.00, '<h3>الكهرباء:</h3><ul><li>سلك شنايدر أو سويدي أصلي</li><li>علب ماجيك</li><li>مفاتيح و برايز فينوس أو سانشي أو بيتشينو</li><li>لوحة رئيسية 36 خط</li><li>دائرة دش و انترنت لجميع الفراغات</li><li>ديفيتير لجميع الفراغات</li><li>تأسيس تكيفات لكامل الوحدة</li><li>ليد و سبوتات لجميع الفراغات</li><li>ليد بروفايل لجميع الفراغات</li><li>تأسيس كاميرات</li><li>توريد و تركيب كاميرات لجميع الفراغات USB</li></ul><h3>السباكة:</h3><ul><li>صرف كاسيل الماني</li><li>التغذية BR</li><li>عزل الحمام اسمنتي</li><li>خلاط دفن للشاور لجميع الحمامات</li><li>قاعدة دفن لجميع الحمامات</li><li>أرضية رخام للشاور و بانيو شاسيه</li><li>كابينه زجاج مفصلي لجميع الحمامات أو كابينه أيديال</li><li>صحي و خلاطات أيديال أو جروهي</li><li>أحواض رخام للحمامات + وحدات ادراج</li><li>بانيو جاكوزي لحمام الماستر</li></ul><h3>الدهانات:</h3><ul><li>وش سلير</li><li>سكينة معجون</li><li>بطانة + تلقيط</li><li>الحذاء النهائي</li></ul><h3>الأسقف:</h3><ul><li>جيبسوم بورد للوحدة بالكامل</li><li>جيبسوم بورد أحمر للمطبخ</li><li>جيبسوم بورد أخضر للحمام</li><li>خشب CNC لأي فراغ حسب اختيار العميل</li></ul><h3>السيراميك:</h3><ul><li>الريسبشن و الطرقة رخام مستورد (كراره أو امبرادور أو بريشيا)</li><li>الغرف سيراميك أو بروسلين مستورد من اختيار العميل</li><li>المطبخ والحمامات رخام (كراره أو امبرادور أو بريشيا أو ما يعادلهم)</li></ul>', '<h3>Electrical:</h3><ul><li>Original Schneider or Swedish wire</li><li>Magic boxes</li><li>Venus or Sanchi or Bitchino switches and sockets</li><li>Main panel 36 lines</li><li>Satellite and internet circuit for all areas</li><li>Deverter for all areas</li><li>Air conditioning foundation for the entire unit</li><li>LED and spotlights for all areas</li><li>LED profile for all areas</li><li>Camera foundation</li><li>Supplying and installing cameras for all areas USB</li></ul><h3>Plumbing:</h3><ul><li>Cassell German drainage</li><li>BR feeding</li><li>Cement bathroom insulation</li><li>Shower buried faucets for all bathrooms</li><li>Buried base for all bathrooms</li><li>Marble shower floors and bathtub frame</li><li>Hinged glass cabin for all bathrooms or Ideal cabin</li><li>Ideal or Grohe sanitary and faucets</li><li>Marble sinks for bathrooms + storage units</li><li>Jacuzzi bathtub for the master bathroom</li></ul><h3>Paints:</h3><ul><li>Primer</li><li>Putty knife</li><li>Base coat + finishing</li><li>Final shoe</li></ul><h3>Ceilings:</h3><ul><li>Gypsum board for the entire unit</li><li>Red gypsum board for the kitchen</li><li>Green gypsum board for the bathroom</li><li>CNC wood for any area according to client choice</li></ul><h3>Ceramics:</h3><ul><li>Reception and corridor imported marble (Kara, Ambrador, or Brescia)</li><li>Rooms ceramic or porcelain imported from client’s choice</li><li>Kitchen and bathrooms marble (Kara, Ambrador, or Brescia or equivalent)</li></ul>', 5),

( (SELECT s.id FROM user s WHERE s.user_type_id = 8 LIMIT 1),'الباقة الفضية', 'Silver Package', 8500.00,
'<h3>الكهرباء:</h3><ul><li>سلك شنايدر أو سويدي أصلي</li><li>علب ماجيك</li><li>مفاتيح و برايز فينوس أو سانشي</li><li>لوحة رئيسية 30 خط</li><li>دائرة دش و انترنت لبعض الفراغات</li><li>ديفيتير لبعض الفراغات</li></ul><h3>السباكة:</h3><ul><li>صرف كاسيل الماني</li><li>التغذية BR</li><li>عزل الحمام اسمنتي</li><li>خلاط دفن للشاور لبعض الحمامات</li><li>قاعدة دفن لبعض الحمامات</li></ul><h3>الدهانات:</h3><ul><li>وش سلير</li><li>سكينة معجون</li><li>بطانة + تلقيط</li></ul><h3>الأسقف:</h3><ul><li>جيبسوم بورد للوحدة بالكامل</li><li>خشب CNC لبعض الفراغات</li></ul><h3>السيراميك:</h3><ul><li>الريسبشن رخام مستورد (كراره أو امبرادور)</li><li>الغرف سيراميك أو بروسلين مستورد من اختيار العميل</li><li>المطبخ والحمامات رخام (كراره أو امبرادور أو بريشيا أو ما يعادلهم)</li></ul>',
'<h3>Electrical:</h3><ul><li>Original Schneider or Swedish wire</li><li>Magic boxes</li><li>Venus or Sanchi switches and sockets</li><li>Main panel 30 lines</li><li>Satellite and internet circuit for some areas</li><li>Deverter for some areas</li></ul><h3>Plumbing:</h3><ul><li>Cassell German drainage</li><li>BR feeding</li><li>Cement bathroom insulation</li><li>Shower buried faucets for some bathrooms</li><li>Buried base for some bathrooms</li></ul><h3>Paints:</h3><ul><li>Primer</li><li>Putty knife</li><li>Base coat + finishing</li></ul><h3>Ceilings:</h3><ul><li>Gypsum board for the entire unit</li><li>CNC wood for some areas</li></ul><h3>Ceramics:</h3><ul><li>Reception imported marble (Kara or Ambrador)</li><li>Rooms ceramic or porcelain imported from client’s choice</li><li>Kitchen and bathrooms marble (Kara, Ambrador, or Brescia or equivalent)</li></ul>',5),

( (SELECT s.id FROM user s WHERE s.user_type_id = 8 LIMIT 1),'الباقة البرونزية', 'Bronze Package', 5500.00,
'<h3>الكهرباء:</h3><ul><li>سلك فينوس</li><li>علب ماجيك</li><li>مفاتيح و برايز فينوس</li><li>دائرة دش و انترنت لبعض الفراغات</li></ul><h3>السباكة:</h3><ul><li>صرف كاسيل الماني</li><li>التغذية BR</li><li>عزل الحمام اسمنتي</li><li>خلاط دفن للشاور لبعض الحمامات</li></ul><h3>الدهانات:</h3><ul><li>وش سلير</li><li>سكينة معجون</li></ul><h3>الأسقف:</h3><ul><li>جيبسوم بورد للمطبخ</li></ul><h3>السيراميك:</h3><ul><li>الريسبشن سيراميك أو بروسلين</li></ul>',
'<h3>Electrical:</h3><ul><li>Venus wire</li><li>Magic boxes</li><li>Venus switches and sockets</li><li>Satellite and internet circuit for some areas</li></ul><h3>Plumbing:</h3><ul><li>Cassell German drainage</li><li>BR feeding</li><li>Cement bathroom insulation</li><li>Shower buried faucets for some bathrooms</li></ul><h3>Paints:</h3><ul><li>Primer</li><li>Putty knife</li></ul><h3>Ceilings:</h3><ul><li>Gypsum board for the kitchen</li></ul><h3>Ceramics:</h3><ul><li>Reception ceramic or porcelain</li></ul>',5),

( (SELECT s.id FROM user s WHERE s.user_type_id = 8 LIMIT 1),'الباقة الاقتصادية', 'Economic Package', 3000.00,
'<h3>الكهرباء:</h3><ul><li>سلك فينوس</li><li>مفاتيح و برايز فينوس</li></ul><h3>السباكة:</h3><ul><li>صرف كاسيل الماني</li></ul><h3>الدهانات:</h3><ul><li>وش سلير</li></ul><h3>الأسقف:</h3><ul><li>جيبسوم بورد للمطبخ</li></ul><h3>السيراميك:</h3><ul><li>الريسبشن سيراميك</li></ul>',
'<h3>Electrical:</h3><ul><li>Venus wire</li><li>Venus switches and sockets</li></ul><h3>Plumbing:</h3><ul><li>Cassell German drainage</li></ul><h3>Paints:</h3><ul><li>Primer</li></ul><h3>Ceilings:</h3><ul><li>Gypsum board for the kitchen</li></ul><h3>Ceramics:</h3><ul><li>Reception ceramic</li></ul>',5),

( (SELECT s.id FROM user s WHERE s.user_type_id = 8 LIMIT 1),'الباقة الذهبية', 'Gold Package', 14000.00,
'<h3>الكهرباء:</h3><ul><li>سلك شنايدر أو سويدي أصلي</li><li>علب ماجيك</li><li>مفاتيح و برايز فينوس أو سانشي أو بيتشينو</li><li>لوحة رئيسية 50 خط</li><li>دائرة دش و انترنت لجميع الفراغات</li><li>ديفيتير لجميع الفراغات</li><li>تأسيس تكيفات لكامل الوحدة</li><li>ليد و سبوتات لجميع الفراغات</li><li>ليد بروفايل لجميع الفراغات</li><li>تأسيس كاميرات</li><li>توريد و تركيب كاميرات لجميع الفراغات USB</li></ul><h3>السباكة:</h3><ul><li>صرف كاسيل الماني</li><li>التغذية BR</li><li>عزل الحمام اسمنتي</li><li>خلاط دفن للشاور لجميع الحمامات</li><li>قاعدة دفن لجميع الحمامات</li><li>أرضية رخام للشاور و بانيو شاسيه</li><li>كابينه زجاج مفصلي لجميع الحمامات أو كابينه أيديال</li><li>صحي و خلاطات أيديال أو جروهي</li><li>أحواض رخام للحمامات + وحدات ادراج</li><li>بانيو جاكوزي لحمام الماستر</li></ul><h3>الدهانات:</h3><ul><li>وش سلير</li><li>سكينة معجون</li><li>بطانة + تلقيط</li><li>الحذاء النهائي</li></ul><h3>الأسقف:</h3><ul><li>جيبسوم بورد للوحدة بالكامل</li><li>جيبسوم بورد أحمر للمطبخ</li><li>جيبسوم بورد أخضر للحمام</li><li>خشب CNC لأي فراغ حسب اختيار العميل</li></ul><h3>السيراميك:</h3><ul><li>الريسبشن و الطرقة رخام مستورد (كراره أو امبرادور أو بريشيا)</li><li>الغرف سيراميك أو بروسلين مستورد من اختيار العميل</li><li>المطبخ والحمامات رخام (كراره أو امبرادور أو بريشيا أو ما يعادلهم)</li></ul>',
'<h3>Electrical:</h3><ul><li>Original Schneider or Swedish wire</li><li>Magic boxes</li><li>Venus or Sanchi or Bitchino switches and sockets</li><li>Main panel 50 lines</li><li>Satellite and internet circuit for all areas</li><li>Deverter for all areas</li><li>Air conditioning foundation for the entire unit</li><li>LED and spotlights for all areas</li><li>LED profile for all areas</li><li>Camera foundation</li><li>Supplying and installing cameras for all areas USB</li></ul><h3>Plumbing:</h3><ul><li>Cassell German drainage</li><li>BR feeding</li><li>Cement bathroom insulation</li><li>Shower buried faucets for all bathrooms</li><li>Buried base for all bathrooms</li><li>Marble shower floors and bathtub frame</li><li>Hinged glass cabin for all bathrooms or Ideal cabin</li><li>Ideal or Grohe sanitary and faucets</li><li>Marble sinks for bathrooms + storage units</li><li>Jacuzzi bathtub for the master bathroom</li></ul><h3>Paints:</h3><ul><li>Primer</li><li>Putty knife</li><li>Base coat + finishing</li><li>Final shoe</li></ul><h3>Ceilings:</h3><ul><li>Gypsum board for the entire unit</li><li>Red gypsum board for the kitchen</li><li>Green gypsum board for the bathroom</li><li>CNC wood for any area according to client choice</li></ul><h3>Ceramics:</h3><ul><li>Reception and corridor imported marble (Kara, Ambrador, or Brescia)</li><li>Rooms ceramic or porcelain imported from client’s choice</li><li>Kitchen and bathrooms marble (Kara, Ambrador, or Brescia or equivalent)</li></ul>',5);

CREATE TABLE fre_select_custom_package
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id            BIGINT NOT NULL,
    phone_number       VARCHAR(255),
    is_inside_compound BOOLEAN,
    unit_type_id       INT    NOT NULL,
    custom_package_id  BIGINT NOT NULL,
    status_code        INT       DEFAULT 5,
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_unit_type2 FOREIGN KEY (unit_type_id) REFERENCES fre_unit_types_lkp (id),
    CONSTRAINT fk_custom_package1 FOREIGN KEY (custom_package_id) REFERENCES fre_custom_package (id),
    CONSTRAINT fk_user_id4 FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE fre_ask_engineer
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id             BIGINT       NOT NULL,
    phone_number        VARCHAR(255) NOT NULL,
    project_name        VARCHAR(255) NOT NULL,
    project_description VARCHAR(1000),
    engineer_type_id    INT          NOT NULL,
    unit_type_id        INT          NOT NULL,
    budget              BIGINT       NOT NULL,
    city_id             INT          NOT NULL,
    governorate_id      INT          NOT NULL,
    urgency_level_id    INT          NOT NULL,
    deadline            VARCHAR(255),
    status_code         INT       DEFAULT 5,
    created_date        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_unit_type3 FOREIGN KEY (unit_type_id) REFERENCES fre_unit_types_lkp (id),
    CONSTRAINT fk_engineer_type1 FOREIGN KEY (engineer_type_id) REFERENCES fre_engineer_type_lkp (id),
    CONSTRAINT fk_city5 FOREIGN KEY (city_id) REFERENCES city_lkp (id),
    CONSTRAINT fk_governorate5 FOREIGN KEY (governorate_id) REFERENCES governorate_lkp (id),
    CONSTRAINT fk_urgency_level FOREIGN KEY (urgency_level_id) REFERENCES fre_urgency_level_lkp (id),
    CONSTRAINT fk_user_id5 FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE fre_ask_worker
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id             BIGINT NOT NULL,
    project_name        VARCHAR(255),
    phone_number        VARCHAR(255),
    project_description VARCHAR(1000),
    worker_type_id      INT    NOT NULL,
    unit_type_id        INT    NOT NULL,
    city_id             INT    NOT NULL,
    governorate_id      INT    NOT NULL,
    material_id         INT    NOT NULL,
    budget              BIGINT,
    status_code         INT       DEFAULT 5,
    created_date        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_unit_type4 FOREIGN KEY (unit_type_id) REFERENCES fre_unit_types_lkp (id),
    CONSTRAINT fk_engineer_type6 FOREIGN KEY (worker_type_id) REFERENCES fre_technical_worker_type_lkp (id),
    CONSTRAINT fk_city6 FOREIGN KEY (city_id) REFERENCES city_lkp (id),
    CONSTRAINT fk_governorate6 FOREIGN KEY (governorate_id) REFERENCES governorate_lkp (id),
    CONSTRAINT fk_material1 FOREIGN KEY (material_id) REFERENCES product_material_lkp (id),
    CONSTRAINT fk_user_id8 FOREIGN KEY (user_id) REFERENCES user (id)
);


CREATE TABLE fre_ask_engineer_photos
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    ask_engineer_id BIGINT NOT NULL,
    photo_path      VARCHAR(255),
    CONSTRAINT fk_ask_engineer_id1 FOREIGN KEY (ask_engineer_id) REFERENCES fre_ask_engineer (id)
);

CREATE TABLE fre_ask_worker_photos
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    ask_worker_id BIGINT NOT NULL,
    photo_path    VARCHAR(255),
    CONSTRAINT fk_ask_worker_id1 FOREIGN KEY (ask_worker_id) REFERENCES fre_ask_worker (id)
);

INSERT INTO common_portal_config (created_date, modified_date, status_code, config_key, config_value)
VALUES (now(), now(), NULL, 'ASK_ENGINEER', 'ask/engineer/photo/'),
       (now(), now(), NULL, 'ASK_WORKER', 'asl/worker/photo/');
