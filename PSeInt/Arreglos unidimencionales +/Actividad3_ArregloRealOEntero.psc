
//  Desarrolla un programa que inicialice un arreglo de números, permitiéndote elegir el tipo y tamaño del arreglo. 
//  Puedes generar datos aleatorios para poblar el arreglo o asignar valores manualmente. 
//	Posteriormente, crea una función que calcule y devuelva la diferencia entre el valor más pequeño y el valor más grande de este arreglo. 
//	Para cumplir con las necesidades de la actividad, se sugiere dividir el proceso en subprocesos o funciones, 
//	esto te permitirá tener un código más modular y fácil de entender, cumpliendo con las necesidades de la actividad y 
//	facilitando futuras modificaciones o expansiones del programa.
		
SubProceso inicializarVector(vector Por Referencia, tam, tipo)
	Definir i Como Entero
	
	Si Mayusculas(tipo) == "E" 
		Para i <- 0 Hasta tam -1
			vector[i] = Aleatorio(-100, 100)
		FinPara
	SiNo
		Para i <- 0 Hasta tam -1
			vector[i] = Aleatorio(-100, 100) * Aleatorio(1, 1000) / 1000
		FinPara
	FinSi
	
FinSubProceso

Funcion dif <- difEntreMinMax(vector)
	Definir val, dif, min, max Como Real
	
	min = vector[0]
	max = vector[0]
	Para Cada val De vector
		Si val < min
			min = val
		SiNo
			si val > max
				max = val
			FinSi
		FinSi
	FinPara
	dif = max - min
FinSubProceso

SubProceso imprimirVector(vector)
	Definir val Como Real
	
	Para Cada val De vector
		Escribir val, " "
	FinPara
	Escribir ""
FinSubProceso


Algoritmo Actividad3_ArregloRealOEntero
	Definir vectorEnteros, tam Como Entero
	Definir vectorReales Como Real
	Definir tipo Como Caracter
	
	Repetir
		Escribir "Ingrese el tipo de vector que desea generar, "
		Escribir "-> E para generar un vector de numeros ENTEROS"
		Escribir "-> R para generar un vector de numeros REALES"
		Leer tipo
	Mientras Que Mayusculas(tipo) <> "E" Y Mayusculas(tipo) <> "R"
	
	Repetir
		Escribir "Ingrese el tamaño del vector que desea generar "
		Leer tam
	Mientras Que tam <= 0
	
	Si Mayusculas(tipo) == "E" Entonces
		Dimension vectorEnteros[tam]
		inicializarVector(vectorEnteros, tam, tipo)
		Escribir "El vector quedo de la manera: "
		imprimirVector(vectorEnteros)
		Escribir "La diferencia entre el Mayor y Menor valor es: ", difEntreMinMax(vectorEnteros)
	SiNo
		Dimension vectorReales[tam]
		inicializarVector(vectorReales, tam, tipo)
		Escribir "El vector quedo de la manera: "
		imprimirVector(vectorReales)
		Escribir "La diferencia entre el Mayor y Menor valor es: ", difEntreMinMax(vectorReales)
	FinSi
	
FinAlgoritmo
