// Se ingresan resultados de hasta 3 partidos, si en algun partido hay mas de 10 goles ya se considera "ilógico",
// si en todos los partidos hay entre 1 y 10 goles entonces el resultado es "lógico" y se devuelve Verdadero, caso contrario Falso.

Algoritmo Comp_4
	
	Definir contador, goles Como Entero
	Definir resultado Como Cadena
	Definir flag Como Logico
	
	flag = Verdadero
	contador = 0
	
	Repetir
		goles = 0
		/// Se presume que ningun equipo va a meter mas de 9 goles en el mismo partido
		Escribir "ingresar resultado el partido numero ", contador + 1, "respetando el formato xAy o bien x-y"
		Leer resultado
		goles = goles + CONVERTIRANUMERO(SUBCADENA(resultado,0,0)) + CONVERTIRANUMERO(SUBCADENA(resultado,2,2))
		contador = contador + 1
		Si goles >= 1 Y goles <= 10
			flag = Verdadero
		SiNo
			flag = Falso
		FinSi
		/// Si algun resultado ya resulto Falso no tiene sentido seguir
	Mientras Que contador < 3 Y flag == Verdadero
	
	Escribir flag
	
FinAlgoritmo
