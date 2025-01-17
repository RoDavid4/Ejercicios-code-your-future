USE mi_bd;
/*
                -----------------------------
                -- Ejercicios JOIN Parte 1 --
                -----------------------------
*/

/* Encuentra el nombre y apellido de los empleados junto con la cantidad total de ventas que han realizado. */
SELECT e.nombre, e.apellido, count(*) as "total ventas" from ventas v
LEFT JOIN empleados as e
on v.empleado_id = e.id
GROUP BY e.id;

/* Calcula el monto total vendido a cada cliente y muestra el nombre del cliente, 
su dirección y el monto total. */
SELECT SUM(v.monto_total) "total cliente",
c.nombre,
c.direccion
FROM clientes c
LEFT JOIN ventas v ON v.cliente_id = c.id
GROUP BY c.id;

/* Encuentra los productos vendidos por cada empleado en el departamento de "Ventas" 
y muestra el nombre del empleado junto con el nombre de los productos que han vendido. */
SELECT e.nombre AS nombre_empleado, p.nombre AS producto
FROM
productos p INNER JOIN ventas v
ON p.id = v.producto_id
INNER JOIN empleados e
ON e.id = v.empleado_id WHERE e.departamento_id = (SELECT id FROM departamentos WHERE nombre = 'ventas')
GROUP BY e.nombre, p.nombre ORDER BY nombre_empleado;

/* Encuentra el nombre del cliente, el nombre del producto y 
la cantidad comprada de productos con un precio superior a $500. */
SELECT c.nombre AS cliente, p.nombre AS producto, SUM(cantidad) AS 'cantidad'
FROM productos AS p 
INNER JOIN ventas AS v ON v.producto_id = p.id 
INNER JOIN clientes AS c ON v.cliente_id = c.id
WHERE p.precio > 500  -- clausula WHERE despues del ultimo INNER JOIN
GROUP BY c.nombre, p.nombre;

/*
                -----------------------------
                -- Ejercicios JOIN Parte 2 --
                -----------------------------
*/

/* Calcula la cantidad de ventas por departamento, incluso si el departamento no tiene ventas. */

SELECT d.nombre , count(v.id) as "ventas totales"
FROM departamentos as d
INNER JOIN empleados as e on d.id=e.departamento_id
LEFT JOIN ventas as v on e.id= v.empleado_id
group by d.id;

/* Encuentra el nombre y la dirección de los clientes que han comprado más de 3 productos distintos 
y muestra la cantidad de productos comprados. */
SELECT c.nombre "Nombre cliente", c.direccion "Direccion cliente", COUNT(DISTINCT v.producto_id)
FROM clientes c
LEFT JOIN ventas v ON v.cliente_id = c.id
GROUP BY c.id
HAVING COUNT(DISTINCT v.producto_id) > 3;


/* Calcula el monto total de ventas realizadas por cada departamento y muestra el 
nombre del departamento junto con el monto total de ventas. */
SELECT d.nombre AS departamento, SUM (v.monto_total) as 'monto total'
FROM departamentos as d
INNER JOIN empleados as e on d.id=e.departamento_id
LEFT JOIN ventas as v on e.id= v.empleado_id
group by d.id;

/*
                -------------------------------------
                -- Ejercicios JOIN Complementarios --
                -------------------------------------
*/

/* Muestra el nombre y apellido de los empleados que pertenecen al departamento 
de "Recursos Humanos" y han realizado más de 5 ventas. */
SELECT CONCAT(e.nombre, ' ', e.apellido) AS empleado, COUNT(v.id) AS 'cantidad de ventas'
FROM departamentos d 
INNER JOIN empleados e ON e.departamento_id = d.id
INNER JOIN ventas v ON e.id = v.empleado_id
WHERE d.nombre = 'Recursos Humanos'
GROUP BY e.id
HAVING COUNT(v.id) > 5;
-- detalle: nadie en recursos humanos realizo ninguna venta

/* Muestra el nombre y apellido de todos los empleados junto con la cantidad total 
de ventas que han realizado, incluso si no han realizado ventas. */
SELECT CONCAT(e.nombre, ' ', e.apellido) AS empleado, COUNT(v.id) AS 'cantidad de ventas'
FROM empleados e
LEFT JOIN ventas v ON e.id = v.empleado_id
GROUP BY e.id;

/* Encuentra el empleado más joven de cada departamento y muestra el nombre del 
departamento junto con el nombre y la edad del empleado más joven.*/
SELECT d.nombre AS departamento, e.nombre AS empleado, e.edad AS edad
FROM departamentos d
INNER JOIN empleados e ON d.id = e.departamento_id
WHERE e.edad = (
    SELECT MIN(edad)
    FROM empleados e2
    WHERE e2.departamento_id = d.id
);
-- Si mas de un empleado tiene la misma edad (minima) entonces devuelve mas de una vez ese departamento

/* Calcula el volumen de productos vendidos por cada producto (por ejemplo, menos
de 5 como "bajo", entre 5 y 10 como "medio", y más de 10 como "alto") y muestra la
categoría de volumen junto con la cantidad y el nombre del producto. */
SELECT
CASE
    WHEN SUM(v.cantidad) < 5 THEN 'bajo'
    WHEN SUM(v.cantidad) BETWEEN 5 AND 10 THEN 'medio'
    ELSE 'alto'
END AS volumen,
SUM(v.cantidad) AS cantidad,
p.nombre
FROM ventas v
INNER JOIN productos p ON v.producto_id = p.id
GROUP BY p.id, p.nombre;