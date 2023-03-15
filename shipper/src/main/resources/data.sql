-- Create user EFOODSHOP
CREATE USER EFOODSHOP IDENTIFIED BY 123456;

-- Assign all permissions to the user
GRANT ALL PRIVILEGES TO EFOODSHOP;

-- Assign all permissions to the user
DROP USER EFOODSHOP CASCADE;

-- Add ROLE data
INSERT INTO ROLE ( ROLE_NAME ) VALUES ('MANAGER');
INSERT INTO ROLE ( ROLE_NAME ) VALUES ('SHIPPER');
INSERT INTO ROLE ( ROLE_NAME ) VALUES ('CUSTOMER');

-- Add SHIPPER data
INSERT INTO USER_1 ( EMAIL, PASSWORD, FULLNAME, PHONE, ROLE_ID )
	VALUES ('theboost1305@gmail.com', '123456', 'Nguyễn Hoàng Linh', '0933348791', 2);
INSERT INTO USER_1 ( EMAIL, PASSWORD, FULLNAME, PHONE, ROLE_ID )
	VALUES ('alice@gmail.com', '123456', 'Alice', '0123456001', 2);
INSERT INTO USER_1 ( EMAIL, PASSWORD, FULLNAME, PHONE, ROLE_ID )
	VALUES ('bob@gmail.com', '123456', 'Bob', '0123456002', 2);
INSERT INTO USER_1 ( EMAIL, PASSWORD, FULLNAME, PHONE, ROLE_ID )
	VALUES ('customer1@gmail.com', '123456', 'Customer 1', '0933348791', 3);


-- Add FOOD data
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Broken rice with grilled pork', 'Vietnamese traditional dish - Com tam', 'Grilled-side-Pork.jpg', 30000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Rice with char siu pork', 'BBQ pork with secret recipe', 'Char-Siu-Pork.jpg', 35000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Rice with grilled chiken', 'Grilled chicken with special ginger sauce', 'Grilled-chicken-Pork.jpg', 40000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Egg fried rice', 'Egg fried rice cooked with special oyster sauce', 'egg-fried-rice.jpg', 30000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Beef Pho', 'Well-Done beef', 'beef-pho.jpg', 45000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Chicken Pho', 'Steamed chicken', 'chicken-pho.jpg', 40000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Bun cha', 'Vietnamese grilled pork with rice vermicelli noodles', 'bun-cha.jpg', 40000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Mi Quang', 'Vietnamese Turmeric Noodles from Quang Nam', 'mi-quang.jpg', 35000, 0);
INSERT INTO FOOD (name, description, image_link, price, is_deleted)
	VALUES ('Bun bo Hue', 'Spicy Beef & Pork Noodle Soup', 'bun-bo.jpg', 45000, 0);

-- Add CART data
INSERT INTO CART (CUSTOMER_ID, IS_DELETED) VALUES (4, 0);
INSERT INTO CART (CUSTOMER_ID, IS_DELETED) VALUES (4, 0);
INSERT INTO CART (CUSTOMER_ID, IS_DELETED) VALUES (4, 0);

-- ADD FOOD_CART data
INSERT INTO FOOD_CART (CART_ID, FOOD_ID, FIXED_PRICE, FOOD_QUANTITY) VALUES (1, 1, 30000, 2);
INSERT INTO FOOD_CART (CART_ID, FOOD_ID, FIXED_PRICE, FOOD_QUANTITY) VALUES (1, 2, 35000, 1);
INSERT INTO FOOD_CART (CART_ID, FOOD_ID, FIXED_PRICE, FOOD_QUANTITY) VALUES (2, 2, 35000, 3);
INSERT INTO FOOD_CART (CART_ID, FOOD_ID, FIXED_PRICE, FOOD_QUANTITY) VALUES (2, 3, 40000, 1);
INSERT INTO FOOD_CART (CART_ID, FOOD_ID, FIXED_PRICE, FOOD_QUANTITY) VALUES (3, 2, 35000, 2);
INSERT INTO FOOD_CART (CART_ID, FOOD_ID, FIXED_PRICE, FOOD_QUANTITY) VALUES (3, 3, 40000, 1);

SELECT * FROM FOOD
SELECT * FROM FOOD_CART
SELECT * FROM CART
SELECT * FROM ORDER_1 o 


-- Add Order data
INSERT INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (1, SYSDATE, 'Thủ Đức, TPHCM', 1, 'DELIVERED');
INSERT INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (2, SYSDATE, 'Thủ Đức, TPHCM', 1, 'IN_PROGRESS');
INSERT INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (3, SYSDATE, 'Thủ Đức, TPHCM', null, 'IN_PROGRESS');


-- UPDATE USER_1 SET PASSWORD = 123456, FULLNAME = 'Nguyễn Hoàng Linh', PHONE = '0933348791' WHERE ID = 1


SELECT * FROM ORDER_1

SELECT * FROM USER_1




-- Testing
-- Index
SELECT COUNT(1) "SHIPPER_NUM" FROM USER_1 WHERE ROLE_ID = 2
SELECT COUNT(1) "CUSTOMER_NUM" FROM USER_1 WHERE ROLE_ID = 3
SELECT COUNT(1) "ORDER_NUM" FROM ORDER_1
-- Profile
SELECT EMAIL, FULLNAME, PASSWORD, PHONE FROM USER_1 WHERE ID = 1 AND ROLE_ID = 2
-- Home
SELECT ID, CREATED_DATE, ADDRESS FROM ORDER_1 WHERE SHIPPER_ID = NULL
-- In-Progress Orders
SELECT ID, CREATED_DATE, ADDRESS FROM ORDER_1 WHERE SHIPPER_ID IS NOT NULL AND SHIPPING_STATUS = 'IN_PROGRESS'
-- Delivered Orders
SELECT ID, CREATED_DATE, ADDRESS FROM ORDER_1 WHERE SHIPPING_STATUS = 'DELIVERED'
-- Order detail (You may want to use JDBC for this stupid stuff)
SELECT
	ORDER_1.ID ORDER_ID, ORDER_1.CREATED_DATE, ORDER_1.ADDRESS,
	USER_1.FULLNAME CUSTOMER_FULLNAME,
	SHIPPER.FULLNAME SHIPPER_FULLNAME,
	FOOD.NAME,
	FOOD_CART.FOOD_QUANTITY,
	FOOD_CART.FIXED_PRICE * FOOD_CART.FOOD_QUANTITY COST
FROM ORDER_1
	JOIN CART ON CART.ID = ORDER_1.CART_ID
	JOIN FOOD_CART ON FOOD_CART.CART_ID = CART.ID
	JOIN FOOD ON FOOD.ID = FOOD_CART.FOOD_ID
	JOIN USER_1 ON USER_1.ID = CART.CUSTOMER_ID
	JOIN USER_1 SHIPPER ON SHIPPER.ID = ORDER_1.SHIPPER_ID 
WHERE
	ORDER_1.ID = 1
	AND FOOD.IS_DELETED = 0
	AND CART.IS_DELETED = 0























