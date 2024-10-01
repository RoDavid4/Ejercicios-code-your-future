Algoritmo Actividad_2
	
	Definir val1, val2 Como Entero
	Definir operacion Como Caracter
	
	Escribir "Ingrese los dos valores a operar"
	Leer val1
	Leer val2
	
	Escribir "Ingrese: S para Suma, R para Resta, M para Multiplicación y D para División"
	Leer operacion
	
	Segun operacion Hacer
		'S':
			Escribir val1 + val2
		'R':
			Escribir val1 - val2
		'M':
			Escribir val1 * val2
		'D':
			Escribir val1 / val2
	FinSegun
	
FinAlgoritmo
