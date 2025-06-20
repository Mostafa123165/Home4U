ALTER TABLE products
    ADD COLUMN sum_of_rates double default 0.0;

ALTER TABLE products
    ADD COLUMN count_rates double default 0.0;

UPDATE products product
SET sum_of_rates = (SELECT SUM(rate) FROM product_ratings WHERE product_id = product.id),
    count_rates = (SELECT COUNT(1) FROM product_ratings WHERE product_id = product.id),
    rate = ( SELECT ROUND((SUM(rate) / ( (COUNT(1) * 5) ) ) * 5,2) FROM product_ratings WHERE product_id = product.id);
