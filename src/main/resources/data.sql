INSERT INTO producto
	(descripcion, precio_unitario)
VALUES
	('Producto uno', 1.25);

INSERT INTO producto
	(descripcion, precio_unitario)
VALUES
	('Producto dos', 2.5);

INSERT INTO producto
	(descripcion, precio_unitario)
VALUES
	('Producto tres', 3.25);

INSERT INTO stock
	(producto_codigo, cantidad)
VALUES
	(1, 10);

INSERT INTO stock
	(producto_codigo, cantidad)
VALUES
	(2, 10);

INSERT INTO stock
	(producto_codigo, cantidad)
VALUES
	(3, 10);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto cuatro', 4.5);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto cinco', 5.25);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto seis', 6.5);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto siete', 7.25);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto ocho', 8.5);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto nueve', 9.25);

-- INSERT INTO productos
-- 	(descripcion, precio_unitario)
-- VALUES
-- 	('Producto diez', 10.5);

-- INSERT INTO linea (producto_codigo, cantidad, precio_total) VALUES
-- (
-- 	1,
-- 	2,
-- 	(select precio_unitario from producto
-- 	where codigo = 1) * 2
-- );

-- INSERT INTO transaccion (fecha, numero, producto_codigo) values ('2022-06-30', 1, 1);