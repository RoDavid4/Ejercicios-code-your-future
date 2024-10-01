// El usuario ingresa un valor Limite POSITIVO y luego se le pide que ingrese numeros hasta que su suma supere al valor limite que se puso al inicio

Algoritmo Actividad_3
	
	Definir lim, num, aux Como Entero
	
	num = 0
	lim = 0
	
	Mientras lim <= 0
		Escribir "ingrese valor limite POSITIVO"
		Leer lim
	FinMientras
	
	Mientras lim >= num
		Escribir "ingrese valor a sumar"
		Leer aux
		num = num + aux
		Escribir "Suma: ", num," valor limite: ", lim
	FinMientras
	
FinAlgoritmo
