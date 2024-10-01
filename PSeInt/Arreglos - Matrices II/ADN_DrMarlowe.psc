Algoritmo ADN_DrMarlowe
	/// Debe tener una longitud de 9 caracteres para ser almacenada en una matriz de 3x3
	/// o de 16 caracteres para ser almacenada en una matriz de 4x4, respectivamente.
	
	/// Los caracteres de la muestra deben ser exclusivamente A, B, C o D para ser considerada válida.
	Definir secuencia como cadena
	definir matriz Como Caracter
	
	repetir
		Escribir "Escriba la secuencia"
		Leer secuencia
	Mientras Que !esValida(Mayusculas(secuencia))
	
	si Longitud(secuencia) == 9 Entonces
		Dimension matriz[3,3]
	SiNo
		Dimension matriz[4,4]
	FinSi
	
	generarMatriz(matriz, Mayusculas(secuencia))
	verificarSecuencia(matriz, Raiz(Longitud(secuencia)))
FinAlgoritmo

Funcion valida <- esValida (secuencia)
	definir i como entero
	definir valida Como Logico
	valida = Verdadero
	i = 0
	
	si Longitud(secuencia) == 16 O Longitud(secuencia) == 9 Entonces
		mientras valida Y i < Longitud(secuencia)
			si Subcadena(secuencia, i, i) <> "A" Y Subcadena(secuencia, i, i) <> "B" Y Subcadena(secuencia, i, i) <> "C" Y Subcadena(secuencia, i, i) <> "D" Entonces
				valida = falso
			FinSi
			i = i + 1
		FinMientras
	SiNo
		valida = falso
	FinSi
FinFuncion

SubProceso generarMatriz(matriz, secuencia)
	definir i, j, long Como Entero
	long = raiz(Longitud(secuencia))
	
	para i=0 hasta long - 1 Hacer
		para j=0 hasta long - 1 Hacer
			matriz[i,j] = Subcadena(secuencia, 0, 0)
			secuencia = Subcadena(secuencia, 1, Longitud(secuencia) - 1)
			Escribir matriz[i,j], " | " Sin Saltar
		FinPara
		Escribir ""
	FinPara
FinSubProceso

SubProceso verificarSecuencia(matriz, long)
	definir i, j como entero
	definir letra, letraO Como Caracter
	definir flag Como Logico
	flag = Verdadero
	letra = matriz[0,0]
	letraO = matriz[0, Long - 1]
	
	para i=0 hasta long - 1 Hacer
		para j=0 hasta long - 1 Hacer
			si i = j Entonces
				si matriz[i,j] <> letra
					flag = falso
				FinSi
				si matriz[i, long - 1 - j] <> letraO
					flag = falso
				FinSi
			FinSi
		FinPara
	FinPara
	
	si flag Entonces
		Escribir "¡Felicidades! La muestra contiene patrones específicos en sus diagonales"
	SiNo
		Escribir "La secuencia no cumple para ser un ADN"
	FinSi
	
FinSubProceso
