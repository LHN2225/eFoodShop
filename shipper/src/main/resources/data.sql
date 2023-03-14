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


-- Add Order data
INSERT ALL
    INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (1, SYSDATE, 'Thủ Đức, TPHCM', 1, 'IN_PROGRESS')
    INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (2, SYSDATE, 'Thủ Đức, TPHCM', 1, 'DELIVERED')
    INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (3, SYSDATE, 'Thủ Đức, TPHCM', null, 'IN_PROGRESS')
    INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (4, SYSDATE, 'Thủ Đức, TPHCM', null, 'IN_PROGRESS')
    INTO ORDER_1 ( CART_ID, CREATED_DATE, ADDRESS, SHIPPER_ID, SHIPPING_STATUS) VALUES (5, SYSDATE, 'Thủ Đức, TPHCM', null, 'IN_PROGRESS')
SELECT 1 FROM DUAL;



UPDATE USER_1 SET PASSWORD = 123456, FULLNAME = 'Nguyễn Hoàng Linh', PHONE = '0933348791' WHERE ID = 1


SELECT * FROM ORDER_1

SELECT * FROM USER_1

