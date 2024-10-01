Algoritmo Actividad_2
	
	Definir sum, mul, arr, i, val Como Entero
	Dimension arr[10]
	
	sum = 0
	mul = 1
	
	Para Cada val De arr Hacer
		Escribir "Ingrese un valor entero"
		Leer val
		sum = sum + val
		mul = mul * val
	FinPara
	Limpiar Pantalla
	Escribir "Los valores son: "
	Para Cada val De arr Hacer
		Escribir val, " " Sin Saltar
	FinPara
	Escribir ""
	Escribir "La suma de los valores es: ", sum
	Escribir "El producto de los valores es: ", mul
	
FinAlgoritmo
