USE mi_bd;

/*
            #############################################
            # Ejercicios vistas y funciones matemáticas #
            #############################################
*/

/* Crea una tabla triangulos_rectangulos con dos columnas: longitud_lado_adyacente y longitud lado_opuesto, 
ambos de tipo INT. */

CREATE TABLE triangulos_rectangulos (
    longitud_lado_adyacente INT,
    longitud_lado_opuesto INT
);

/* Rellena la tabla triangulos_rectangulos con 10 filas con enteros aleatorios entre 1 y 100 */

INSERT INTO triangulos_rectangulos (longitud_lado_adyacente, longitud_lado_opuesto)
VALUES
(FLOOR(RAND() * (101-1)) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1);

/* Crea una vista donde agregues la columna “hipotenusa” calculándola a partir de los otros dos lados. 
Utiliza el teorema de Pitágoras para realizar el cálculo: Siendo el lado adyacente “A” y el opuesto “B” y la hipotenusa “C” la fórmula quedaría de la siguiente forma:

C^2 =A^2+B^2​ */

CREATE OR REPLACE VIEW hipotenusa AS
SELECT longitud_lado_adyacente, longitud_lado_opuesto,
    ROUND(SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)), 2) AS hipotenusa
FROM triangulos_rectangulos;

SELECT * FROM hipotenusa;

/* Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo α en radianes y grados. 
Aquí tienes dos fórmulas: */

/* En radianes: =arcsen(B/C) =arccos(A/C) = arctan(B/A)   */

CREATE OR REPLACE VIEW hipotenusa AS SELECT longitud_lado_adyacente, longitud_lado_opuesto, 
    ROUND(SQRT(POW(longitud_lado_adyacente,2) + POW(longitud_lado_opuesto,2)), 2) AS hipotenusa, 
    ROUND(ATAN(longitud_lado_opuesto/longitud_lado_adyacente), 3) AS angulo_radianes_alfa, 
    ROUND(DEGREES(ATAN(longitud_lado_opuesto/longitud_lado_adyacente)), 3) AS angulo_grados_alfa 
    FROM triangulos_rectangulos;

SELECT * FROM hipotenusa;

/* Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo β en radianes y grados. 
Aquí tienes dos fórmulas: */

/* En radianes: β =arccos(B/C)=arcsen(A/C) = arctan(A/B) */  

CREATE OR REPLACE VIEW hipotenusa AS SELECT longitud_lado_adyacente, longitud_lado_opuesto, 
ROUND(SQRT(POW(longitud_lado_adyacente,2) + POW(longitud_lado_opuesto,2)), 2) AS hipotenusa, 
ROUND(ATAN(longitud_lado_adyacente/longitud_lado_opuesto), 3) AS angulo_radianes_beta, 
ROUND(DEGREES(ATAN(longitud_lado_adyacente/longitud_lado_opuesto)), 3) AS angulo_grados_beta 
FROM triangulos_rectangulos;

SELECT * FROM hipotenusa;

/* Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo γ en radianes y grados. 
Como se trata de triángulos rectángulos, el ángulo es de 90°, pero aplica una fórmula de igual manera, 
usa la regla de que la suma de los ángulos de un triángulo suma 180°. */

CREATE OR REPLACE VIEW hipotenusa AS SELECT longitud_lado_adyacente, longitud_lado_opuesto, 
ROUND(SQRT(POW(longitud_lado_adyacente,2) + POW(longitud_lado_opuesto,2)), 2) AS hipotenusa, 
ROUND(ATAN(longitud_lado_adyacente/longitud_lado_opuesto), 3) AS angulo_radianes_beta, 
ROUND(DEGREES(ATAN(longitud_lado_adyacente/longitud_lado_opuesto)), 3) AS angulo_grados_beta, 
ROUND(180 - 90 - DEGREES(ATAN(longitud_lado_adyacente/longitud_lado_opuesto)), 3) AS angulo_grado_gamma  
FROM triangulos_rectangulos;

SELECT * FROM hipotenusa;

/* Crea una tabla triangulos_rectangulos_2 con dos columnas: angulo_alfa y una hipotenusa ambos de tipo INT. */

CREATE TABLE triangulos_rectangulos_2 (
    angulo_alfa INT,
    hipotenusa INT
);

/* Rellena la tabla triangulos_rectangulos_2 con 10 filas con enteros aleatorios entre 1 y 89 
para angulo_alfa y enteros aleatorios entre 1 y 100 para la columna hipotenusa. */

