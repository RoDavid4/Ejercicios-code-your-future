// Crear una matriz de tamaño n x m, donde n y m son valores ingresados por el usuario. 
//Llenar la matriz con números aleatorios comprendidos entre 1 y 100, luego mostrar su traspuesta

SubProceso llenarMatriz(matriz)
	Definir val Como Entero
	
	Para Cada val De matriz Hacer
		val = Aleatorio(1, 100)
	FinPara
	
FinSubProceso

SubProceso  generarTranspuesta(transpuesta, matriz, n, m)
	Definir i, j Como Entero
		
	Para i <- 0 Hasta n - 1 Hacer
		Para j <- 0 Hasta m - 1 Hacer
			transpuesta[j,i] = matriz[i,j]
		FinPara
	FinPara
FinSubProceso

SubProceso mostrarM(matriz, n, m)
	Definir i,j Como Entero
	para i = 0 Hasta n-1 Hacer
		para j = 0 Hasta m-1 Hacer
			Escribir matriz[i,j] , " | " Sin Saltar
		FinPara
		Escribir ""
	FinPara
finsubproceso

Algoritmo Actividad1_MatrizTranspuesta
	Definir matriz, transpuesta, n, m Como Entero
	
	Escribir "A continuacion se generara una matriz "
	Escribir "Ingrese cantidad de filas: "
	Leer n
	Escribir "Ingrese cantidad de columnas: "
	Leer m
	Dimension matriz[n,m], transpuesta[m,n]
	llenarMatriz(matriz)
	Escribir "La matriz generada es: "
	mostrarM(matriz, n, m)
	generarTranspuesta(transpuesta, matriz, n, m)
	Escribir "La matriz transpuesta es: "
	mostrarM(transpuesta,m,n)
FinAlgoritmo
