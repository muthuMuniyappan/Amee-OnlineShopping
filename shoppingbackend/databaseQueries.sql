CREATE TABLE category(
id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,


CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name, description, image_url, is_active) VALUES ('Televison', 'This is some about Televisons', 'CAT_1.png', true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Laptop', 'This is some about Laptops', 'CAT_2.png', true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Mobiles', 'This is some about Mobiles', 'CAT_3.png', true);


CREATE TABLE user_details(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
email VARCHAR(100),
password VARCHAR(50),
contact_number VARCHAR(15),
 
CONSTRAINT pk_user_id PRIMARY KEY (id)
);

insert into user_details
	(first_name, last_name, role, enabled, email, password,contact_number)
values ('muthu','Amee','ADMIN', true, 'Amee@gmail.com', 'admin', '9999988888');

insert into user_details
	(first_name, last_name, role, enabled, email, password,contact_number)
values ('Amee','muthu','SUPPLIER', true, 'a@gmail.com', '123', '9999999999');

insert into user_details
	(first_name, last_name, role, enabled, email, password,contact_number)
values ('muthu','Amee','SUPPLIER', true, 'm@gmail.com', '123', '8888888888');

 
CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_details(id),	
);	

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 2, 2, 0, 0 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 2, 3, 0, 0 );
