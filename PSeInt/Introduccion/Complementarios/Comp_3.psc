// El usuario ingresa una cantidad de dias y se debe de devolver por pantallas el valor en Horas, Minutos y Segundos

Algoritmo Comp_3
	Definir dias Como Entero
	
	/// Lectura de valores
	Escribir "Ingrese un valor en Días"
	Leer dias
	
	/// Devolucion
	Escribir "Son: ", dias * 24, " Horas"
	Escribir "Son: ", dias * 1440, " Minutos"
	Escribir "Son: ", dias * 86400, " Segundos"
FinAlgoritmo
