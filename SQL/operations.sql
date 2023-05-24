-- Inserting multiple rows in the product table
INSERT INTO products (name, quantity_in_stock, unit_price)
VALUES ('Coke', 10, 2.0),
	   ('Chips', 5, 1.0),
	   ('Chilly', 1, 2.95);

-- Insert data in more than one table at a time
INSERT INTO orders (customer_id, order_date, status)
VALUES (1, '2023-01-05', 1);
INSERT INTO order_items
VALUES(LAST_INSERT_ID(), 1, 1, 3.25);

-- Copy data of one table into another -> Assuming table is already created
INSERT INTO order_archive
SELECT * FROM orders
WHERE order_date < '2019-01-01';

-- Copy data of one table into another based on some conditions
CREATE TABLE invoice_archive AS
SELECT invoice_id, number, c.name AS client, invoice_total, payment_total, invoice_date, due_date, payment_date 
FROM invoices i
JOIN clients c
	USING (client_id)
WHERE payment_date IS NOT NULL;

-- Updating a row in a table
UPDATE invoices
SET payment_total = 10, payment_date = '2023-01-01'
WHERE invoice_id = 1;

-- Update value based on some condition
UPDATE invoices
SET payment_total = invoice_total * 0.5, payment_date = due_date
WHERE invoice_id = 3;

-- Update multiple rows values based on some condition
UPDATE customers
SET points = points + 50
WHERE birth_date < '1990-01-01';

-- Using subqueries to updates the table
UPDATE orders
SET comments = 'Gold'
WHERE customer_id IN
			(SELECT customer_id
			FROM customers
			WHERE points > 3000);



