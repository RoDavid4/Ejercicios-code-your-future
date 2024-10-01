
// Realizar una Funcion recursiva que calcule la suma de los primeros N enteros

Funcion sum <- sumatoria(num)
	
	Definir sum Como Entero
	
	/// el valor debe de ser un entero mayor que 0, si el numero es 0 o negativo la funcion devuelve -1 (error)
	si num > 0
		Si num <> 1
			sum = num + sumatoria(num-1)
		SiNo
			sum = 1
		FinSi
	SiNo
		sum = -1
	FinSi
	
FinFuncion

Algoritmo sumatoriaHastaN
	
	Definir num, i Como Entero
	
	Escribir "Ingrese un valor entero positivo para calcular la sumatoria desde 1 hasta ese valor"
	Leer num
	Escribir  "La sumatoria de 1 hasta ", num , " es: ",sumatoria(num) 
	
FinAlgoritmo
