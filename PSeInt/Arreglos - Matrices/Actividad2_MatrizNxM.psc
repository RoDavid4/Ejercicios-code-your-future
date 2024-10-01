
// Dada una matriz de tamaño n x m, donde n y m son valores ingresados por el usuario, se requiere implementar dos subprogramas:
//	
//	El primer subprograma se encargará de llenar la matriz con números aleatorios.
//	
//	El segundo subprograma calculará y mostrará la suma de todos los elementos de la matriz.
//	
//	Después de ejecutar ambos subprogramas, se mostrará la matriz generada junto con los resultados de la suma por pantalla.

SubProceso cargarMatriz(matriz Por Referencia)
	Definir val Como Entero
	
	Para Cada val De matriz 
		val = Aleatorio(-100, 100)
	FinPara
FinSubProceso

Funcion suma <- sumaValores(matriz)
	Definir val, suma Como Entero
	
	suma = 0
	Para Cada val De matriz
		suma = suma + val
	FinPara
	Escribir "La suma de los valores de la matiz es: ", suma
FinSubProceso

SubProceso mostrarMatriz(matriz, n, m)
	Definir i, j Como Entero
	
	Para i <- 0 Hasta n-1
		Para j <- 0 Hasta m - 1
			Escribir matriz[i,j], " " Sin Saltar
		FinPara
		Escribir ""
	FinPara
FinSubProceso

Algoritmo Actividad2_MatrizNxM
	Definir matriz, n, m, suma Como Entero
	
	Escribir "Ingrese las dimenciones (cant filas/ cant columnas) para la matriz"
	Leer n, m
	Dimension matriz[n,m]
	cargarMatriz(matriz)
	suma = sumaValores(matriz)
	Escribir "La matriz es de la forma: "
	mostrarMatriz(matriz, n , m)
	Escribir "La suma de los elementos de la misma es: ", suma
FinAlgoritmo
