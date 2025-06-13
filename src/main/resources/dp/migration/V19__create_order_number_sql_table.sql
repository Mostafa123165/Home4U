DROP TABLE IF EXISTS order_number_seq;

CREATE TABLE IF NOT EXISTS order_number_seq (
    id INT NOT NULL AUTO_INCREMENT,
    next_val BIGINT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (next_val)
);

INSERT INTO order_number_seq (next_val) VALUES (1);