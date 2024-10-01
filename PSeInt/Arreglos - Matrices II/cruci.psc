
	Algoritmo cruci
		Definir matriz Como Caracter
		Definir filas, columnas, i, resultadoR Como Entero
		Definir palabra como cadena
		filas <- 10
		columnas <- 12
		Dimension matriz[filas,columnas]
		// Inicializar la matriz con asteriscos
		inicializarMatriz(matriz, filas, columnas)
		// mostrar la matriz con asteriscos
		mostrarMatriz(matriz, filas, columnas)		
		agregarPalabra(matriz, 1, "Vector")
		agregarPalabra(matriz, 2, "Matrix")
		agregarPalabra(matriz, 3, "Programa")
		agregarPalabra(matriz, 4, "Subprograma")
		agregarPalabra(matriz, 5, "Subproceso")
		agregarPalabra(matriz, 6, "Variable")
		agregarPalabra(matriz, 7, "Entero")
		agregarPalabra(matriz, 8, "Para")
		agregarPalabra(matriz, 9, "Mientras")
		agregarPalabra(matriz, 0, "casa")
		// mostrar la matriz con asteriscos
		mostrarMatriz(matriz, filas, columnas)
		acomodarPalabra(matriz, filas, columnas)
		Escribir "Matriz acomodada: "
		mostrarMatriz(matriz, filas, columnas)
FinAlgoritmo


Subproceso inicializarMatriz(matriz, filas, columnas)
	Definir i, j como entero
	Para i = 0 Hasta filas - 1 Hacer
		
		Para j = 0 Hasta columnas - 1 Hacer
			matriz[i, j] <- "*"
		FinPara
		
	FinPara
FinsubProceso

SubProceso mostrarMatriz(matriz, filas, columnas)
	Definir i,j Como Entero
	para i = 0 Hasta filas - 1 Hacer
		para j = 0 Hasta columnas - 1 Hacer
			Escribir matriz[i,j] , " | " Sin Saltar
			
		FinPara
		Escribir ""
	FinPara
finsubproceso


SubProceso agregarPalabra(matriz, filas, palabra)
	Definir j como entero
	Definir longitudPalabra Como Entero
	
	Si esValida(palabra) Entonces
		longitudPalabra <- Longitud(palabra)
		Para j <- 0 Hasta longitudPalabra-1
			matriz[filas, j] <- subcadena(palabra, j, j)
		FinPara
	SiNo
		Escribir "La palabra ingresada -> ", palabra , " <- es INCORRECTA"
	FinSi	
FinSubproceso

Funcion bandera <- esValida(palabra)
	Definir contador Como Entero
	Definir bandera Como Logico
	
	contador = 0
	bandera = Falso
	/// Si bandera es verdadero hay R en las primeras 5 posiciones, es valida
	/// Si el contador llega a 5 entonces ya no va a entrar en la matriz
	/// El contador se debe de mantener en margen
	mientras bandera == Falso Y contador <= 5 Y contador < Longitud(palabra)
		Si Mayusculas(Subcadena(palabra, contador, contador)) == "R"
			bandera = Verdadero
		FinSi
		contador = contador + 1
	FinMientras
FinFuncion

Funcion posicionR <- buscarR(matriz, filas)
	Definir posicionR Como Entero
	Definir j Como Entero
	j=0
	posicionR=-1
	Mientras posicionR == -1 y j <= 5 Hacer
		Si Mayusculas(matriz(filas,j)) == "R" Entonces
			posicionR = j
		FinSi
		j=j+1
	FinMientras
FinFuncion

SubProceso acomodarPalabra(matriz, filas, columnas)
	Definir i,j, posR, difR Como Entero
	Definir palabra Como Cadena
	
	Para  i = 0 Hasta filas -1 Hacer
		palabra = ""
		posR = buscarR(matriz, i)
		difR = 5 - posR   /// difR es la diferencia entre la posicion de la R y el inicio de la fila
		j = 0
		/// Se almacena la palabra en una variable de tipo cadena
		mientras matriz[i,j] <> "*" Y j < columnas -1 Hacer
			/// si empieza con * o no hay palabra o esta acomodada, si llega a un * se termino la palabra
			palabra = palabra + matriz[i,j] // "CASA" = "C" + "A" + "S" + "A"
			j = j + 1
		FinMientras
		
		Si Longitud(palabra) <> 0 Entonces
			Para j = 0 Hasta (Longitud(palabra) - 1 + difR)
				Si j < difR Entonces
					matriz[i,j] = "*"
				SiNo
					matriz[i,j] = Subcadena(palabra,0,0)
					palabra = Subcadena(palabra,1,longitud(palabra)-1)
				FinSi
			FinPara
		FinSi
	FinPara
FinSubProceso