INSERT INTO triangulos_rectangulos_2 (angulo_alfa, hipotenusa)
VALUES
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1),
(FLOOR(RAND() * 89) + 1, FLOOR(RAND() * 100) + 1);

/* Crea una vista donde agregues la columna lado_adyacente donde calcules su longitud. */

CREATE OR REPLACE VIEW lado_adyacente
AS SELECT angulo_alfa, hipotenusa, ROUND(hipotenusa*COS(angulo_alfa), 3) AS lado_adyacente
FROM triangulos_rectangulos_2;

/* Agrega a la vista la columna lado_opuesto donde calcules su longitud. */

CREATE OR REPLACE VIEW lado_adyacente
AS SELECT angulo_alfa, hipotenusa, ROUND(hipotenusa*COS(RADIANS(angulo_alfa)), 3) AS lado_adyacente, ROUND(hipotenusa*SIN(RADIANS(angulo_alfa)), 3) AS lado_opuesto
FROM triangulos_rectangulos_2;

SELECT * FROM mi_bd.lado_adyacente;

/* Agrega a la vista la columna angulo_beta donde calcules su valor en grados. */

CREATE OR REPLACE VIEW lado_adyacente
AS SELECT angulo_alfa, hipotenusa, ROUND(hipotenusa*COS(RADIANS(angulo_alfa)), 3) AS lado_adyacente, ROUND(hipotenusa*SIN(RADIANS(angulo_alfa)), 3) AS lado_opuesto, (90 - angulo_alfa) AS angulo_beta
FROM triangulos_rectangulos_2;

/* Agrega a la vista la columna angulo_gamma donde calcules su valor en grados. */

CREATE OR REPLACE VIEW lado_adyacente
AS SELECT angulo_alfa, hipotenusa, ROUND(hipotenusa*COS(RADIANS(angulo_alfa)), 3) AS lado_adyacente, ROUND(hipotenusa*SIN(RADIANS(angulo_alfa)), 3) AS lado_opuesto, (90 - angulo_alfa) AS angulo_beta, 90 AS angulo_gamma
FROM triangulos_rectangulos_2;

/* Redondea todos los valores con hasta dos números decimales. */

CREATE OR REPLACE VIEW lado_adyacente
AS SELECT angulo_alfa, hipotenusa, ROUND(hipotenusa*COS(RADIANS(angulo_alfa)), 2) AS lado_adyacente, ROUND(hipotenusa*SIN(RADIANS(angulo_alfa)), 2) AS lado_opuesto, (90 - angulo_alfa) AS angulo_beta, 90 AS angulo_gamma
FROM triangulos_rectangulos_2;

SELECT * FROM mi_bd.lado_adyacente;

/* Crea una tabla mensajes que tenga una columna “datos” de tipo varchar y una columna valor_crc de tipo int, 
    con las siguientes filas: VALUES

    ('Hola, ¿cómo estás? Espero que tengas un buen día.',3221685809),
    ('Ayer fui al cine a ver una película genial.', 951196167),
    ('Estoy emocionado por el próximo fin de semana.', 3275166159),
    ('Mi reunión se pospuso para el martes que viene.', 169741145),
    ('He estado trabajando en un proyecto importante.', 6480112535),
    ('Esta receta de pastel de manzana es deliciosa.', 2524836786),
    ('Planeo hacer un viaje a la playa este verano.', 5107635050),
    ('Mi gato se divierte jugando con su pelota.', 3578632817),
    ('Hoy es un día soleado y agradable.', 3675102258),
    ('El libro que estoy leyendo es muy interesante.', 854938277); */

CREATE TABLE mensajes (
    datos VARCHAR(255),
    valor_crc BIGINT
);

INSERT INTO mensajes (datos, valor_crc) VALUES
    ('Hola, ¿cómo estás? Espero que tengas un buen día.', 3221685809),
    ('Ayer fui al cine a ver una película genial.', 951196167),
    ('Estoy emocionado por el próximo fin de semana.', 3275166159),
    ('Mi reunión se pospuso para el martes que viene.', 169741145),
    ('He estado trabajando en un proyecto importante.', 6480112535),
    ('Esta receta de pastel de manzana es deliciosa.', 2524836786),
    ('Planeo hacer un viaje a la playa este verano.', 5107635050),
    ('Mi gato se divierte jugando con su pelota.', 3578632817),
    ('Hoy es un día soleado y agradable.', 3675102258),
    ('El libro que estoy leyendo es muy interesante.', 854938277);


