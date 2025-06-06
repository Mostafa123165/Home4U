ALTER TABLE orders
ADD COLUMN status_id INT NULL,
ADD CONSTRAINT
FOREIGN KEY (status_id)
REFERENCES order_status_lkp(id);

UPDATE orders o
SET o.status_id = (SELECT id FROM order_status_lkp WHERE code = 'PENDING');


ALTER TABLE orders
MODIFY COLUMN status_id INT NOT NULL;