SubProceso menu(dim)
	Definir vecA, vecB, vecC Como Entero
	Definir op Como Caracter
	Definir banA, banB, banC Como Logico
	Dimension vecA[dim], vecB[dim], vecC[dim]
	/// Necesito tener alguna manera de saber si los vectores fueron o no cargados alguna vez para controlar 
	/// En el procedimiento de muestra que no se intente mostrar un vector vacio
	banA = Falso
	banB = Falso
	banC = Falso
	Repetir
		Limpiar Pantalla
		Escribir "1 -> Llenar Vector A"
		Escribir "2 -> Llenar Vector B"
		Escribir "3 -> Llenar Vector C con la suma de los valores A y B"
		Escribir "4 -> Llenar Vector C con las restas de los valores B y A"
		Escribir "5 -> Mostrar "
		Escribir "6 -> Salir"
		Leer op
		Segun op
			"1":
				LlenarVector(vecA, banA)
			"2":
				LlenarVector(vecB, banB)
			"3":
				LlenarVectorSum(vecA, vecB, vecC, banA, banB, banC, dim)
			"4":
				LlenarVectorRes(vecA, vecB, vecC, banA, banB, banC, dim)
			"5":
				menuMostrar(vecA, vecB, vecC, banA, banB, banC)
			"6":
				Escribir "Saliendo del programa..."
			De Otro Modo:
				Escribir "La opcion indicada es INCORRECTA, presione una tecla para continuar."
				Esperar Tecla
		FinSegun
	Mientras Que op <> "6"
	
FinSubProceso

SubProceso LlenarVector(vec Por Referencia, bandera Por Referencia)
	Definir val Como Entero
	
	Para cada val De vec Hacer
		val = Aleatorio(-100, 100)
	FinPara
	bandera = Verdadero
	
FinSubProceso

SubProceso LlenarVectorSum(vecA, vecB, vecC Por Referencia, banA, banB, banC Por Referencia, dim)
	Definir i Como Entero
	
	Si banA == Verdadero Y banB == Verdadero
		Para i = 0 Hasta dim - 1 Hacer
			vecC[i] = vecA[i] + vecB[i]
		FinPara
		banC = Verdadero
	SiNo
		Escribir "Al menos un vector esta VACIO, presione una tecla para continuar."
		Esperar Tecla
	FinSi
	
FinSubProceso

SubProceso LlenarVectorRes(vecA, vecB, vecC Por Referencia, banA, banB, banC Por Referencia, dim)
	Definir i Como Entero
	
	Si banA == Verdadero Y banB == Verdadero
		Para i = 0 Hasta dim - 1 Hacer
			vecC[i] = vecB[i] - vecA[i]
		FinPara
		banC = Verdadero
	SiNo
		Escribir "Al menos un vector esta VACIO, presione una tecla para continuar."
		Esperar Tecla
	FinSi
	
FinSubProceso

SubProceso menuMostrar(vecA, vecB, vecC, banA, banB, banC)
	Definir opM Como Caracter
	
	Repetir
		Limpiar Pantalla
		Escribir "Ingrese el Vector que desea mostrar: "
		Escribir "1 -> Para mostrar el vector A"
		Escribir "2 -> Para mostrar el vector B"
		Escribir "3 -> Para mostrar el vector C"
		Escribir "4 -> Para mostrar el vector los Tres"
		Escribir "5 -> Para Salir"
		Leer opM
		Segun Mayusculas(opM)
			"1":
				Si banA == Verdadero
					Escribir "Vector A: " Sin Saltar
					mostrarVector(vecA)
					Escribir "Presione una tecla para continuar"
					Esperar Tecla
				SiNo
					Escribir "El vector esta VACIO, presione una tecla para continuar."
					Esperar Tecla
				FinSi
			"2":
				Si banB == Verdadero
					mostrarVector(vecB)
					Escribir "Presione una tecla para continuar"
					Esperar Tecla
				SiNo
					Escribir "El vector esta VACIO, presione una tecla para continuar."
					Esperar Tecla
				FinSi
			"3":
				Si banC == Verdadero
					mostrarVector(vecC)
					Escribir "Presione una tecla para continuar"
					Esperar Tecla
				SiNo
					Escribir "El vector esta VACIO, presione una tecla para continuar."
					Esperar Tecla
				FinSi
			"4":
				Si banA == Verdadero Y banB == Verdadero Y banC == Verdadero
					Escribir "Vector A: " Sin Saltar
					mostrarVector(vecA)
					Escribir "Vector B: " Sin Saltar
					mostrarVector(vecB)
					Escribir "Vector C: " Sin Saltar
					mostrarVector(vecC)
					Escribir "Presione una tecla para continuar"
					Esperar Tecla
				SiNo
					Escribir "Al menos un vector esta VACIO, presione una tecla para continuar."
					Esperar Tecla
				FinSi
			"5":
			De Otro Modo:
				Escribir "La opcion indicada es INCORRECTA, presione una tecla para continuar."
				Esperar Tecla
		FinSegun
	Mientras Que opM <> "5" 
FinSubProceso

SubProceso mostrarVector(vector)
	Definir  val Como Entero
	
	Para cada val De vector Hacer
		Escribir " ", val Sin Saltar
	FinPara
	Escribir ""
	
FinSubProceso


Algoritmo Comp_1
	Definir dim, vecA, vecB, vecC Como Entero
	
	Repetir
		Limpiar Pantalla
		Escribir "Ingrese la dimension de los vectores"
		Leer dim
		Si dim <= 0
			Escribir "La opcion indicada es INCORRECTA, presione una tecla para continuar."
			Esperar Tecla 
		FinSi
	Mientras Que dim <= 0
	
	menu(dim)
FinAlgoritmo
