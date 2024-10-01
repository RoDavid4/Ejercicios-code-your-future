
Funcion max <- mayorValor(arr)	
	Definir max, val Como Entero
	
	/// Se inicializa con el primer valor almacenado en el arreglo porque al ser numeros enteros podria haber negativos
	max = arr[0]
	Para Cada val De arr Hacer
		si val > max
			max = val
		FinSi
	FinPara
FinFuncion

Algoritmo Actividad_4
	
	Definir arr, n, val Como Entero
	
	Escribir "Ingrese la dimension del arreglo"
	Leer n
	Dimension arr[n]
	Para cada val De arr Hacer
		Escribir "Ingrese un valor: " Sin Saltar
		Leer val
	FinPara
	Escribir "El mayor valor del arreglo es: ", mayorValor(arr) 
	
FinAlgoritmo
