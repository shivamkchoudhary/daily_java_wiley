-- Creating and calling a stored procedure
DELIMITER $$
CREATE PROCEDURE get_clients()
BEGIN
	SELECT * FROM clients;
END$$

DELIMITER ;

CALL get_clients();

-- Create a store procedure using the view from the previous codes
DELIMITER $$
CREATE PROCEDURE get_invoices_with_balance()
BEGIN
	SELECT * FROM invoices_with_balance 
    WHERE balance > 0;
END$$

DELIMITER ;

-- We can also create stored procedure by right clicking on stored procedure and writing our required query and apllying it.



-- Drop procedure and create again or just to drop -> if you just want to drop use 1st code or else use all
DROP PROCEDURE IF EXISTS get_clients;

DELIMITER $$
CREATE PROCEDURE get_clients()
BEGIN
    SELECT * FROM clients;
END$$

DELIMITER ;

-- Parameter in the stored procedure
DROP PROCEDURE IF EXISTS get_clients_by_state;

DELIMITER $$
CREATE PROCEDURE get_clients_by_state(state CHAR(2))
BEGIN
    SELECT * FROM clients c
    WHERE c.state = state;
END$$

DELIMITER ;


DROP PROCEDURE IF EXISTS get_invoices_by_client;

DELIMITER $$
CREATE PROCEDURE get_invoices_by_client(client_id INT)
BEGIN
    SELECT * FROM invoices i
    WHERE i.client_id = client_id;
END$$

DELIMITER ;

-- Parameter with default value
DROP PROCEDURE IF EXISTS get_clients_by_state;

DELIMITER $$
CREATE PROCEDURE get_clients_by_state(state CHAR(2))
BEGIN
	IF state IS NULL THEN
		SET state = 'CA';
	END IF;
    
    SELECT * FROM clients c
    WHERE c.state = state;
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS get_clients_by_state;

DELIMITER $$
CREATE PROCEDURE get_clients_by_state(state CHAR(2))
BEGIN
		SELECT * FROM clients c
        WHERE c.state = IFNULL(state, c.state);
END$$

DELIMITER ;


DROP PROCEDURE IF EXISTS get_payments;
DELIMITER $$
CREATE PROCEDURE get_payments(client_id INT, payment_method_id TINYINT)
BEGIN
	SELECT *
    FROM payments p
    WHERE
		p.client_id = IFNULL(client_id, p.client_id) AND
        p.payment_id = IFNULL(payment_method_id, p.payment_method);
END$$

DELIMITER ;

-- Parameter validation
DROP PROCEDURE IF EXISTS make_payment;
DELIMITER $$
CREATE PROCEDURE make_payment(
	invoice_id INT,
    payment_amount DECIMAL(9, 2),
    payment_date DATE
)
BEGIN
	IF payment_amount <= 0 THEN
		SIGNAL SQLSTATE '22003'
			SET MESSAGE_TEXT = 'Invalid payment amount';
	END IF;
        
	UPDATE invoices i
    SET
		i.payment_total = payment_amount,
        i.payment_date = payment_date
	WHERE i.invoice_id = invoice_id;
END$$

-- Output parameter
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_unpaid_invoices_for_client`(
	client_id INT,
    OUT invoices_count INT,
    OUT invoices_total DECIMAL(9, 2)
)
BEGIN
	SELECT COUNT(*), SUM(invoice_total)
    INTO invoices_count, invoices_total
    FROM invoices i
    WHERE i.client_id = client_id 
		AND payment_total = 0;
    
END

-- To call the above code we use
set @invoices_count = 0;
set @invoices_total = 0;
call sql_invoicing.get_unpaid_invoices_for_client(3, @invoices_count, @invoices_total);
select @invoices_count, @invoices_total;

-- Variables local
CREATE PROCEDURE get_risk_factor ()
BEGIN
	DECLARE risk_factor DECIMAL(9, 2) DEFAULT 0; -- local variable
    DECLARE invoices_total DECIMAL(9, 2);
    DECLARE invoices_count INT;
    
    SELECT COUNT(*), SUM(invoice_total)
    INTO invoices_count, invoices_total
    FROM invoices;
    
    SET risk_factor = invoices_total / invoices_count * 5;
    
    SELECT risk_factor;
    
-- risk_factor = invoices_total / invoices_count * 5	
END


-- Functions (Creating and using)

CREATE FUNCTION get_risk_factor_for_client
(
	client_id INT
)
RETURNS INTEGER
READS SQL DATA
BEGIN
	DECLARE risk_factor DECIMAL(9, 2) DEFAULT 0; -- local variable
    DECLARE invoices_total DECIMAL(9, 2);
    DECLARE invoices_count INT;
    
    SELECT COUNT(*), SUM(invoice_total)
    INTO invoices_count, invoices_total
    FROM invoices i
    WHERE i.client_id = client_id;
    
    SET risk_factor = invoices_total / invoices_count * 5;

	RETURN risk_factor;
END

-- Calculate risk factor of each client
SELECT client_id, name, get_risk_factor_for_client(client_id) AS risk_factor
FROM clients;

