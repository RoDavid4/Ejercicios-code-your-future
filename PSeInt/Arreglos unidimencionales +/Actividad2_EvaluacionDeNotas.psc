
//Crea un vector que contenga 100 notas de 100 supuestos estudiantes, con valores entre 0 y 10 generadas aleatoriamente.. 
//Luego, de acuerdo a las notas almacenadas en el arreglo, el programa debe indicar cuántos estudiantes son:
//Deficientes: 0-3	
//Regulares: 4-6
//Buenos: 7-8
//Excelentes: 9-10

Algoritmo Actividad2_EvaluacionDeNotas
	
	Definir notas, deficientes, regulares, buenos, excelentes, nota Como Entero
	Dimension notas[100]
	
	deficientes = 0
	regulares = 0
	buenos = 0 
	excelentes = 0
	
	Para Cada nota De notas
		nota = Aleatorio(0,10)
		Segun nota
			0 O 1 O 2 O 3 O 4:
				deficientes = deficientes + 1
			5 O 6 O 7:
				regulares = regulares + 1
			8 O 9:
				buenos = buenos + 1
			De Otro Modo:
				excelentes = excelentes + 1
		FinSegun
	FinPara
	
	Escribir "Estudiantes con notas deficientes (0 - 3): ->  ", deficientes
	Escribir "Estudiantes con notas regulares (4 - 6):   ->  ", regulares
	Escribir "Estudiantes con notas buenas (7 - 8):      ->  ", buenos
	Escribir "Estudiantes con notas excelentes (9 - 10): ->  ", excelentes
FinAlgoritmo
