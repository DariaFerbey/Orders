INSERT INTO products(id,name,price,status,created_at) VALUES (1,'Product#1', 3.61,'OUT_OF_STOCK','2021-09-16 14:00:04.810221')
INSERT INTO products(id,name,price,status,created_at) VALUES (2,'Product#2', 10.1,'RUNNING_LOW','2021-03-11 14:00:04.810221')
INSERT INTO products(id,name,price,status,created_at) VALUES (3,'Product#3', 0.61,'OUT_OF_STOCK','2021-01-26 14:00:04.810221')
INSERT INTO products(id,name,price,status,created_at) VALUES (4,'Product#4', 200.15,'IN_STOCK','2021-11-06 14:00:04.810221')

INSERT INTO orders (user_id,status,created_at) VALUES (1,'in progress','2021-02-01 14:00:04.810221')
INSERT INTO order_items (id,quantity,order_id,product_id) values (1,10,1,1)


