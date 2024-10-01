//El usuario ingresa dos valores de tipo entero en dos variables diferentes y el programa debe de intercambiar los valores e imprimirlos por pantalla

Algoritmo Actividad_5
	Definir valor1, valor2, aux Como Entero
	/// Carga de datos
	Escribir "Ingrese el primer valor numerico"
	Leer valor1
	Escribir "Ingrese el segundo valor numerico"
	Leer valor2
	Escribir "Se ingreso como primer valor: ", valor1, " y como segundo valor: ", valor2
	/// Intercambio de variables
	aux = valor1
	valor1 = valor2
	valor2 = aux
	Escribir "Intercambio realizado"
	/// Devolucion por pantalla
	Escribir "Ahora el primer valor es: ", valor1, " y el segundo valor: ", valor2
	
FinAlgoritmo
