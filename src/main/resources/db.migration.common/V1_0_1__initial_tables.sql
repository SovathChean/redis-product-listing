

--create sequence table--
CREATE SEQUENCE product_seq;
CREATE sequence categories_seq;

CREATE TABLE products
(
    id varchar (100) PRIMARY KEY,
    name varchar(100) NOT NULL,
    description text
);
CREATE TABLE categories
(
    id varchar (100) PRIMARY KEY,
    name varchar(100) NOT NULL
);
CREATE TABLE product_has_category
(
    product_id varchar (100) PRIMARY KEY,
    category_id varchar (100),
    CONSTRAINT product_has_category_product_id_FK FOREIGN KEY (product_id) REFERENCES "products" (id),
    CONSTRAINT product_has_category_category_id FOREIGN KEY (category_id) REFERENCES "categories" (id)
);
