Algoritmo Actividad_1
	
	Definir arr, i Como Entero
	Dimension arr[5]
	
	para i <- 0 Hasta 4
		Escribir "Ingrese un numero"
		Leer arr[i]
	FinPara
	Limpiar Pantalla
	Escribir "Los numeros son: "
	para i <- 0 Hasta 4
		Escribir arr[i], " " Sin Saltar
	FinPara
	Escribir ""
	Escribir "Es decir: "
	para i <- 0 Hasta 4
		Escribir "En posicion: ", i," -> ", arr[i]
	FinPara
	
FinAlgoritmo