/* Crea una vista con una tercera columna “análisis” donde verifiques si el valor crc del mensaje es igual al 
valor de la segunda columna, si no es igual muestra un mensaje “adulterado” en la tercera columna o “correcto” 
en el caso contrario. */

CREATE OR REPLACE VIEW analisis_mensajes AS 
SELECT 
    datos, 
    valor_crc, 
    CASE 
        WHEN valor_crc = crc32(datos) THEN 'correcto' 
        ELSE 'adulterado' 
    END AS analisis 
FROM 
    mensajes;

SELECT * FROM analisis_mensajes;

/* Crea una tabla llamada ahorros con tres columnas: ahorro_inicial (la cantidad inicial de ahorros en dólares) 
de tipo decimal(10, 2), periodos (el número de períodos en años) de tipo int, y tasa_interes 
(la tasa de interés nominal anual en porcentaje) de tipo decimal(5, 2).  */

CREATE TABLE ahorros (
    ahorro_inicial DECIMAL(10, 2),
    periodos INT,
    tasa_interes DECIMAL(5, 2)
);

/* Llena la tabla con 10 filas de números aleatorios para ahorro_inicial (un valor mayor a 1000), 
periodos (un valor entre 1 y 10), y tasa_interes (un valor entre 1 y 1,20). */

INSERT INTO ahorros (ahorro_inicial, periodos, tasa_interes)
VALUES
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2)),
(ROUND(RAND() * 9000 + 1000, 2), FLOOR(RAND() * 10) + 1, ROUND(RAND() * 0.20 + 1, 2));

/* Crea una vista llamada vista_ahorros_futuros que incluya una columna con el cálculo de los ahorros 
futuros ajustados por la tasa de interés. Para esto utilizaremos la fórmula para calcular el interés compuesto:

VF = VA x (1+r)^n
VF: Valor futuro (ahorros futuros).
VA: Valor actual (ahorro_inicial).
r: La tasa de interés (tasa_interes).
n: El número de periodos (periodos). */

CREATE OR REPLACE VIEW vista_ahorros_futuros AS
SELECT 
    ahorro_inicial, 
    periodos, 
    tasa_interes, 
    ROUND(ahorro_inicial * POWER(1 + tasa_interes, periodos), 2) AS valor_futuro 
FROM 
    ahorros;

SELECT * FROM vista_ahorros_futuros;

/* Crea una tabla llamada concentracion_de_hidrogenos con una columna de id incremental, 
y otra columna nanomoles_por_litro, y rellénala con 10 números, estos numeros deben ser el resultado 
de elevar 10 a un exponente aleatorio entero entre 9 y (-5). */

CREATE TABLE concentracion_de_hidrogenos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nanomoles_por_litro DECIMAL(30, 10)
);

INSERT INTO concentracion_de_hidrogenos (nanomoles_por_litro)
VALUES
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5)),
(POWER(10, FLOOR(RAND() * 15) - 5));

SELECT * FROM concentracion_de_hidrogenos;

/* Crea una vista donde agregues la columna ph donde calcules el ph de la sustancia. 
Utiliza la siguiente formula: 

pH = -log[H+]
Log: es el logaritmo en base 10.
[H+]: es la concentración de hidrogeno en moles.
Como la tabla tiene guarda el valor de la concentración en nanomoles debes hacer la conversión a moles primero:
1 mol = 1.000.000.000 nanomoles. */

CREATE OR REPLACE VIEW vista_ph AS 
SELECT 
    id, 
    nanomoles_por_litro, 
    ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) AS ph 
FROM 
    concentracion_de_hidrogenos;

SELECT * FROM vista_ph;

/* Crea una vista donde agregues la columna escala_de_ph donde etiquetes la sustancia con las 
siguientes categorías según su ph:

Acida : 7 < ph > 0
Neutra: ph = 7
Alcalina: 14 < ph > 7 */

CREATE OR REPLACE VIEW vista_ph AS 
SELECT 
    id, 
    nanomoles_por_litro, 
    ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) AS ph,
    CASE
        WHEN ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) > 0 AND ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) < 7 THEN 'Acida'
        WHEN ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) = 7 THEN 'Neutra'
        WHEN ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) > 7 AND ROUND(-LOG10(nanomoles_por_litro / 1000000000), 2) < 14 THEN 'Alcalina'
        ELSE 'No clasificada'
    END AS escala_de_ph 
FROM 
    concentracion_de_hidrogenos;

SELECT * FROM vista_ph;

