//Un ejemplo de una matriz mágica es una matriz cuadrada, donde el número de filas es igual al número de columnas, y que
//tiene la propiedad especial de que la suma de sus filas, columnas y diagonales es igual. Por ejemplo:

SubProceso llenar(matriz, n)
	Definir i,j Como Entero
	para i = 0 Hasta n-1 Hacer
		para j = 0 Hasta n-1 Hacer
			Escribir "Ingrese 1 número para la posición: ", i, "/", j
			leer matriz[i,j]
		FinPara
	FinPara
	
FinSubProceso
SubProceso mostrarM(matriz, n)
	Definir i,j Como Entero
	para i = 0 Hasta n-1 Hacer
		para j = 0 Hasta n-1 Hacer
			Escribir matriz[i,j] , " | " Sin Saltar
			
		FinPara
		Escribir ""
	FinPara
finsubproceso


Funcion esMagica <- comparar(matriz, n)
	Definir esMagica Como Logico
	definir i,j, sumaAux, sumafila, sumacolumna, sumadiagonal, diagonalOpuesta Como Entero
	
	
	i=0
	sumadiagonal = 0
	diagonalOpuesta = 0
	esMagica = Verdadero
	sumaAux = 0
	mientras  esMagica == Verdadero Y  i < n Hacer
		j=0
		sumafila = 0
		sumacolumna = 0
		Mientras  esMagica == Verdadero Y j < n Hacer
			sumafila = sumafila + matriz[i,j]
			sumacolumna = sumacolumna + matriz[j,i]
			si i == j Entonces				
				sumadiagonal = sumadiagonal + matriz[i,j]
				diagonalOpuesta = diagonalOpuesta + matriz[i,n-1-i]  ///  < - - - - - - - -
			FinSi
			j = j + 1
		FinMientras
		Si (sumafila == sumacolumna) Entonces
			Si (sumaAux == 0) Entonces
				sumaAux = sumafila
			SiNo
				Si sumaAux <> sumafila
					esMagica = Falso
				FinSi
			FinSi
		SiNo
			esMagica = Falso
		FinSi
		Escribir "fila = :", i, " : ", sumafila
		Escribir "columna = :", i, " : ",sumacolumna
		i = i + 1
	FinMientras
	/// esMagica ya viene siendo verdadera siempre que la suma de las columnas sea igual a la suma de las filas, 
	/// solo falta comparar que las diagonales sumen lo mismo y que esta suma sea igual a la suma anterior.
	esMagica = esMagica Y diagonalOpuesta == sumadiagonal Y sumaAux == sumadiagonal
	Escribir "sumadiagonal = :", sumadiagonal
	Escribir "diagonalOpuesta = :", diagonalOpuesta
	
FinFuncion


Algoritmo EjComplementario3_matrizMagica	
	Definir matriz, n, num Como Entero
	
	n= 3
	Dimension matriz(n,n)
	
	llenar(matriz, n)
	mostrarM(matriz, n)
	Escribir "Decir que la matriz es magica es: ", comparar(matriz,n)
FinAlgoritmo


