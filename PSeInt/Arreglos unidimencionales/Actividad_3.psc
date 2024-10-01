

Algoritmo Actividad_3
	
	Definir bandera Como Logico
	Definir arr, cantidad, val, i Como Entero
	
	Escribir "Cuantos numeros desea cargar"
	Leer cantidad
	/// Se dimenciona el arreglo DE ENTEROS de acuerdo a la cantidad ingresada
	Dimension arr[cantidad]
	Para i <- 0 Hasta cantidad - 1
		arr[i] = Aleatorio(1, 25)
	FinPara
	Limpiar Pantalla
	Escribir "Los numeros son: "
	para i <- 0 Hasta cantidad - 1
		Escribir arr[i], " " Sin Saltar
	FinPara
	Escribir ""
	Escribir "Ingrese el valor a buscar"	
	Leer val
	bandera = falso
	Para i <- 0 Hasta cantidad - 1
		si arr[i] == val
			Escribir "El valor esta en la posicion: ", i
			bandera = Verdadero
		FinSi
	FinPara
	si bandera = Falso
		Escribir "El valor no se encuentra almacenado"
	FinSi
FinAlgoritmo
