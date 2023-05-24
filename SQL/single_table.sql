-- Get elements from products with modifying unit_price

SELECT name, unit_price, (unit_price * 1.1 ) AS 'new price'
 FROM products;
 
-- Selecting items greater than a given date
SELECT * FROM orders
 WHERE order_date >= '2017-12-31';


-- Get items of order_id 6 and total price greater than 30
SELECT * FROM order_items
WHERE order_id = 6 AND (unit_price * quantity) > 30;


-- USe in operator to get item, this is cleaner way to use instead of OR
SELECT *
FROM products
WHERE quantity_in_stock IN (49,38,72);


-- Use BEtwwen operator for more simplicity
SELECT *
FROM customers
WHERE birth_date BETWEEN '1990-01-01' AND '2000-01-01';


-- Customer whose address contain Trail or Avenue in theri address anywhere
SELECT *
FROM customers
WHERE address LIKE '%TRAIL%' OR 
	  address LIKE '%AVENUE%';

-- Customer whose phone number ends with 9
SELECT *
FROM customers
WHERE phone LIKE '%9';


-- Use REGEX instead of Like
-- Get the customers whose 
-- first names are ELKA or AMBUR
SELECT *
FROM customers
WHERE first_name REGEXP 'ELKA|AMBUR';

--last names end with EY or ON
SELECT *
FROM customers
WHERE last_name REGEXP 'EY$|ON$';

-- last names start with MY or contains SE
SELECT *
FROM customers
WHERE last_name REGEXP '^MY|SE';

-- last names contain B followed by R or U
SELECT *
FROM customers
WHERE last_name REGEXP 'B[RU]';

-- Get order which are not shipped yet (Use to find NULL values in table)
SELECT *
FROM orders
WHERE shipper_id IS NULL


-- Sort the data based on the total price of the items
SELECT *, (quantity * unit_price) AS total_price
FROM order_items
WHERE order_id = 2
ORDER BY total_price DESC


-- Get top 3 loyal cuistomers ( Use of Limit operator)
SELECT *
FROM customers
ORDER BY points DESC
LIMIT 3;