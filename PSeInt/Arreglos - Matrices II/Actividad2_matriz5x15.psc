// Desarrolla un programa que genere una matriz de tamaño 5x15. 
// Tu tarea consiste en llenar la matriz con unos y ceros, donde los 1 ocupan el borde externo de la matriz y los 0 llenarán el área interior.


SubProceso llenarMatriz(matriz)
	Definir i,j Como Entero
	para i = 0 Hasta 4 Hacer
		para j = 0 Hasta 14 Hacer
			/// Si i = 0 es tope, si i = 4 es piso
			/// Si j = 0 es borde izq, si j = 14 es borde der
			Si i == 0 O i == 4 O j == 0 O j == 14
				matriz[i,j] = 1
			SiNo
				matriz[i,j] = 0
			FinSi
			
		FinPara
		Escribir ""
	FinPara
finsubproceso

SubProceso mostrarM(matriz)
	Definir i,j Como Entero
	para i = 0 Hasta 4 Hacer
		para j = 0 Hasta 14 Hacer
			Escribir matriz[i,j] , " | " Sin Saltar
			
		FinPara
		Escribir ""
	FinPara
finsubproceso

Algoritmo Actividad2_matriz5x15
	Definir matriz Como Entero
	
	Dimension matriz[5,15]
	llenarMatriz(matriz)
	mostrarM(matriz)
FinAlgoritmo
