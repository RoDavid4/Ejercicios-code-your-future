
// Se ingresa un valor entero y se debe devolver la cantidad de digitos que lo componen

Algoritmo A_2_Contador_De_Digitos
	
	Definir val, contador Como Entero
	
	/// Siempre inicializar las variables de control de tipo contador.
	contador = 0
	
	Escribir "Ingrese un valor entero"
	Leer val
	
	/// Tomo el valor 0 por considerarlo un entero de UN digito, si no lo considero
	/// Como un caso especial el programa devolveria que tiene 0 digitos
	Si val <> 0
		Mientras val <> 0
			contador = contador + 1
			/// Trunc devuelve la parte ENTERA de un numero, en esta caso al dividir por 10 
			/// y truncar se reduce en 1 la cantidad de digitos del valor ingresado y 
			/// se suma 1 en el contador total de digitos
			val = Trunc(val / 10)
		FinMientras
	SiNo
		/// Si el usuario ingreso 0 la cantidad de digitos es 1
		contador = 1
	FinSi
	
	Escribir "El valor ingresado tiene ", contador ," digitos."
	
FinAlgoritmo
