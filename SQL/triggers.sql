-- Creating triggers

DELIMITER $$

DROP TRIGGER IF EXISTS payments_after_insert;
CREATE TRIGGER payments_after_insert
	AFTER INSERT ON payments
    FOR EACH ROW
BEGIN
	UPDATE invoices
    SET payment_total = payment_total + NEW.amount
    WHERE invoice_id = NEW.invoice_id;
END $$

DELIMITER ;

DELIMITER $$

DROP TRIGGER IF EXISTS payments_after_delete;
CREATE TRIGGER payments_after_delete
	AFTER DELETE ON payments
    FOR EACH ROW
BEGIN
	UPDATE invoices
    SET payment_total = payment_total - OLD.amount
    WHERE invoice_id = OLD.invoice_id;
END $$ 

DELIMITER ;

-- Viewing triggers

SHOW TRIGGERS;

-- Auduting tables using trigger

DELIMITER $$

DROP TRIGGER IF EXISTS payments_after_insert;
CREATE TRIGGER payments_after_insert
	AFTER INSERT ON payments
    FOR EACH ROW
BEGIN
	UPDATE invoices
    SET payment_total = payment_total + NEW.amount
    WHERE invoice_id = NEW.invoice_id;
    
    INSERT INTO payments_audit
    VALUES (NEW.client_id, NEW.date, NEW.amount, 'Insert', NOW());
END $$

DELIMITER ;

DELIMITER $$

DROP TRIGGER IF EXISTS payments_after_delete;
CREATE TRIGGER payments_after_delete
	AFTER DELETE ON payments
    FOR EACH ROW
BEGIN
	UPDATE invoices
    SET payment_total = payment_total - OLD.amount
    WHERE invoice_id = OLD.invoice_id;
    
	INSERT INTO payments_audit
    VALUES (OLD.client_id, OLD.date, OLD.amount, 'Delete', NOW());
END $$ 

DELIMITER ;

-- Event is sql

SHOW VARIABLES; -- Shows all the variables running

SHOW VARIABLES LIKE 'event%'; -- event variable may be off, set global 'name' on to turn it on


-- Creating events

DELIMITER $$

CREATE EVENT yearly_delete_stale_audit_rows
ON SCHEDULE 
	-- AT '2023-01-01' for once
	EVERY 1 YEAR STARTS '2023-01-01' ENDS '2025-01-01' -- starts and end are optional here
DO BEGIN
	DELETE FROM payments_audit
    WHERE action_date < NOW() - INTERVAL 1 YEAR;
END $$

DELIMITER ;

-- To show all the events or some specific in this case
SHOW EVENTS LIKE 'yearly%';

-- Dropping event
DROP EVENT IF EXISTS yearly_delete_stale_audit_rows;

-- We can use alter to even create a new event or it can be used for disabling event or enabling it
ALTER EVENT yearly_delete_stale_audit_rows DISABLE;

ALTER EVENT yearly_delete_stale_audit_rows ENABLE;