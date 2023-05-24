-- Few of the numeric fucntions
SELECT ROUND(5.73,1); -- second parameter to define, number after decimal
SELECT CEILING(5.23);
SELECT TRUNCATE(5.7723, 2); 
SELECT FLOOR(5.6);
SELECT ABS(-96);
SELECT RAND(); -- get random value everytime we execute this

-- Few of the string functions
SELECT LENGTH('SKY');
SELECT UPPER('sky');
SELECT LOWER('SKY');
SELECT LTRIM('           SKY');
SELECT RTRIM('SKY      ');
SELECT TRIM('   SKY   ');
SELECT LEFT('kindergarten', 4);
SELECT RIGHT('kindergarten', 6);
SELECT SUBSTRING('kindergarten', 3, 5); -- starts at 3 and takes 5 char after it.
SELECT LOCATE('n', 'kindergarten');
SELECT LOCATE('q', 'kindergarten'); -- if char not present -> it returns 0
SELECT LOCATE('garten', 'kindergarten');
SELECT REPLACE('kindergarten', 'garten', 'garden');
SELECT CONCAT('first', 'last');

SELECT CONCAT(first_name, '  ', last_name) AS full_name
FROM customers;

-- Few of the Date-Time functions
SELECT NOW(), CURDATE(), CURTIME();
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()), HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());
SELECT DAYNAME(NOW()), MONTHNAME(NOW());
SELECT EXTRACT(DAY FROM NOW()); -- we can extract day,year,month same as above.

SELECT *
FROM orders
WHERE YEAR(order_date) <= YEAR(NOW());

-- Date and time formater
SELECT DATE_FORMAT(NOW(), '%M %d %Y');
SELECT TIME_FORMAT(NOW(), '%H:%i %p');

-- Calculations on date and time
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY);
SELECT DATE_ADD(NOW(), INTERVAL 1 MONTH);
SELECT DATE_ADD(NOW(), INTERVAL 1 YEAR);
SELECT DATE_ADD(NOW(), INTERVAL -1 DAY); -- we can use -neg value in the date add method or
SELECT DATE_SUB(NOW(), INTERVAL 1 DAY);
SELECT DATEDIFF('2023-05-01', '2023-05-23');
SELECT TIME_TO_SEC('12:00'); -- time elapsed since midnight
SELECT TIME_TO_SEC('12:00') - TIME_TO_SEC('12:05');

-- IFNULL and COALESCE functions
-- replace any null value with anything
SELECT order_id, IFNULL(shipper_id, 'Not assigned') AS shipper
FROM orders;

-- it will return the first null value
SELECT order_id, COALESCE(shipper_id, comments, 'Not assigned') AS shipper
FROM orders;

-- select customer full name and return their phone number if available or else return unknown 
SELECT CONCAT(first_name, ' ', last_name) AS customer,
	   IFNULL(phone, 'Unknown') AS phone
FROM customers;

-- IF function in the sql
SELECT order_id, order_date,
       IF(YEAR(order_date) =  YEAR(NOW()), 'Active', 'Archive') AS status
FROM orders;

SELECT product_id, name, COUNT(*) AS orders,
	   IF(COUNT(*)> 1, 'Many times', 'Once') AS frequency
FROM products p
JOIN order_items oi USING (product_id)
GROUP BY product_id, name;

-- Case operator in sql
SELECT order_id,
	   CASE
			WHEN YEAR(order_date) = YEAR(NOW()) THEN 'Active'
            WHEN YEAR(order_date) = YEAR(NOW()) - 1 THEN 'Last Year'
            WHEN YEAR(order_date) < YEAR(NOW()) - 1 THEN 'Archived'
            ELSE 'Future'
		END AS category
FROM orders;

SELECT CONCAT(first_name, ' ', last_name) AS customer,
	   points,
       CASE
		   WHEN points > 3000 THEN 'Gold'
		   WHEN points >=2000 THEN 'Silver'
		   ELSE 'Bronze'
		END AS cateogry
FROM customers;

