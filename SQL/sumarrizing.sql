-- Basic aggregate function
SELECT MAX(invoice_total) AS highest,
	   MIN(invoice_total) AS lowest,
       AVG(invoice_total) AS average,
       SUM(invoice_total) AS total,
       COUNT(*) AS total_records
FROM invoices;

-- Find the toal sales
SELECT 'First half of 2019' AS date_range,
		SUM(invoice_total) AS total_sales,
        SUM(payment_total) AS total_payement,
        SUM(invoice_total - payment_total) AS what_we_expect
FROM invoices
WHERE invoice_date BETWEEN '2019-01-01' AND '2019-06-30'
UNION
SELECT 'Second half of 2019' AS date_range,
		SUM(invoice_total) AS total_sales,
        SUM(payment_total) AS total_payement,
        SUM(invoice_total - payment_total) AS what_we_expect
FROM invoices
WHERE invoice_date BETWEEN '2019-07-01' AND '2019-12-31'
UNION
SELECT 'Total' AS date_range,
		SUM(invoice_total) AS total_sales,
        SUM(payment_total) AS total_payement,
        SUM(invoice_total - payment_total) AS what_we_expect
FROM invoices
WHERE invoice_date BETWEEN '2019-01-01' AND '2019-12-31';

-- Group by example set
SELECT client_id, SUM(invoice_total) AS total_sales
FROM invoices
WHERE invoice_date >= '2019-07-01'
GROUP BY client_id
ORDER BY total_sales DESC;

-- Grouping using more than one column
SELECT state, city, SUM(invoice_total) AS total_sales
FROM invoices i
JOIN clients USING (client_id)
GROUP BY client_id;

-- Group by comibing two or more tables
SELECT date, pm.name AS payment_method, SUM(amount) AS total_payments
FROM payments p
JOIN payment_methods pm
ON p.payment_method = pm.payment_method_id
GROUP BY date, payment_method
ORDER BY date;

-- Having clause use
SELECT c.customer_id, c.first_name, c.last_name,
	   SUM(oi.quantity * oi.unit_price) AS total_sales
FROM customers c
JOIN orders o USING (customer_id)
JOIN order_items oi USING (order_id)
WHERE state = 'VA'
GROUP BY c.customer_id, c.first_name, c.last_name
HAVING total_sales > 100;

-- Rollup operator -> add total values as summary
SELECT STATE, CITY, SUM(invoice_total) AS total_sales
FROM invoices i
JOIN clients c USING (client_id)
GROUP BY state, city WITH ROLLUP;

-- Final Rollup query
SELECT pm.name AS payment_method, SUM(amount) AS total
FROM payments p
JOIN payment_methods pm
	ON p.payment_method = pm.payment_method_id
GROUP BY pm.name WITH ROLLUP;
