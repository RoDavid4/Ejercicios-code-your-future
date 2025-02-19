USE estancias_exterior;

SELECT id_casa, calle, numero, ciudad, pais, precio_habitacion, tipo_vivienda
FROM casas
WHERE (fecha_desde <= '2020-08-01' AND fecha_hasta >= '2020-08-31')
AND (id_casa NOT IN (
    SELECT id_casa
    FROM estancias
    WHERE ('2020-08-01' <= fecha_hasta AND '2020-08-31' >= fecha_desde)
));
