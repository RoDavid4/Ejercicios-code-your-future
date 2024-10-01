
//Crea un vector que contenga 100 notas de 100 supuestos estudiantes, con valores entre 0 y 10 generadas aleatoriamente.. 
//Luego, de acuerdo a las notas almacenadas en el arreglo, el programa debe indicar cuántos estudiantes son:
//	
//Deficientes: 0-3
//	
//Regulares: 4-6
//	
//Buenos: 7-8
//	
//Excelentes: 9-10

SubProceso cargaArreglo(notas Por Referencia)
	Definir nota Como Entero
	
	Para Cada nota De notas
		nota = Aleatorio(0,10)
	FinPara	
FinSubProceso

SubProceso imprimirArreglo(notas Por Referencia)
	Definir nota Como Entero
	
	Para Cada nota De notas
		Escribir nota, " " Sin Saltar
	FinPara	
	Escribir ""
FinSubProceso

SubProceso contadorNotas(def Por Referencia, reg Por Referencia, buenos Por Referencia, exc Por Referencia, notas)
	Definir i Como Entero
	
	def = 0
	reg = 0
	buenos = 0
	exc = 0
	
	Para i <- 0 Hasta 99 Hacer
		Segun notas[i]
			0, 1, 2, 3:
				def = def + 1
			4, 5, 6:
				reg = reg +1
			7, 8:
				buenos = buenos + 1
			De Otro Modo:
				exc = exc + 1
		FinSegun
	FinPara
FinSubProceso

Algoritmo EvaluacionDeNotas
	Definir notas, def, reg, buenos, exc Como Entero
	Dimension notas[100]
	
	cargaArreglo(notas)
	Escribir "El arreglo quedo de la manera: "
	imprimirArreglo(notas)
	contadorNotas(def, reg, buenos, exc, notas)
	Escribir "La cantidad de notas deficientes es: ", def
	Escribir "La cantidad de notas regulares es: ", reg
	Escribir "La cantidad de notas buenas es: ", buenos
	Escribir "La cantidad de notas excelentes es: ", exc
FinAlgoritmo
