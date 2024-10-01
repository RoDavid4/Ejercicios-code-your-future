
//Diseña un programa que trabaje con un vector de datos lógicos de tamaño 5. El programa debe realizar las siguientes tareas:
//	
//	Llenar el vector con valores lógicos (verdadero o falso) ingresados por el usuario.
//	
//	Mostrar en pantalla el vector original.
//	
//	Determinar y mostrar un mensaje en pantalla indicando si todos los elementos del vector son verdaderos.
//		
//	Determinar y mostrar un mensaje en pantalla indicando si al menos uno de los elementos del vector es verdadero, 
//	junto con la posición en la que se encuentra.
//		
//	Determinar y mostrar un mensaje en pantalla indicando si todos los elementos del vector son falsos.
//				
//	Determinar y mostrar un mensaje en pantalla indicando si al menos uno de los elementos del vector es falso, 
//	junto con la posición en la que se encuentra.
		
SubProceso menu
	Definir op Como Caracter
	Definir vector, bandera, resuL Como Logico
	Definir resuE Como Entero
	Dimension vector[5]
	
	bandera = Falso
	Repetir
		Limpiar Pantalla
		Escribir "1 -> Cargar vector"
		Escribir "2 -> Imprimir vector por pantalla"
		Escribir "3 -> ¿Son todos Verdaderos?"
		Escribir "4 -> ¿Hay algún verdadero?"
		Escribir "5 -> ¿Son todos Falsos?"
		Escribir "6 -> ¿Hay algún Falso?"
		Escribir "7 ->  Salir"
		Leer op
		
		Segun op
			"1":
				cargarVector(vector, bandera)
				Escribir "Vector cargado, presione una tecla para continuar."
				Esperar Tecla
			"2":
				Si bandera Entonces
					imprimirVector(vector)
				SiNo
					Escribir "El vector no ha sido cargado."
				FinSi
				Escribir "Presione una tecla para continuar."
				Esperar Tecla
			"3":
				Si bandera Entonces
					resuL = todosVerdaderos(vector)
					Si resuL
						Escribir "Son todos Verdaderos"
					SiNo
						Escribir "No son todos verdaderos"
					FinSi
				SiNo
					Escribir "El vector no ha sido cargado."
				FinSi
				Escribir "Presione una tecla para continuar."
				Esperar Tecla
			"4":
				Si bandera Entonces
					resuE = hayVerdadero(vector)
					Si resuE <> -1
						Escribir "El primer valor Verdadero esta en la posicion: ", resuE
					SiNo
						Escribir "No hay valores Verdaderos"
					FinSi
				SiNo
					Escribir "El vector no ha sido cargado."
				FinSi
				Escribir "Presione una tecla para continuar."
				Esperar Tecla
			"5":
				Si bandera Entonces
					resuL = todosFalsos(vector)
					Si resuL
						Escribir "Son todos Falsos"
					SiNo
						Escribir "No son todos Falsos"
					FinSi
				SiNo
					Escribir "El vector no ha sido cargado."
				FinSi
				Escribir "Presione una tecla para continuar."
				Esperar Tecla
			"6":
				Si bandera Entonces
					resuE = hayFalso(vector)
					Si resuE <> -1
						Escribir "El primer valor Falso esta en la posicion: ", resuE
					SiNo
						Escribir "No hay valores Falsos"
					FinSi
				SiNo
					Escribir "El vector no ha sido cargado."
				FinSi
				Escribir "Presione una tecla para continuar."
				Esperar Tecla
			"7":
				Escribir "Saliendo del programa..."
		FinSegun
	Mientras Que op <> "7"
	
FinSubProceso

SubProceso cargarVector(vector Por Referencia, bandera Por Referencia)
	Definir val Como Logico
	Definir aux Como Entero
	
	Para Cada val De vector
		/// Para generar valores logicos aleatorios genero una variable auxiliar que vale aleatoriamente 0 o 1
		aux = Aleatorio(0,1)
		Si aux = 0 Entonces
			val = Falso
		SiNo
			val = Verdadero
		FinSi
	FinPara
	bandera = Verdadero
FinSubProceso

SubProceso imprimirVector(vector)
	Definir val Como Logico
	
	Para Cada val De vector
		Escribir val, " " Sin Saltar
	FinPara
	Escribir ""
FinSubProceso

Funcion resultado <- todosVerdaderos(vector)
	Definir resultado Como Logico
	Definir contador Como Entero
	
	contador = 0
	resultado = Verdadero
	Mientras resultado = Verdadero Y contador < 5
		Si vector[contador] == Falso
			resultado = Falso
		FinSi
		contador = contador + 1
	FinMientras
	
FinFuncion
/// Devuelve la posicion de la primera aparicion de Verdadero SI LA HAY
Funcion resultado <- hayVerdadero(vector)
	Definir resultado, contador Como Entero
	/// Si no se encuentra se devuelve -1 como mensaje de "error"
	contador = 0
	resultado = -1
	Mientras resultado = -1 Y contador < 5
		Si vector[contador] == Verdadero
			resultado = contador
		FinSi
		contador = contador + 1
	FinMientras
FinFuncion

Funcion resultado <- todosFalsos(vector)
	Definir resultado Como Logico
	Definir contador Como Entero
	
	contador = 0
	resultado = Verdadero
	Mientras resultado = Verdadero Y contador < 5
		Si vector[contador] == Verdadero
			resultado = Falso
		FinSi
		contador = contador + 1
	FinMientras
FinFuncion

Funcion resultado <- hayFalso(vector)
	Definir resultado, contador Como Entero
	/// Si no se encuentra se devuelve -1 como mensaje de "error"
	contador = 0
	resultado = -1
	Mientras resultado = -1 Y contador < 5
		Si vector[contador] == Falso
			resultado = contador
		FinSi
		contador = contador + 1
	FinMientras
FinFuncion

Algoritmo Actividad4_vectorLogico
	
	menu
FinAlgoritmo
