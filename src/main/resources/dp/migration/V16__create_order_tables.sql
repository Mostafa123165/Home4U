CREATE TABLE IF NOT EXISTS `orders` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT DEFAULT 5,
    `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `user_id` BIGINT NOT NULL,
    `order_number` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`order_number`),
    CONSTRAINT `fk_orders_user` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) auto_increment=1, engine=InnoDB;

CREATE TABLE IF NOT EXISTS `order_details` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `status_code` INT DEFAULT 5,
    `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    `modified_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    `order_id` BIGINT NOT NULL,
    `product_id` BIGINT NOT NULL,
    `amount` DOUBLE,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_product` (`order_id`, `product_id`),
    CONSTRAINT `fk_orderdetails_order` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`),
    CONSTRAINT `fk_orderdetails_product` FOREIGN KEY (`product_id`) REFERENCES `products`(`id`)
) auto_increment=1, engine=InnoDB;

