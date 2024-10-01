Algoritmo Actividad_2
	
	Definir def, sDef Como Entero
	
	Escribir "Ingrese cantidad de tornillos DEFECTUOSOS"
	Leer def
	Escribir "Ingrese cantidad de tornillos SIN DEFECTOS"
	Leer sDef
	
	Si def < 200
		Si sDef > 10000 Entonces
			Escribir "El Grado de eficiencia es 8"
		SiNo
			Escribir "El Grado de eficiencia es 6"
		FinSi	
	SiNo
		Si sDef > 10000 Entonces
			Escribir "El Grado de eficiencia es 7"
		SiNo
			Escribir "El Grado de eficiencia es 5"
		FinSi
	FinSi

	FinAlgoritmo
