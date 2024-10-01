// El usuario ingresa 3 notas, para aprobar el promedio debe de ser igual o superior a 70

Algoritmo Comp_7
	
	Definir suma, nota, i Como Entero
	
	suma = 0
	Para i Desde 0 Hasta 2
		Escribir "Ingrese nota"
		Leer nota
		suma = suma + nota
	FinPara
	
	Si suma / 3 >= 70
		Escribir "El alumno aprueba el curso"
	SiNo
		Escribir "El alumno reprueba el curso"
	FinSi
	
FinAlgoritmo
