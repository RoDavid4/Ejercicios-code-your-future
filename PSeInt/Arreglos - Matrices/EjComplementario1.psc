
// Se desea crear un programa que realice dos subprocesos:
//	
//	* En el primer subproceso se rellenar� una matriz cuadrada con n�meros aleatorios, excepto en la diagonal principal, 
//	  la cual estar� compuesta por ceros. La dimensi�n de la matriz ser� elegida por el desarrollador mientras sea cuadrada.
//			
//	* En el segundo subproceso se imprimir� la matriz resultante.
//				
//	* Despu�s de ejecutar ambos subprocesos, se mostrar� la matriz generada por pantalla. 

SubProceso llenarMatriz(matriz)
	Definir i,j Como Entero
	
	Para i <- 0 Hasta 4 Hacer
		para j <- 0 Hasta 4 Hacer
			Si i <> j Entonces
				matriz[i,j] = Aleatorio(-100, 100)
			SiNo
				matriz[i,j] = 9
			FinSi
		FinPara
	FinPara
FinSubProceso

SubProceso mostrarMatriz (matriz)
	Definir i,j Como Entero
	
	Para i <- 0 Hasta 4 Hacer
		para j <- 0 Hasta 4 Hacer
			Escribir matriz[i,j], " | " Sin Saltar
		FinPara
		Escribir ""
	FinPara	
FinSubProceso


Algoritmo EjComplementario1
	Definir matriz Como Entero
	Dimension matriz[5,5]
	
	Escribir "La matriz es de la forma: "
	llenarMatriz(matriz)
	mostrarMatriz(matriz)
FinAlgoritmo
