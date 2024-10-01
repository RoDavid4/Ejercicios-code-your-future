
// Desarrolla un programa que calcule la multiplicación de dos matrices de enteros de tamaño 3x3.
// Asegúrate de inicializar las matrices para evitar tener que ingresar datos desde el teclado. 
// La multiplicación se almacenará en una tercera matriz, donde cada elemento será el resultado de multiplicar 
// los elementos correspondientes en la misma posición de las matrices A y B. 
// Por ejemplo, el elemento en la posición (0,0) de la matriz C será el resultado de multiplicar el elemento en la posición (0,0)
// de la matriz A con el elemento en la posición (0,0) de la matriz B.

SubProceso llenarMatriz(matriz)
	Definir val Como Entero
	
	Para Cada val De matriz Hacer
		val = Aleatorio(0, 9)
	FinPara
	
finsubproceso

SubProceso multiplicarMatrices(mA, mB, resultante)
	Definir i,j Como Entero
	para i = 0 Hasta 2 Hacer
		para j = 0 Hasta 2 Hacer
			resultante[i,j] = mA[i,j] * mB[i,j]
		FinPara
		
	FinPara
finsubproceso

SubProceso mostrarM(matriz)
	Definir i,j Como Entero
	para i = 0 Hasta 2 Hacer
		para j = 0 Hasta 2 Hacer
			Escribir matriz[i,j] , " | " Sin Saltar
			
		FinPara
		Escribir ""
	FinPara
finsubproceso

Algoritmo Actividad4_multiplicarMatrices3x3
	Definir matrizA, matrizB, matrizC Como Entero
	
	Dimension matrizA[3,3], matrizB[3,3], matrizC[3,3]
	llenarMatriz(matrizA)
	llenarMatriz(matrizB)
	multiplicarMatrices(matrizA, matrizB, matrizC)
	Escribir "La primera matriz es: "
	mostrarM(matrizA)
	Escribir "La primera matriz es: "
	mostrarM(matrizB)
	Escribir "La matriz resultante de la multiplicacion entre las matrices anteriores es: "
	mostrarM(matrizC)
FinAlgoritmo
