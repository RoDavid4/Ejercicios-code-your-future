Algoritmo Actividad_1
	
	Definir pedido Como Caracter
	
	Escribir "Buen d�a, ingrese T si desea tomar T� o C si desea tomar Caf�"
	Leer pedido
	
	Segun pedido Hacer
		"T":
			Escribir "ingrese S si desea agregar rodajas de lim�n o N si no lo desea"
			Leer  pedido
			Segun pedido Hacer
				"S":
					Escribir "Disfrute su T� con Lim�n"
				"N":
					Escribir "Disfrute su T� SIN Lim�n"
				De Otro Modo:
					Escribir "el dato ingresado es INCORRECTO"
			FinSegun
		"C":
			Escribir "Ingrese C si prefire un cortado o S si lo prefiere Solo"
			Leer  pedido
			Segun pedido Hacer
				"C":
					Escribir "ingrese A si lo prefiere con leche Animal o V si lo prefiere con leche Vegetal"
					Leer pedido
					Segun pedido Hacer
						"V":
							Escribir "Discfrute se Cortado con leche Vegetal"
						"A":
							Escribir "Disfrute su Cortado con leche Animal"
						De Otro Modo:
							Escribir "el dato ingresado es INCORRECTO"
					FinSegun
				"S":
					Escribir "Disfrute su Caf�"
				De Otro Modo:
					Escribir "el dato ingresado es INCORRECTO"
			FinSegun
			
		De Otro Modo:
			Escribir "el dato ingresado es INCORRECTO"
	FinSegun
	
FinAlgoritmo
