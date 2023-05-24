-- Creating view
CREATE VIEW sales_by_client AS
SELECT c.client_id, c.name, SUM(invoice_total) AS total_sales
FROM clients c
JOIN invoices i USING (client_id)
GROUP BY client_id, name;

SELECT * FROM sales_by_client;

CREATE VIEW clients_balance AS
SELECT c.client_id, c.name,
	   SUM(invoice_total - payment_total) AS balance
FROM clients c
JOIN invoices i USING (client_id)
GROUP BY client_id, name;

SELECT * FROM clients_balance

-- Editing view -> different types
DROP VIEW sales_by_client;

-- drop and create new view again
CREATE VIEW sales_by_client AS
SELECT c.client_id, c.name, SUM(invoice_total) AS total_sales
FROM clients c
JOIN invoices i USING (client_id)
GROUP BY client_id, name;

-- Use create or replace
CREATE OR REPLACE VIEW sales_by_client AS
SELECT c.client_id, c.name, SUM(invoice_total) AS total_sales
FROM clients c
JOIN invoices i USING (client_id)
GROUP BY client_id, name;

-- Updatable views
--  If the view doesn't have DISTINCT kyword, Aggregate(MAX, MIN, SUM, etc), GROUP BY/ HAVING or UNION, -> then only we can update the view
CREATE OR REPLACE VIEW invoices_with_balance AS
SELECT invoice_id, number, client_id, invoice_total,
	   payment_total, invoice_total - payment_total AS balance, 
       invoice_date, due_date, payment_date
FROM invoices
WHERE (invoice_total - payment_total) > 0;

DELETE FROM invoices_with_balance
WHERE invoice_id = 1;

UPDATE invoices_with_balance
SET due_date = DATE_ADD(due_date, INTERVAL 2 DAY) 
WHERE invoice_id = 2;

-- Use Check option so that row doesn't dispear if it has been updated in any manner -> check option will throw error in such scenarios
CREATE OR REPLACE VIEW invoices_with_balance AS
SELECT invoice_id, number, client_id, invoice_total,
	   payment_total, invoice_total - payment_total AS balance, 
       invoice_date, due_date, payment_date
FROM invoices
WHERE (invoice_total - payment_total) > 0
WITH CHECK OPTION;

-- Running the below code, without check option will delete the whole row 4
-- Running the below code, with check option will thorw an error as in this case, the row is about to be deleted
UPDATE invoices_with_balance
SET payment_total = invoice_total
WHERE invoice_id = 4;
