// Calcular la remuneracion total que recibira un vendedor a fin de mes
// El vendedor recibe un salario base mas un 10% adicional por comision sobre sus ventas

Algoritmo Comp_1
	/// Definicion de variables
	Definir salario, venta, comision Como Real
	Definir contador, cantidad Como Entero
	
	/// Carga de datos
	Escribir "ingrese el valor del salario del empleado"
	Leer salario
	Escribir "ingrese la cantidad de ventas que se va a cargar al sistema"
	Leer cantidad
	
	/// Inicializado de ariables auxiliares
	contador = 0
	comision = 0 
	
	/// Carga de ventas y calculo de comisiones individuales
	Repetir
		Escribir "ingrese el valor de la venta número ", contador + 1, " que realizo el empleado"
		Leer venta
		comision = comision + (venta * .1)
		Escribir "la comision por la venta numero ", contador+1 ," es de: ", venta * .1
		contador = contador + 1 
	Mientras Que contador < cantidad
	
	/// Devolucion 
	Escribir "el empleado recibira: ", salario + comision
		
FinAlgoritmo
