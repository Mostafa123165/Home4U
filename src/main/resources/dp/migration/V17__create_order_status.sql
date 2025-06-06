DROP TABLE IF EXISTS `order_status_lkp`;
CREATE TABLE IF NOT EXISTS order_status_lkp (
    id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) UNIQUE NOT NULL,
    name_ar VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    status_code INT DEFAULT 5,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

INSERT INTO order_status_lkp (code, name_ar, name_en, status_code)
VALUES
    ('PENDING', 'قيد الانتظار', 'Pending', 5),
    ('CANCELED', 'ملغي', 'Canceled', 5),
    ('DELIVERED', 'تم التوصيل', 'Delivered', 5);

