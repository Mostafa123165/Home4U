CREATE TABLE business_type_category_lkp
(
    `id`               BIGINT      NOT NULL AUTO_INCREMENT,
    `code`             VARCHAR(70) NOT NULL,
    `name_ar`          VARCHAR(70) NOT NULL,
    `name_en`          VARCHAR(70) NOT NULL,
    `status_code`      INTEGER     NOT NULL DEFAULT 5,
    `business_type_id` INT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (business_type_id) REFERENCES business_type_lkp (id)
);

ALTER TABLE products
ADD COLUMN business_type_category_id BIGINT ,
ADD CONSTRAINT FOREIGN KEY (business_type_category_id) REFERENCES business_type_category_lkp (id);


INSERT INTO business_type_category_lkp (code, name_ar, name_en, status_code, business_type_id)
VALUES
    ('SOFA', 'كنبة', 'Sofa', 5, (SELECT id FROM business_type_lkp WHERE code = 'FURNITURE')),
    ('WARDROBE', 'خزانة ملابس', 'Wardrobe', 5, (SELECT id FROM business_type_lkp WHERE code = 'FURNITURE')),
    ('DINING_TABLE', 'طاولة', 'Dining Table', 5, (SELECT id FROM business_type_lkp WHERE code = 'FURNITURE'));


INSERT INTO business_type_category_lkp (code, name_ar, name_en, status_code, business_type_id)
VALUES
    ('KITCHEN_CABINET', 'خزائن مطبخ', 'Kitchen Cabinets', 5, (SELECT id FROM business_type_lkp WHERE code = 'KITCHENS_DRESSINGS')),
    ('STORAGE_SHELVES', 'أرفف تخزين', 'Storage Shelves', 5, (SELECT id FROM business_type_lkp WHERE code = 'KITCHENS_DRESSINGS')),
    ('CUTLERY', 'أدوات مائدة', 'Cutlery', 5, (SELECT id FROM business_type_lkp WHERE code = 'KITCHENS_DRESSINGS'));


INSERT INTO business_type_category_lkp (code, name_ar, name_en, status_code, business_type_id)
VALUES
    ('ELECTRIC_DRILL', 'مثقاب كهربائي', 'Electric Drill', 5, (SELECT id FROM business_type_lkp WHERE code = 'ELECTRICAL_TOOLS')),
    ('CIRCULAR_SAW', 'منشار دائري', 'Circular Saw', 5, (SELECT id FROM business_type_lkp WHERE code = 'ELECTRICAL_TOOLS')),
    ('WIRE_CUTTER', 'قطاعة أسلاك', 'Wire Cutter', 5, (SELECT id FROM business_type_lkp WHERE code = 'ELECTRICAL_TOOLS')),
    ('VOLTAGE_TESTER', 'اختبار الجهد', 'Voltage Tester', 5, (SELECT id FROM business_type_lkp WHERE code = 'ELECTRICAL_TOOLS')),
    ('POWER_EXTENSION', 'سلك تمديد', 'Power Extension', 5, (SELECT id FROM business_type_lkp WHERE code = 'ELECTRICAL_TOOLS'));

INSERT INTO business_type_category_lkp (code, name_ar, name_en, status_code, business_type_id)
VALUES ('CARPET', 'سجاد', 'Carpet', 5, (select id from business_type_lkp where code = 'FURNISHINGS')),
       ('CURTAINS', 'ستائر', 'Curtains', 5, (select id from business_type_lkp where code = 'FURNISHINGS')),
       ('BED_LINEN', 'مفارش الأسرة', 'Bed Linen', 5, (select id from business_type_lkp where code = 'FURNISHINGS')),
       ('BLANKETS', 'بطانيات', 'Blankets', 5, (select id from business_type_lkp where code = 'FURNISHINGS')),
       ('CUSHIONS', 'مخدات', 'Cushions', 5, (select id from business_type_lkp where code = 'FURNISHINGS'));


INSERT INTO business_type_category_lkp (code, name_ar, name_en, status_code, business_type_id)
VALUES
    ('PAINT_BRUSH', 'فرشاة طلاء', 'Paint Brush', 5, (select id from business_type_lkp where code = 'PAINT_MATERIALS')),
    ('PAINT_ROLLER', 'رول طلاء', 'Paint Roller', 5, (select id from business_type_lkp where code = 'PAINT_MATERIALS')),
    ('PAINT_CAN', 'علبة دهان', 'Paint Can', 5, (select id from business_type_lkp where code = 'PAINT_MATERIALS'));