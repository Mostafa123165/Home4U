SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `product_material_lkp`;
CREATE TABLE IF NOT EXISTS `product_material_lkp`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `code`   VARCHAR(255) NOT NULL,
    `name_ar` VARCHAR(255) NOT NULL,
    `name_en` VARCHAR(255) NOT NULL,
    `status_code` INTEGER NOT NULL DEFAULT 5,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT=1, ENGINE=InnoDB;

DROP TABLE IF EXISTS `product_stocks`;
CREATE TABLE IF NOT EXISTS product_stocks (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    color_id INT NOT NULL,
    amount DOUBLE NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status_code INT DEFAULT 5,
    UNIQUE (product_id, color_id),
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    FOREIGN KEY (color_id) REFERENCES color_lkp(id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `product_base_unit_lkp`;
CREATE TABLE IF NOT EXISTS product_base_unit_lkp (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `color_lkp`;
CREATE TABLE IF NOT EXISTS color_lkp (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    hex_color VARCHAR(7),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    description_ar TEXT NOT NULL,
    description_en TEXT NOT NULL,
    business_type_id int NOT NULL,
    business_id BIGINT NOT NULL,
    price DOUBLE NOT NULL,
    length DOUBLE,
    width DOUBLE,
    height DOUBLE,
    base_unit_id INT,
    status_code INT DEFAULT 5,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (business_type_id) REFERENCES business_type_lkp(id),
    FOREIGN KEY (business_id) REFERENCES businesses(id),
    FOREIGN KEY (base_unit_id) REFERENCES product_base_unit_lkp(id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `products_materials`;
CREATE TABLE IF NOT EXISTS `products_materials`(
    `product_id` BIGINT NOT NULL ,
    `material_id` int NOT NULL,
    PRIMARY KEY (product_id, material_id),
    FOREIGN KEY (product_id) REFERENCES products(id) ,
    FOREIGN KEY (material_id) REFERENCES product_material_lkp(id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `product_images`;
CREATE TABLE IF NOT EXISTS product_images (
    id BIGINT NOT NULL AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    image_path TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id)
) ENGINE=InnoDB;

SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO product_base_unit_lkp (code, name_ar, name_en, status_code)
VALUES
    ('KG', 'كيلوغرام', 'Kilogram', 5),
    ('G', 'غرام', 'Gram', 5),
    ('L', 'لتر', 'Liter', 5),
    ('ML', 'ملليلتر', 'Milliliter', 5),
    ('M', 'متر', 'Meter', 5),
    ('CM', 'سنتيمتر', 'Centimeter', 5),
    ('MM', 'ميليمتر', 'Millimeter', 5),
    ('PCS', 'قطعة', 'Piece', 5);

INSERT INTO color_lkp (code, name_ar, name_en, status_code, hex_color)
VALUES
    ('WHITE', 'أبيض', 'White', 5, '#FFFFFF'),
    ('BLACK', 'أسود', 'Black', 5, '#000000'),
    ('GRAY', 'رمادي', 'Gray', 5, '#808080'),
    ('RED', 'أحمر', 'Red', 5, '#FF0000'),
    ('BLUE', 'أزرق', 'Blue', 5, '#0000FF'),
    ('GREEN', 'أخضر', 'Green', 5, '#008000'),
    ('YELLOW', 'أصفر', 'Yellow', 5, '#FFFF00'),
    ('BROWN', 'بني', 'Brown', 5, '#A52A2A'),
    ('BEIGE', 'بيج', 'Beige', 5, '#F5F5DC'),
    ('PINK', 'وردي', 'Pink', 5, '#FFC0CB'),
    ('PURPLE', 'أرجواني', 'Purple', 5, '#800080'),
    ('ORANGE', 'برتقالي', 'Orange', 5, '#FFA500'),
    ('GOLD', 'ذهبي', 'Gold', 5, '#FFD700'),
    ('SILVER', 'فضي', 'Silver', 5, '#C0C0C0'),
    ('NAVY', 'كحلي', 'Navy', 5, '#000080'),
    ('TURQUOISE', 'فيروزي', 'Turquoise', 5, '#40E0D0'),
    ('MAROON', 'خمري', 'Maroon', 5, '#800000'),
    ('TEAL', 'أزرق مخضر', 'Teal', 5, '#008080');


INSERT INTO product_material_lkp (code, name_ar, name_en, status_code)
VALUES
    ('WOOD', 'خشب', 'Wood', 5),
    ('METAL', 'معدن', 'Metal', 5),
    ('PLASTIC', 'بلاستيك', 'Plastic', 5),
    ('GLASS', 'زجاج', 'Glass', 5),
    ('FABRIC', 'قماش', 'Fabric', 5),
    ('LEATHER', 'جلد', 'Leather', 5),
    ('MARBLE', 'رخام', 'Marble', 5),
    ('GRANITE', 'جرانيت', 'Granite', 5),
    ('CERAMIC', 'سيراميك', 'Ceramic', 5),
    ('STONE', 'حجر', 'Stone', 5),
    ('ALUMINUM', 'ألمنيوم', 'Aluminum', 5),
    ('STEEL', 'فولاذ', 'Steel', 5),
    ('COPPER', 'نحاس', 'Copper', 5),
    ('BAMBOO', 'خيزران', 'Bamboo', 5),
    ('CONCRETE', 'خرسانة', 'Concrete', 5),
    ('CARBON_FIBER', 'ألياف الكربون', 'Carbon Fiber', 5),
    ('RUBBER', 'مطاط', 'Rubber', 5),
    ('FOAM', 'رغوة', 'Foam', 5),
    ('PVC', 'بولي فينيل كلوريد', 'PVC', 5);
