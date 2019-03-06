-- postgres sql syntex

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id SERIAL primary key,
  first_name character varying(45) DEFAULT NULL,
  last_name character varying (45) DEFAULT NULL,
  email character varying(45) DEFAULT NULL
) ;

INSERT INTO customer VALUES 
	(1,'David','Adams','david@luv2code.com'),
	(2,'John','Doe','john@luv2code.com'),
	(3,'Ajay','Rao','ajay@luv2code.com'),
	(4,'Mary','Public','mary@luv2code.com'),
	(5,'Maxwell','Dixon','max@luv2code.com');

SELECT currval(pg_get_serial_sequence('customer', 'id'));
