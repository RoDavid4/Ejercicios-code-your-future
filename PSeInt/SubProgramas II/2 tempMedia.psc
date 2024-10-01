
// Se calcula la tempperatura media de un dia a partir de la temperatura maxima y minima,
// En el Algoritmo principal se solicita la temperatura minima y maxima de n dias y se calculan sus medias
 
SubProceso prom(min, max, media Por Referencia)
	
	/// media es una variable pasada por referencia, por lo tanto se refleja fuera del precedimiento
	media = (min + max) /2
	
FinSubProceso

Algoritmo tempMedia
	
	Definir cant, i Como Entero
	Definir min, max, media Como Real	
	Dimension min[10], max[10], media[10]
	
	Escribir "Ingrese la temperatura de cuantos dias se desea calcular (MAX 10)"
	Leer cant
	
	/// La cantidad esta dada por la capacidad de los arreglos utilizados en el Algoritmo 
	Si cant <= 10 Y cant > 0
		Para i = 0 Hasta cant-1 Hacer
			Escribir "Ingrese las temperaturas MIN / MAX del dia ",i+1
			Leer min[i], max[i]
			
		FinPara
		
		Para i<-0 Hasta cant-1 Hacer
			prom(min[i], max[i], media[i])
			Escribir "La de media temperatura del dia ", i+1, " es: ",media[i], ", con una MIN de ",min[i], " y una MAX de ",max[i]
		FinPara
	SiNo
		Escribir "La cantidad esta fuera del rango permitido por el Algoritmo"
	FinSi
	
	
	
FinAlgoritmo
