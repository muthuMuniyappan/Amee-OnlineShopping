	

// Category Table
==================================

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
=====================================================================================================================================
//User_Details Table
=====================
CREATE TABLE user_details(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
email VARCHAR(100),
password VARCHAR(60),
contact_number VARCHAR(15),

CONSTRAINT pk_user_id PRIMARY KEY (id)
);

insert into user_details
	(first_name, last_name, role, enabled, email, password,contact_number)
values ('muthu','Amee','ADMIN', true, 'Amee@gmail.com', '$2a$10$57ioRb8cbsj8DjUzVKHuJuFtwffz40aAdhhL2alM2PsJu3gD0AO6y', '9999988888');

insert into user_details
	(first_name, last_name, role, enabled, email, password,contact_number)
values ('Amee','muthu','SUPPLIER', true, 'a@gmail.com', '$2a$10$7UXVqNEI0.5qaUDRDSdo2uyYKaKdsmdbbQDrGk25cjfOTVl2rl.8G', '9999999999');

insert into user_details
	(first_name, last_name, role, enabled, email, password,contact_number)
values ('muthu','Amee','SUPPLIER', true, 'm@gmail.com', '$2a$10$cBzLSJhinYG.zmBnvMIMguOOhPi7DEMJ9J6P7CWeTqij7KtiHalhu', '8888888888');
======================================================================================================================
//Product Table
================== 
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
=============================================================================================================
//Address Table
===============

CREATE TABLE address(
id IDENTITY,
user_id int,
address_line_one varchar(100),
address_line_two varchar(100),
city varchar(20),
state varchar(20),
country varchar(20),
postal_code varchar(10),
is_billing boolean,
is_shopping boolean,

CONSTRAINT pk_address_id PRIMARY KEY (id),
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_details(id)
);
=================================================================================================================
// Cart Table
==============
CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	
	CONSTRAINT pk_cart_id PRIMARY KEY (id),
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id)
);
===============================================================================================================
// cartLines
============

CREATE TABLE cart_line(
 id IDENTITY,
 cart_id int,
 total decimal(10,2),
 product_id int,
 product_count int,
 buying_price decimal(10,2),
 is_available boolean, 
 CONSTRAINT pk_cartline_id PRIMARY KEY (id),
 CONSTRAINT fk_cartline_card_id FOREIGN KEY (cart_id) REFERENCES cart(id),
 CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product(id)
);





