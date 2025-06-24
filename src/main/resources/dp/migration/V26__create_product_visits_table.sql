DROP TABLE IF EXISTS product_visits;
CREATE TABLE IF NOT EXISTS product_visits (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    `status_code` INT DEFAULT 5,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    UNIQUE KEY unique_product_user_visit (product_id, user_id)
);

