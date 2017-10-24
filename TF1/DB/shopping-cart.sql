CREATE DATABASE shopping_cart;

CREATE USER 'gett_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON shopping_cart.* TO 'get_user'@'localhost';

USE shopping_cart;

CREATE TABLE Products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25),
  img VARCHAR(200),
  price DOUBLE
);

INSERT INTO products (id, name, price, img) VALUES ( 11, 'Reebok Shoes', 110.11, 'https://www.heels.com/womens-shoes/ginger-gold.html');
INSERT INTO products (id, name, price, img) VALUES ( 12, 'Nike Shoes', 130.33, 'https://www.heels.com/womens-shoes/ginger-gold.html');
INSERT INTO products (id, name, price, img) VALUES ( 13, 'Clarks Shoes', 130.33, 'https://static.heels.com/images/shoes/main_view/large/DS11000_MAIN_LG.jpg');

select * from products;