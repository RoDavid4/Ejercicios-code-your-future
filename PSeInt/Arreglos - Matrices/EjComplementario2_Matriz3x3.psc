Algoritmo EjComplementario_Matriz3x3
	Definir n, m como entero
	Definir matriz, palabra como Caracter
	n=3
	m=3
	Dimension matriz[n,m]
	
	Repetir
		Escribir "Indica una palabra de 9 caracteres"
		Leer palabra
	Mientras Que Longitud(palabra) <> 9
	
	llenarMatriz(matriz, n, m, palabra)
	imprimirMatriz(matriz, n, m)
	
FinAlgoritmo


SubProceso llenarMatriz(arreglo, fila, columna, palabra)
	Definir i, j, cont Como Entero
	Definir letra Como Caracter
	
	cont = 0
	
	Para i=0 hasta fila-1 Hacer
		Para j=0 Hasta columna-1 Hacer
			letra = SubCadena(palabra,cont,cont)
			cont = cont + 1
			arreglo[i,j] = letra
		FinPara
		
	FinPara
FinSubProceso

SubProceso imprimirMatriz(arreglo, fila, columna)
	Definir i, j Como Entero
	Escribir ""
	Escribir "MATRIZ"
	Para i=0 hasta fila-1 Hacer
		Para j=0 Hasta columna-1 Hacer
			Escribir Sin Saltar arreglo[i, j], " | "
		FinPara
		Escribir ""
	FinPara
FinSubProceso
