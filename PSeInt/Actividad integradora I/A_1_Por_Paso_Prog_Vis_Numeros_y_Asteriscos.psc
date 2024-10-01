// Realiza un programa que lea cinco números enteros, cada uno comprendido entre 1 y 20, 
// e imprima cada número seguido de una cantidad de asteriscos equivalente a su valor.

Algoritmo A_1_Por_Paso_Prog_Vis_Numeros_y_Asteriscos
	
	/// Se define entrada como cada entrada del usuario
	Definir entrada, i, j, contador Como Entero
	Definir cad Como Cadena
	
	
	Para i=1 Hasta 5
		/// En cada entrada al bucle se inicializa cad para volver a contar los *.
		cad = ""
		/// Se controla con un bucle repetitivo que la entrada sea correcta.
		Repetir
			Escribir "Para la entrada numero ",i," ingrese un valor entero positivo comprendido entre 1 y 20 inclusive."
			Leer entrada
			/// En caso de no ser correcta la entrada se le informa al usuario.
			Si entrada <= 0 O entrada >20
				Escribir "la entrada no es correcta."
			FinSi
		Mientras Que entrada <= 0 O entrada > 20
		/// Se concatenan asteriscos hasta el valor ingresado.
		Para j=1 Hasta entrada
			cad = cad + "*"
		FinPara
		/// Se muestra por pantalla la cadena formada.
		Escribir entrada, " : ", cad
	FinPara
	
FinAlgoritmo
