-- Basic sub-query example
SELECT *
FROM products
WHERE unit_price >(
SELECT unit_price
FROM products
WHERE product_id = 3
);

-- Select employees who earns more than average
SELECT *
FROM employees
WHERE salary > (
SELECT AVG(salary)
FROM employees
);

-- Select product has not been purchased yet
SELECT *
FROM products
WHERE product_id NOT IN(
SELECT DISTINCT(product_id)
FROM order_items
);

-- Clients without invoices
SELECT *
FROM clients
WHERE client_id NOT IN (
	SELECT DISTINCT client_id
	FROM invoices
);

-- Find customers who have ordereed a specific product using subqueries
SELECT *
FROM customers
WHERE customer_id IN (
SELECT DISTINCT o.customer_id
FROM orders o
JOIN order_items oi
	USING(order_iD)
WHERE product_id = 3
);

-- Same above query but using JOin method
SELECT DISTINCT customer_id, first_name, last_name
FROM customers c
JOIN orders o USING (customer_id)
JOIN order_items oi USING (order_id)
WHERE oi.product_id = 3;

-- Select invoices larger than all invoice of clinet 3
SELECT *
FROM invoices
WHERE invoice_total > (
	SELECT MAX(invoice_total)
	FROM invoices
	WHERE client_id = 3
);

-- Select invoices larger than all invoice of clinet 3 -> Using ALL keyword
SELECT *
FROM invoices
WHERE invoice_total > ALL(
	SELECT invoice_total
	FROM invoices
	WHERE client_id = 3
);

-- Select clients with atleast two invoies -> use of ANY keyword
SELECT *
FROM clients
WHERE client_id = ANY(
	SELECT client_id
	FROM invoices
    GROUP BY client_id
    HAVING COUNT(*) >= 2
);

-- Correleated subquery
SELECT *
FROM employees e
WHERE salary > (
SELECT AVG(salary)
FROM employees
WHERE office_id = e.office_id
);

-- Get invoices that are larger than client average invoice amount -> COrelated subqueries
SELECT *
FROM invoices i
WHERE invoice_total > (
SELECT AVG(invoice_total)
FROM invoices
WHERE client_id = i.client_id
);

-- Select clients that have an invoice using -> Exists keyword
SELECT *
FROM clients c
WHERE EXISTS (
	SELECT client_id
    FROM invoices
    WHERE client_id = c.client_id
);

-- Select product has not been ordered yet -> Using Exists keyword and corelated query
SELECT *
FROM products p
WHERE NOT EXISTS(
SELECT DISTINCT(product_id)
FROM order_items
WHERE product_id = p.product_id
);

-- Subqueries in select clause
SELECT invoice_id, invoice_total,
	   (SELECT AVG(invoice_total) FROM invoices) AS invoice_average,
       invoice_total - (SELECT invoice_average) AS difference
FROM invoices;

-- Subqueuries inside the select clause with more than two clauses
SELECT client_id, name, 
	   (SELECT SUM(invoice_total) FROM invoices WHERE client_id = c.client_id) AS total_sales,
	   (SELECT AVG(invoice_total) FROM invoices) AS average,
       (SELECT total_sales - average) AS difference
FROM clients c;

-- Subqueries inside the form clause
SELECT *
FROM (
	SELECT client_id, name, 
		   (SELECT SUM(invoice_total) FROM invoices WHERE client_id = c.client_id) AS total_sales,
		   (SELECT AVG(invoice_total) FROM invoices) AS average,
		   (SELECT total_sales - average) AS difference
	FROM clients c
) AS sales_summary
WHERE total_sales IS NOT NULL;


