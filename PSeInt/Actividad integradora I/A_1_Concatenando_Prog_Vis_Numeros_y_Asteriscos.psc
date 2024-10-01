
// Realiza un programa que lea cinco números enteros, cada uno comprendido entre 1 y 20, 
// e imprima cada número seguido de una cantidad de asteriscos equivalente a su valor.

// de esta manera se muestran al final todas las entradas juntas en lugar
// de hacerlo de manera individual

Algoritmo A_1_Concatenando_Prog_Vis_Numeros_y_Asteriscos
	
	/// Se define entrada como cada entrada del usuario
	Definir entrada, i, j Como Entero
	Definir cad, frase Como Cadena
	
	frase = ""
	Para i=1 Hasta 5
		/// Se controla con un bucle repetitivo que la entrada sea correcta.
		Repetir
			Escribir "Para la entrada numero ",i," ingrese un valor entero positivo comprendido entre 1 y 20 inclusive."
			Leer entrada
			/// En caso de no ser correcta la entrada se le informa al usuario.
			Si entrada <= 0 O entrada >20
				Escribir "la entrada no es correcta."
			FinSi
		Mientras Que entrada <= 0 O entrada > 20
		/// Se fuerza que el valor numerico sea de dos cifras para poder controlar bien mas adelante como mostrar correctamente
		Si entrada < 10
			frase = frase + "0"
		FinSi
		/// Se concatenan los valores numericos como cadenas para mas adelante mostrarlos
		frase = frase + ConvertirATexto(entrada)		
	FinPara
	
	para i=0 Hasta 4
		/// En cada entrada al bucle se inicializa cad para volver a contar los *.
		cad = ""
		entrada = ConvertirANumero(Subcadena(frase,(i*2),(i*2)+1))
		para j=0 hasta entrada -1 
			cad = cad + "*"
		FinPara
		Escribir entrada, " : ", cad
	FinPara
	
FinAlgoritmo
