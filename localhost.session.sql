USE nba;

/*
            ########################################
            # Actividades: Consultas base de datos #
            ########################################
*/

/* Mostrar el nombre y peso de los diez jugadores que sean pivots (‘C’) y que pesen más de 200 libras, 
ordenados por peso. */

SELECT Nombre, Peso
FROM jugadores
WHERE peso > 200 AND Posicion = 'C'
ORDER BY peso
LIMIT 10;

/* Mostrar el nombre de los equipos del este (East). */

SELECT Nombre
FROM equipos
WHERE Conferencia = 'East';

/* Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre. */

SELECT *
FROM equipos
WHERE LOWER(Ciudad) LIKE 'c%'
ORDER BY Nombre;

/* Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′. */

SELECT j.nombre AS jugador, e.temporada AS temporada, Puntos_por_partido
FROM jugadores AS j INNER JOIN 
estadisticas AS e ON j.codigo = e.jugador
WHERE j.Nombre = 'Pau Gasol' AND e.temporada = '04/05';

/* Mostrar los diez jugadores con más puntos en toda su carrera con un redondeo de dos decimales. */

SELECT Nombre, ROUND(SUM(Puntos_por_partido), 2) puntos_totales FROM jugadores j
INNER JOIN estadisticas e ON j.codigo = e.jugador
GROUP BY Nombre
ORDER BY puntos_totales DESC
LIMIT 10;

/* Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA. */

SELECT e.Nombre equipo, e.Conferencia, e.Division, j.Nombre jugador, j.Altura FROM equipos e
INNER JOIN jugadores j ON j.Nombre_equipo = e.Nombre
WHERE Altura = (SELECT MAX(Altura) FROM jugadores);

/* Mostrar los 10 partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos. */

SELECT puntos_local, puntos_visitante,
ABS(puntos_local - puntos_visitante) diferencia_ptos
FROM partidos
ORDER BY diferencia_ptos DESC
LIMIT 10;

/* Muestra el nombre del equipo con la mayor diferencia de puntos totales de la temporada temporada "00/01". */

SELECT 
    e.Nombre,
    SUM(CASE 
            WHEN p.equipo_local = e.Nombre THEN p.puntos_local - p.puntos_visitante
            WHEN p.equipo_visitante = e.Nombre THEN p.puntos_visitante - p.puntos_local
        END) AS DiferenciaTotal
FROM 
    equipos AS e
INNER JOIN 
    partidos AS p ON e.Nombre = p.equipo_local OR e.Nombre = p.equipo_visitante
WHERE 
    p.temporada = '00/01'
GROUP BY 
    e.Nombre
ORDER BY 
    DiferenciaTotal DESC
LIMIT 1;

/* Encuentra el nombre de los diez equipos que mejor porcentaje de victorias tengan en la temporada "98/99". 
El número de porcentaje debe estar escrito del 1 al 100 con hasta dos decimales y acompañado por el símbolo “%”. */

SELECT 
    e.Nombre,
    CONCAT (ROUND((SUM(CASE 
          WHEN p.equipo_local = e.Nombre AND p.puntos_local > p.puntos_visitante THEN 1
          WHEN p.equipo_visitante = e.Nombre AND p.puntos_visitante > p.puntos_local THEN 1
          ELSE 0
          END) * 100.0 / COUNT(*)), 2),  '%') AS porcentaje_victorias
FROM 
    equipos AS e
INNER JOIN 
    partidos AS p ON e.Nombre = p.equipo_local OR e.Nombre = p.equipo_visitante
WHERE 
    p.temporada = '98/99'
GROUP BY 
    e.Nombre
ORDER BY 
    porcentaje_victorias DESC
LIMIT 10;

/* Calcula el promedio de puntos por partido de los jugadores que son pivotes ('C') y 
tienen más de 7 pies de altura, y redondea el resultado a dos decimales. */

/* Muestra el nombre del jugador que ha registrado el mayor número de asistencias en un solo partido. */

/* Encuentra el total de partidos en los que el equipo local anotó más de 100 puntos y 
el equipo visitante anotó menos de 90 puntos. */

/* Calcula la diferencia de puntos promedio en todos los partidos de la temporada “00/01” y 
redondea el resultado a dos decimales. */

/* Encuentra el nombre del equipo que ha tenido al menos un jugador que ha promediado más de 10 
rebotes por partido en la temporada “97/98”. */


/*
            ###############################
            # Ejercicios  Complementarios #
            ###############################
*/

-- Correr el script tienda.sql

-- mysql -u root -p < "C:\Users\drv61\OneDrive\Cursos\Code your Future by Globant University\Ejercicios Code your future\SQL\tienda.sql" -v

/*
#######################################
# Subconsultas (En la cláusula WHERE) #
#######################################
*/

USE tienda;

            -- Con operadores básicos de comparación

/* Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN). */

/* Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del 
fabricante Lenovo. (Sin utilizar INNER JOIN). */

/* Lista el nombre del producto más caro del fabricante Lenovo. */

/* Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de 
todos sus productos. */

            -- Subconsultas con IN y NOT IN

/* Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN). */

/* Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN). */

            -- Subconsultas (En la cláusula HAVING)

/* Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos 
que el fabricante Lenovo. */