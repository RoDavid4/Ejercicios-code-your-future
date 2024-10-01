
// Una distribuidora de Nescafé cuenta con 4 representantes que recorren toda Argentina para ofrecer sus productos. 
// Para la gestión administrativa, el país está dividido en cinco zonas: Norte, Sur, Este, Oeste y Centro.
// Mensualmente, la empresa registra los datos de ventas de los representantes en cada zona y 
//recopila diversas estadísticas sobre su desempeño.

// Se requiere un programa que lea el monto de las ventas de los representantes en cada zona y realice los siguientes cálculos:
	
	/// Total de ventas de una zona especificada por el usuario.
	/// Total de ventas de un representante seleccionado por el usuario en cada una de las zonas.	
	/// Total de ventas de todos los representantes.

/// 		|  N(0)	|  S (1) | 	E(2) | O(3)	| C(4)	|
//---------------------------------------------------
/// Rep 0	|		|		|		|		|		|
//---------------------------------------------------
/// Rep 1	|		|		|		|		|		|
//---------------------------------------------------
/// Rep 2	|		|		|		|		|		|
//---------------------------------------------------
/// Rep 3	|		|		|		|		|		|

SubProceso cargaAleatoria(matriz)
	Definir val Como Entero
	
	Para Cada val De matriz Hacer
		val = Aleatorio(10,99)
	FinPara
FinSubProceso

/// Total de ventas de una zona especificada por el usuario.
funcion suma <- ventaZona(matriz, zona)
	Definir i, suma Como Entero
	/// la ZONA es una COLUMNA de la matriz
	suma = 0
	Para i = 0 Hasta 3 Hacer
		suma = suma + matriz[i, zona]
	FinPara
FinSubProceso

SubProceso  ventaRepresentante(matriz, rep, vector)
	Definir j Como Entero
	/// el REPRESENTANTE es una FILA de la matriz
	Para j = 0 Hasta 4 Hacer
		vector[j] = matriz[rep,j]
	FinPara
FinSubProceso

Funcion suma <- totalVentas(matriz)
	Definir val, suma Como Entero
	
	suma = 0
	Para Cada val De matriz
		suma = suma + val
	FinPara
FinSubProceso

SubProceso mostrarM(matriz)
	Definir i,j Como Entero
	Escribir "                  N |  S |  E |  O |  C |"
	para i = 0 Hasta 3 Hacer
		Escribir "Representante ", i, ": " Sin Saltar
		para j = 0 Hasta 4 Hacer
			Escribir matriz[i,j] , " | " Sin Saltar
			
		FinPara
		Escribir ""
	FinPara
finsubproceso

SubProceso menu
	Definir matriz, opAUX, ventRep Como Entero
	Definir op, opINT Como Caracter
	
	Dimension matriz[4,5], ventRep[5]
	Repetir
		Limpiar Pantalla
		Escribir "Elija una opcion: "
		Escribir "1 -> Para cargar datos"
		Escribir "2 -> Para ver la tabla de ventas"
		Escribir "3 -> Para verificar ventas de una determinada ZONA"
		Escribir "4 -> Para verificar las ventas de UN REPRESENTANTE"
		Escribir "5 -> Para verificar las ventas TOTALES"
		Escribir "6 -> Para SALIR"
		Leer op
		Segun op
			"1":
				cargaAleatoria(matriz)
				Escribir "Datos cargados"
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"2":
				Limpiar Pantalla
				mostrarM(matriz)
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"3":
				Repetir
					Limpiar Pantalla
					Escribir"Ingrese la zona que desea corroborar: "
					Escribir "0 -> Para Zona NORTE"
					Escribir "1 -> Para Zona SUR"
					Escribir "2 -> Para Zona ESTE"
					Escribir "3 -> Para Zona OESTE"
					Escribir "4 -> Para Zona CENTRO"
					Leer opINT
				Mientras Que opINT <> "0" Y opINT <> "1" Y opINT <> "2" Y opINT <> "3" Y opINT <> "4"
				opAUX = ConvertirANumero(opINT)
				Escribir "En la zona indicada las ventas fueron por un valor de: ", ventaZona(matriz, opAUX)
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"4":
				Repetir
					Limpiar Pantalla
					Escribir"Ingrese el representante: "
					Escribir "0 -> Para Representante 0"
					Escribir "1 -> Para Representante 1"
					Escribir "2 -> Para Representante 2"
					Escribir "3 -> Para Representante 3"
					Leer opINT
				Mientras Que opINT <> "0" Y opINT <> "1" Y opINT <> "2" Y opINT <> "3" 
				opAUX = ConvertirANumero(opINT)
				ventaRepresentante(matriz, opAUX, ventRep)
				Escribir "Ventas Zona NORTE: ->   ",ventRep[0]
				Escribir "Ventas Zona SUR:   ->   ",ventRep[1]
				Escribir "Ventas Zona ESTE:  ->   ",ventRep[2]
				Escribir "Ventas Zona OESTE: ->   ",ventRep[3]
				Escribir "Ventas Zona CENTRO:->   ",ventRep[4]
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"5":
				Escribir "Las ventas totales fueron por un valor de: ", totalVentas(matriz)
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"6":
				Escribir "Saliendo... "
			De otro modo:
				Escribir "El dato ingresado es INCORRECTO"
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
		FinSegun
	Mientras Que op <> "6"
	
FinSubProceso

Algoritmo Comp1_Nescafe
	menu
FinAlgoritmo
