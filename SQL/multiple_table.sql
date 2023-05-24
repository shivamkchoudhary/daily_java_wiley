-- Join order and customer table and get customer name in the order tabe instead of customer_id
SELECT order_id, o.customer_id, c.first_name, c.last_name
FROM orders o
JOIN customers c
ON o.customer_id = c.customer_id;

-- Combine order_items and Product table o get order_id contents and name of porducts
SELECT order_id, oi.product_id, p.name, quantity, oi.unit_price
FROM order_items oi
JOIN products p
ON oi.product_id = p.product_id;


-- Self Join
SELECT e.employee_id, e.first_name, m.first_name AS manager
FROM employees e
JOIN employees m
	ON e.reportS_to = m.employee_id;

-- Join multiple tables for test
SELECT o.order_id, o.order_date, c.first_name, c.last_name, os.name AS status
FROM orders o
JOIN customers c
	ON o.customer_id = c.customer_id
JOIN order_statuses os
	ON o.status = os.order_status_id

-- Join invoicing db table to get client details and payement used by them
SELECT p.date, p.invoice_id, p.amount, c.name, pm.name
FROM payments p
JOIN clients c
	ON p.client_id = c.client_id
JOIN payment_methods pm
	ON p.payment_method = pm.payment_method_id;

--Compound join condition (more than 1 primary key)
SELECT *
FROM order_items oi
JOIN order_item_notes oin
	ON oi.order_id = oin.order_Id
    AND oi.product_id = oin.product_id;

-- Implict join synatx
SELECT *
FROM customers c, orders o
WHERE c.customer_id = o.customer_id

-- Outer join examples
SELECT e.employee_id, e.first_name, m.first_name AS manager
FROM employees e
LEFT JOIN employees m
	ON e.reportS_to = m.employee_id;

-- Outer join to get product list, name and quantity
SELECT p.product_id, p.name, oi.quantity
FROM products p
LEFT JOIN order_items oi
	ON p.product_id = oi.product_id;

-- Outer join with more than 2 conditions for join
SELECT c.customer_id, c.first_name, o.order_id, sh.name AS shipper
FROM customers c
LEFT JOIN orders o
	ON c.customer_id = o.customer_id
LEFT JOIN shippers sh
		ON o.shipper_id = sh.shipper_id
ORDER BY c.customer_id;

-- Using out join and inner join combinations to join 2 or more tables examples
SELECT o.order_date, o.order_id, c.first_name AS customer, sh.name, os.name AS status 
FROM orders o
JOIN customers c
	ON o.customer_id = c.customer_id
LEFT JOIN shippers sh
	ON o.shipper_id = sh.shipper_id
JOIN order_statuses os
	ON o.status = os.order_status_id;

-- Revewing the hr table to display manger using self outer join
SELECT e.employee_id, e.first_name, m.first_name AS manager
FROM employees e
LEFT JOIN employees m
	ON e.reports_to = m.employee_id;

-- Using keyword example -> works only if the comlumn names are same
SELECT o.order_id, c.first_name, sh.name AS shipper
FROM orders o
JOIN customers c
	USING (customer_id)
LEFT JOIN shippers sh
	USING (shipper_id);

-- Using keyword to join tables with more than one primary key
SELECT *
FROM order_items oi
JOIN order_item_notes ion
	USING (order_id, product_id);

-- Mixing both Using and ON depending upon the name of the columns
SELECT p.date, c.name AS client, p.amount, pm.name AS payment_method
FROM payments p
JOIN clients c
	USING (client_id)
JOIN payment_methods pm
	ON p.payment_method = pm.payment_method_id;

-- Example of Natural join (not recomended)
SELECT c.customer_id, c.first_name, o.order_id, sh.name AS shipper
FROM customers c
NATURAL JOIN orders o
NATURAL JOIN shippers sh;

-- Cross Join example
SELECT c.first_name AS customer, p.name AS product
FROM customers c
CROSS JOIN products p
ORDER BY customer;

-- Cross join implict -> without writing the keyword Cross
SELECT sh.name AS shipper, p.name AS product
FROM shippers sh, products p
ORDER BY product;

-- Cross join explict -> using the Cross Join keyword
SELECT sh.name AS shipper, p.name AS product
FROM shippers sh
CROSS JOIN products p
ORDER BY product;

-- Usinh Union keyword to combine results of two or more tables
SELECT order_id, order_date, 'Active' AS status
FROM orders
WHERE order_date >= '2019-01-01'
UNION
SELECT order_id, order_date, 'Archived' AS status
FROM orders
WHERE order_date < '2019-01-01';

-- Union example 2 for getting loyal cuistomers
SELECT customer_id, first_name, points, 'Gold' AS type
FROM customers
WHERE points > 3000
UNION
SELECT customer_id, first_name, points, 'Silver' AS type
FROM customers
WHERE points BETWEEN 2000 AND 3000
UNION
SELECT customer_id, first_name, points, 'Bronze' AS type
FROM customers
WHERE points < 2000
ORDER BY first_name;

