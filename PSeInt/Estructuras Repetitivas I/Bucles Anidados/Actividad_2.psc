// ingrese un valor entero que reprecentara la altura de una escalera invertida generada con "*"

Algoritmo Actividad_2
	
	Definir altura, i, j, ancho Como Entero
	Definir escalon Como Cadena
		
	Escribir "Ingrese altura deseada"
	Leer altura
	ancho = altura
	
	Para i = 1 Hasta altura
		escalon = ""
		Para j = 1 Hasta ancho
			escalon = escalon + "*"
		FinPara
		ancho = ancho - 1
		Escribir escalon
	FinPara
	
FinAlgoritmo
