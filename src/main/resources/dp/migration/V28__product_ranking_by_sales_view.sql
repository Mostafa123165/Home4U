DROP VIEW IF EXISTS product_ranking_by_sales_view;

create view product_ranking_by_sales_view AS
SELECT product_id,
       business_type_category_id,
       numberOfSales,
       RANK() OVER(partition by business_type_category_id ORDER BY numberOfSales DESC) AS ranking
FROM (
         select product_id,
                product.business_type_category_id,
                SUM(amount) as numberOfSales
         from order_details detail
         JOIN products product ON product.id = detail.product_id
         GROUP BY product_id
         ORDER BY numberOfSales DESC

) as new_table