
// Se desea crear un programa que realice dos subprocesos:
//	
//	* En el primer subproceso se rellenará una matriz cuadrada con números aleatorios, excepto en la diagonal principal, 
//	  la cual estará compuesta por ceros. La dimensión de la matriz será elegida por el desarrollador mientras sea cuadrada.
//			
//	* En el segundo subproceso se imprimirá la matriz resultante.
//				
//	* Después de ejecutar ambos subprocesos, se mostrará la matriz generada por pantalla. 

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
