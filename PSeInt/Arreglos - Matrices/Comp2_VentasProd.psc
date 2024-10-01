
// Una empresa de venta de productos por correo desea realizar una estadística de las ventas de 
// cada uno de sus productos a lo largo de una semana, distribuyendo los 5 productos en los 5 días hábiles. Se desea conocer:

	/// El total de ventas por cada día de la semana.
	/// El total de ventas de cada producto a lo largo de la semana.
	/// El producto más vendido en cada semana.
	/// El nombre, el día de la semana y la cantidad del producto más vendido.

/// 		|  LUN	|  MAR  |  MIE  |  JUE	|  VIE	|	Total Prod	|
//-------------------------------------------------------------------
/// Prod 1	|		|		|		|		|		|				|
//-------------------------------------------------------------------
/// Prod 2	|		|		|		|		|		|				|
//-------------------------------------------------------------------
/// Prod 3	|		|		|		|		|		|				|
//-------------------------------------------------------------------
/// Prod 4	|		|		|		|		|		|				|
//-------------------------------------------------------------------
/// Prod 5	|		|		|		|		|		|				|
//-------------------------------------------------------------------
///Total Sem|		|		|		|		|		|				|
//-------------------------------------------------------------------
///Prod + V	|		|		|		|		|		|				|


SubProceso menu
	Definir matriz, opAUX, ventRep Como Entero
	Definir op, opINT Como Caracter
	
	Dimension matriz[7,6], ventRep[5]
	Repetir
		Limpiar Pantalla
		Escribir "Elija una opcion: "
		Escribir "1 -> Para cargar datos"
		Escribir "2 -> "
		Escribir "3 -> Para ver la tabla de ventas semanales"
		Escribir "4 -> Para verificar las ventas de UN REPRESENTANTE"
		Escribir "5 -> Para verificar las ventas TOTALES"
		Escribir "6 -> Para SALIR"
		Leer op
		Segun op
			"1":
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"2":
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"3":
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"4":
				Escribir "Presione una tecla para continuar"
				Esperar Tecla
			"5":
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

Algoritmo Comp2_VentasProd
	
FinAlgoritmo
