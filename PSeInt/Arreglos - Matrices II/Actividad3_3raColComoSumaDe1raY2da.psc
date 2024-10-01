
// Crea una matriz con 3 columnas y una cantidad de filas definida por el usuario. En las dos primeras columnas, 
// el usuario ingresará valores enteros (puede diseñar este ingreso de manera aleatoria para enviar la carga manual). 
// En la tercera columna se almacenará el resultado de sumar los números de la primera y segunda columna. La matriz se mostrará de la siguiente forma:
// 3 | 5 | 8 ? 8 se obtuvo de sumar 3 + 5 
// 4 | 3 | 7 ? 7 se obtuvo de sumar 4 + 3 
// 1 | 4 | 5 ? 5 se obtuvo de sumar 1 +4 


SubProceso llenarMatriz(matriz, fil)
	Definir i,j Como Entero
	para i = 0 Hasta fil - 1 Hacer
		para j = 0 Hasta 2 Hacer
			/// Si i = 0 es tope, si i = 4 es piso
			/// Si j = 3 es el ultimo elemento de la fila, por lo tanto es donde va la suma
			Si j == 2 Entonces
				///Si es el ultimo elemento de la fila se almacena la suma de los dos anteriores
				matriz[i,j] = matriz[i,j-2] + matriz[i,j-1]
			SiNo
				matriz[i,j] = Aleatorio(1, 10)
			FinSi
		FinPara
		Escribir ""
	FinPara
finsubproceso

SubProceso mostrarM(matriz, fil)
	Definir i,j Como Entero
	para i = 0 Hasta fil - 1 Hacer
		para j = 0 Hasta 2 Hacer
			Si j <> 2 Entonces
				Escribir matriz[i,j] , " V " Sin Saltar
			SiNo
				Escribir matriz[i,j]  Sin Saltar
				Escribir " -> ", matriz[i,j], " se obtuvo de sumar ", matriz[i,j-2], " + ", matriz[i,j-1] 
			FinSi
		FinPara
	FinPara
finsubproceso

Algoritmo Actividad3_3raColComoSumaDe1raY2da
	Definir matriz, fil Como Entero
	fil = 10
	Dimension matriz[fil, 3]
	llenarMatriz(matriz, fil)
	mostrarM(matriz, fil)
FinAlgoritmo