// Recibe el nombre de un equipo, si este comienza en "A" devuelve Verdadero, caso contrario devuelve Falso

Algoritmo Comp_5
	
	Definir equipo Como Cadena
	
	Escribir "Ingrese el nombre del equipo"
	Leer equipo
	
	Si Subcadena(equipo, 0, 0) == "A"
		Escribir "CORRECTO"
	SiNo
		Escribir "INCORRECTO"
	FinSi
	
FinAlgoritmo
