DROP TABLE IF EXISTS product_ratings;

CREATE TABLE IF NOT EXISTS product_ratings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    rate DOUBLE NOT NULL DEFAULT 0,
    comment TEXT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    status_code INT,
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT rate_range CHECK (rate >= 1 AND rate <= 5),
    UNIQUE KEY (product_id, user_id)
);



ALTER TABLE products
ADD COLUMN rate DOUBLE DEFAULT 0;