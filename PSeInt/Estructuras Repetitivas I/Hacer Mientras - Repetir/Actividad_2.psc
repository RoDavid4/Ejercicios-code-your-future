// El usuario debe de ingresar un codigo de usuario y contrase�a num�rica, ambos deben de ser enteros positivos
// El codigo valido es 1024 y la contrase�a 4567

Algoritmo Actividad_2
	
	Definir clave1, clave2, ingreso Como Entero

	clave1 = 1024
	clave2 = 4567
	
	Repetir
		Escribir "Ingrese cdigo de usuario."
		Repetir
			Leer ingreso
			Si ingreso <= 0
				Escribir "los datos deben ser numeros enteros positivos."
			FinSi
		Mientras Que ingreso <=0
		Si ingreso <> clave1
			Escribir "El codigo es INCORRECTO."
		FinSi
	Mientras Que ingreso <> clave1
	Repetir
		Escribir "ingrese contrase�a."
		Repetir
			Leer ingreso
			Si ingreso <= 0
				Escribir "los datos deben ser numeros enteros positivos"
			FinSi
		Mientras Que ingreso <=0
		Si ingreso <> clave2
			Escribir "La contrase�a es INCORRECTA."
		FinSi
	Mientras Que ingreso <> clave2
	
	Escribir "Se ha ingresado correctamente al sistema."
	
FinAlgoritmo
