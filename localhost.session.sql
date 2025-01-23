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

/* Crea una vista donde agregues la columna “hipotenusa” calculándola a partir de los otros dos lados. 
Utiliza el teorema de Pitágoras para realizar el cálculo: Siendo el lado adyacente “A” y el opuesto “B” y la hipotenusa “C” la fórmula quedaría de la siguiente forma:

C =A2+B2​ */

/* Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo α en radianes y grados. 
Aquí tienes dos fórmulas: */

/* En radianes: =arcsen(BC) =arccos(AC) = arctan(BA)   */

/* Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo β en radianes y grados. 
Aquí tienes dos fórmulas: */

/* En radianes: β =arccos(BC)=arcsen(AC) = arctan(AB) */  

/* Reemplaza la vista y ahora agrégale dos columnas para calcular el ángulo γ en radianes y grados. 
Como se trata de triángulos rectángulos, el ángulo es de 90°, pero aplica una fórmula de igual manera, 
usa la regla de que la suma de los ángulos de un triángulo suma 180°. */

/* Crea una tabla triangulos_rectangulos_2 con dos columnas: angulo_alfa y una hipotenusa ambos de tipo INT. */

CREATE TABLE triangulos_rectangulos_2 (
    angulo_alfa INT,
    hipotenusa INT
);

/* Rellena la tabla triangulos_rectangulos_2 con 10 filas con enteros aleatorios entre 1 y 89 
para angulo_alfa y enteros aleatorios entre 1 y 100 para la columna hipotenusa. */

/* Crea una vista donde agregues la columna lado_adyacente donde calcules su longitud. */

/* Agrega a la vista la columna lado_opuesto donde calcules su longitud. */

/* Agrega a la vista la columna angulo_beta donde calcules su valor en grados. */

/* Agrega a la vista la columna angulo_gamma donde calcules su valor en grados. */

/* Redondea todos los valores con hasta dos números decimales. */

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
    valor_crc INT
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

/* Crea una vista llamada vista_ahorros_futuros que incluya una columna con el cálculo de los ahorros 
futuros ajustados por la tasa de interés. Para esto utilizaremos la fórmula para calcular el interés compuesto:

VF = VA x (1+r)^n

VF: Valor futuro (ahorros futuros).

VA: Valor actual (ahorro_inicial).

r: La tasa de interés (tasa_interes).

n: El número de periodos (periodos). */