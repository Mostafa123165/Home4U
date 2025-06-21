ALTER TABLE orders
ADD COLUMN total_price double default 0.0;

ALTER TABLE order_details
ADD COLUMN price double default 0.0;

Update order_details details
set price = (select pr.price from products pr where details.product_id = pr.id);

UPDATE orders ord
SET total_price = coalesce((select sum(d.price * d.amount) from order_details d where d.order_id = ord.id),0);
