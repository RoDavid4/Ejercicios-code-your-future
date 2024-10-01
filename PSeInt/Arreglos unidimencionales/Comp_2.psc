Funcion bandera <- insertarCaracter(vector, car, pos)
	Definir bandera Como Logico
	
	Si vector[pos] == " "
		vector[pos] = car
		bandera = Verdadero
	SiNo
		bandera = Falso
	FinSi
FinFuncion

SubProceso imprimirPorPantalla(vector)
	Definir val Como Caracter
	
	Para Cada val De vector HAcer
		Escribir val Sin Saltar
	FinPara
	Escribir ""
FinSubProceso

SubProceso menu
	Definir bandera Como Logico
	Definir op, car, vector Como Caracter
	Definir posicion Como Entero
	Dimension vector[20]
	
	Repetir
		Escribir "1 -> Cargar el vector "
		Escribir "2 -> Insertar un caracter en una posicion"
		Escribir "3 -> Imprimir por pantalla el vector"
		Escribir "4 -> Salir"
		leer op
		Segun op
			"1":
				cargarVector(vector)
			"2":
				Escribir "Ingrese un caracter a ingresar "
				Leer car
				Repetir
					Escribir "Ingrese en que posicion desea ingresarlo"
					Leer posicion
					Si posicion < 0 O posicion > 19
						Escribir "Posicion fuera de margen, ingrese un valor entre 0 y 19 inclusive"
					FinSi
				Mientras Que (posicion > 19) O (posicion < 0)
				bandera = insertarCaracter(vector, car, posicion)
				Si bandera 
					imprimirPorPantalla(vector)
				SiNo
					Escribir "No se pudo cargar el caracter en esa posicion ya que ya estaba ocupada por otro caracter"
				FinSi
			"3":
				imprimirPorPantalla(vector)
			"4":
				Escribir "Saliendo del programa..."
		FinSegun
	Mientras Que op <> "4"
FinSubProceso

SubProceso vaciarVector(vector)
	Definir val Como Caracter
	
	Para Cada val De vector Hacer
		val = ""
	FinPara
FinSubProceso

SubProceso cargarVector(vector)
	Definir contador Como Entero
	Definir frase Como Cadena
	
	/// para poder acceder a la LECTURA de todas las posiciones del vector necesito que esten inicializadas
	vaciarVector(vector)
	Escribir "ingrese una frase"
	Leer frase
	/// se inicializa en 0 para manejar las direcciones del arreglo
	contador = 0
	Mientras contador <= Longitud(frase) -1 Y contador <= 19
		vector[contador] = Subcadena(frase, contador, contador)
		contador = contador + 1
	FinMientras
FinSubProceso

Algoritmo Comp_2
	
	menu
		
FinAlgoritmo
