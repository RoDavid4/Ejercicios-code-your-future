
// Crea un programa que solicite al usuario ingresar 9 valores. Los valores ingresados deben ser almacenados en un único arreglo bidimensional 
// (matriz).y debe mostrarlos posteriormente por pantalla. Sigue estos pasos:
//	
//	Declara el tipo de dato que almacenará la matriz.
//	
//	Define la dimensión del arreglo, en este caso, 3X3 (ya que precisamos almacenar 9 datos).
//	
//	Utiliza un bucle para recorrer el arreglo recién creado, posición por posición, y solicita al usuario que introduzca un dato. 
// Puedes emplear una estructura de bucle "Para" para esta tarea. 
// Recuerda que necesitarás bucles anidados para recorrer cada fila y cada columna, siendo el bucle externo para las filas y el interno para las columnas.

SubProceso cargaMatriz (matriz Por Referencia)
	Definir val Como Caracter
	
	Para Cada val De matriz
		Escribir "Ingrese un caracter"
		Leer val
	FinPara
FinSubProceso

SubProceso mostrarMatriz (matriz)
	Definir i,j Como Entero
	
	Para i <- 0 Hasta 2 Hacer
		para j <- 0 Hasta 2 Hacer
			Escribir matriz[i,j], " " Sin Saltar
		FinPara
		Escribir ""
	FinPara	
FinSubProceso

Algoritmo Actividad1_Matriz3x3
	Definir matriz Como Caracter
	Dimension matriz[3,3]
	
	cargaMatriz(matriz)
	mostrarMatriz(matriz)
	
FinAlgoritmo