/* Crea la tabla numeros_ocultos con la columna_1 de tipo varchar y la columna_2 de int y rellénala 
con estos valores:

VALUES
('EB4ECB', 16),
('25SK1E', 31),
('8C2B88', 22),
('58D660A', 15),
('100010020211000', 3),
('20251A2', 13),
('4MFL6M', 23),
('IO36L', 29),
('748D676', 14),
('J1G50', 32)

Todos los números de la primera columna de la tabla anterior están expresados en una base numérica 
correspondiente a la segunda columna, crea una vista con una tercera columna para mostrar los números 
de la columna_1 expresados en base 10 y ordénalos de mayor a menor. */

-- Crear la tabla numeros_ocultos
CREATE TABLE numeros_ocultos (
    columna_1 VARCHAR(255),
    columna_2 INT
);

-- Rellenar la tabla con los valores proporcionados
INSERT INTO numeros_ocultos (columna_1, columna_2)
VALUES
('EB4ECB', 16),
('25SK1E', 31),
('8C2B88', 22),
('58D660A', 15),
('100010020211000', 3),
('20251A2', 13),
('4MFL6M', 23),
('IO36L', 29),
('748D676', 14),
('J1G50', 32);

-- Crear la vista con la conversión a base 10
CREATE OR REPLACE VIEW vista_numeros_ocultos AS 
SELECT 
    columna_1, 
    columna_2, 
    CONV(columna_1, columna_2, 10) AS base_10
FROM 
    numeros_ocultos
ORDER BY 
    CONV(columna_1, columna_2, 10) DESC;

SELECT * FROM vista_numeros_ocultos;

/* Actualiza la vista_ahorros_futuros para que no incluya la columna ahorro_inicial, y luego 
crea una nueva vista vista_ahorro_inicial donde utilices la vista_ahorros_futuros y la siguiente 
fórmula para calcular una nueva columna ahorro_inicial, incluye las demás columnas excepto tasa_interes 
en la vista final: 

VA = VF / (1+r)^n
VA: Valor actual (ahorro_inicial).
VF: Valor futuro (ahorros futuros).
r:  La tasa de interés (tasa_interes).
n: El número de periodos (periodos). */

CREATE OR REPLACE VIEW vista_ahorros_futuros AS
SELECT  
    periodos, 
    tasa_interes, 
    ROUND(ahorro_inicial * POWER(1 + tasa_interes, periodos), 2) AS valor_futuro 
FROM 
    ahorros;

SELECT * FROM vista_ahorros_futuros;

CREATE OR REPLACE VIEW vista_ahorro_inicial AS
SELECT 
    periodos, 
    valor_futuro,
    ROUND(valor_futuro / POWER(1 + tasa_interes, periodos), 2) AS ahorro_inicial
FROM 
    vista_ahorros_futuros;

SELECT * FROM vista_ahorro_inicial;

/* Crea una nueva vista vista_tasa_interes donde utilices la vista_ahorro_inicial y 
la siguiente fórmula para calcular la columna tasa_interes, incluye las demás columnas, 
excepto “periodos”, en la vista final:

r = ( (VF / VA)^(1/n) ) - 1
r: La tasa de interés (tasa_interes).
VF: Valor futuro (ahorros futuros).
VA: Valor actual (ahorro_inicial).
n: El número de periodos (periodos). */

-- Crear la nueva vista vista_tasa_interes
CREATE OR REPLACE VIEW vista_tasa_interes AS
SELECT 
    valor_futuro,
    ahorro_inicial,
    ROUND(POWER(valor_futuro / ahorro_inicial, 1.0 / periodos) - 1, 4) AS tasa_interes
FROM 
    vista_ahorro_inicial;

SELECT * FROM vista_tasa_interes;

/* Crea una nueva vista vista_periodos donde utilices la vista_tasa_interes y la siguiente fórmula 
para calcular la columna periodos, incluye todas las columnas en la vista final:

n = ln(VF / VA) / ln(1 + r)
n: El número de periodos (periodos).
VF: Valor futuro (ahorros futuros).
VA: Valor actual (ahorro_inicial).
r: La tasa de interés (tasa_interes). */

CREATE OR REPLACE VIEW vista_periodos AS
SELECT 
    valor_futuro,
    ahorro_inicial,
    tasa_interes,
    ROUND(LOG(valor_futuro / ahorro_inicial) / LOG(1 + tasa_interes), 2) AS periodos
FROM 
    vista_tasa_interes;

SELECT * FROM vista_periodos;