DROP TABLE IF EXISTS `home_furnishing_request_type_lkp`;
CREATE TABLE IF NOT EXISTS home_furnishing_request_type_lkp (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

INSERT INTO home_furnishing_request_type_lkp (code, name_ar, name_en, status_code)
VALUES
    ('FURNISH_HOUSE', 'تأثيث منزل', 'Furnish House', 5),
    ('DRESSING_ROOM', 'غرفة ملابس', 'Dressing Room', 5),
    ('KITCHEN', 'مطبخ', 'Kitchen', 5);

DROP TABLE IF EXISTS `kitchen_type_lkp`;
CREATE TABLE IF NOT EXISTS kitchen_type_lkp (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

INSERT INTO kitchen_type_lkp (code, name_ar, name_en, status_code)
VALUES
    ('AMERICAN', 'مطبخ أمريكي', 'American Kitchen', 5),
    ('NORMAL', 'مطبخ عادي', 'Normal Kitchen', 5);


DROP TABLE IF EXISTS `devices_attached_lkp`;
CREATE TABLE IF NOT EXISTS devices_attached_lkp
(
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    PRIMARY KEY (id)
);

INSERT INTO devices_attached_lkp (code, name_ar, name_en, status_code)
VALUES
    ('FRIDGE', 'ثلاجة', 'Fridge', 5),
    ('OVEN', 'فرن', 'Oven', 5),
    ('MICROWAVE', 'ميكروويف', 'Microwave', 5),
    ('DISHWASHER', 'غسالة أطباق', 'Dishwasher', 5),
    ('COOKER', 'بوتاجاز', 'Cooker', 5),
    ('HOOD', 'شفاط', 'Hood', 5),
    ('FREEZER', 'فريزر', 'Freezer', 5),
    ('WASHING_MACHINE', 'غسالة ملابس', 'Washing Machine', 5);


DROP TABLE IF EXISTS `furniture_type_lkp`;
CREATE TABLE IF NOT EXISTS furniture_type_lkp (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

INSERT INTO furniture_type_lkp (code, name_ar, name_en, status_code)
VALUES
    ('MASTER_BEDROOM_SET', 'غرفة نوم كاملة - ماستر', 'Master bedroom set', 5),
    ('YOUTH_BEDROOM', 'غرفة نوم - شبابي', 'Youth bedroom', 5),
    ('CHILDREN_BEDROOM', 'غرفة نوم - اطفال', 'Children''s bedroom', 5),
    ('SEPARATE_BED', 'سرير منفصل', 'Separate bed', 5),
    ('WARDROBE', 'كمود', 'Wardrobe/Closet', 5),
    ('DESK', 'مكتب', 'Desk', 5),
    ('DRESSING_TABLE', 'تسريحة', 'Dressing table', 5),
    ('CABINET', 'دولاب', 'Cabinet', 5),
    ('COMPLETE_SOFA_SET', 'التربة كامل', 'Complete set: 3-seat + 2-seat + top', 5),
    ('TWO_SEAT_SOFA', 'كنية 2 مقعد', '2-seat', 5),
    ('THREE_SEAT_SOFA', 'كنية 3 مقعد', '3-seat', 5),
    ('TOP_PIECE', 'فوقية', 'Top piece', 5),
    ('L_SHAPED_SOFA', 'ركنة حرف ال 3x2', 'L-shaped 3x2 seating', 5),
    ('CENTER_TABLE', 'ترابيزة وسط', 'Center table', 5),
    ('SIDE_TABLE', 'ترابيزة جانية', 'Side table', 5),
    ('DINING_SET', 'سفره', 'Dining set', 5),
    ('DINING_SET_4', 'طاولة سفرة + 4 كراسي', 'Dining table + 4 chairs', 5),
    ('DINING_SET_6', 'طاولة سفرة + 6 كراسي', 'Dining table + 6 chairs', 5),
    ('DINING_SET_8', 'طاولة سفرة + 8 كراسي', 'Dining table + 8 chairs', 5);

