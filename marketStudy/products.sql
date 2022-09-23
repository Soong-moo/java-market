DROP DATABASE IF EXISTS products;
DROP USER IF EXISTS test@localhost;
CREATE USER test@localhost IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON products.* TO test@localhost WITH GRANT OPTION;
COMMIT;
CREATE DATABASE products;

/* test DB 자료 생성 */

USE products;
CREATE TABLE product
(
	name VARCHAR(20)  NOT NULL PRIMARY KEY,
	price INT NOT NULL
);

INSERT INTO product (name, price) VALUES 
('사과', 1000),
('배', 2000),
('복숭아', 2500),
('물', 500),
('커피', 2300);