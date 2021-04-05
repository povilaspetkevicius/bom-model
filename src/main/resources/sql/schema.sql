CREATE TABLE IF NOT EXISTS products (
  product_code                   IDENTITY NOT NULL PRIMARY KEY,
  parent_product_code            BIGINT,
  product_name                   VARCHAR,
  product_description            VARCHAR,
  required                       BOOLEAN
);

CREATE TABLE IF NOT EXISTS suppliers (
  supplier_code                  IDENTITY NOT NULL PRIMARY KEY,
  supplier_description           VARCHAR
);

CREATE TABLE IF NOT EXISTS product_suppliers (
  id                             IDENTITY NOT NULL PRIMARY KEY,
  product_code                   BIGINT,
  supplier_code                  BIGINT,
  supplied_from_date             DATE,
  supplied_to_date               DATE
);

ALTER TABLE products
    ADD FOREIGN KEY (parent_product_code)
    REFERENCES products(product_code);

ALTER TABLE product_suppliers
    ADD FOREIGN KEY (product_code)
    REFERENCES products(product_code);

ALTER TABLE product_suppliers
    ADD FOREIGN KEY (supplier_code)
    REFERENCES suppliers(supplier_code);

INSERT INTO products (product_name, product_description, required) values ('PARENT', 'PARENT ARTIFACT', TRUE);

INSERT INTO suppliers (supplier_description) values ('PARENT SUPPLIER');

INSERT INTO product_suppliers (product_code, supplier_code) values (1, 1);