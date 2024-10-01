// Se ingresa una cadena y la misma debe de empezar con el mismo caracter que empieza.

Algoritmo Comp_6
	
	Definir equipo Como Cadena
	
	/// Todo en mayusculas como pre condicion, tambien se podria utilizar  la funcion MAYUSCULAS(S) en ambos miembros para no discriminar por may/min
	Escribir "Ingrese el nombre del equipo TODO EN MAYUSCULAS"
	Leer equipo
	
	Si Subcadena(equipo, 0, 0) == Subcadena(equipo, Longitud(equipo) - 1, Longitud(equipo) - 1) 
		Escribir "CORRECTO"
	SiNo
		Escribir "INCORRECTO"
	FinSi
	
FinAlgoritmo
