USE vivero;
SELECT * FROM pedido WHERE id_cliente = 5;

-- Listar todos los pedidos que tengan un producto específico asociado, dato que se recibe  como parámetro.

-- El producto se identifica por su id en la tabla producto.
SELECT p.id_pedido, p.codigo_pedido, p.fecha_pedido, p.fecha_esperada, p.fecha_entrega, p.estado, p.comentarios, p.id_cliente
FROM pedido AS p
JOIN detalle_pedido AS dp
ON p.id_pedido = dp.id_pedido
WHERE dp.id_producto = 1;