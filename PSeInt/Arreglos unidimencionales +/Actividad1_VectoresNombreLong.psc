
// Actividad 1
// Crea un programa que solicite al usuario ingresar el tama�o deseado para dos vectores. 
//	El primero almacenar� nombres de personas como cadenas, mientras que el segundo vector 
//	contendr� la longitud de cada uno de los nombres. Luego, se mostrar�n en pantalla los nombres junto con su respectiva longitud.


Algoritmo Actividad1_VectoresNombreLong
	
	Definir nombres Como Cadena
	Definir longitudes, tam, i Como Entero
	
	Escribir "Ingrese el tama�o de los vectores"
	Leer tam
	Dimension nombres[tam], longitudes[tam]
	
	Para i <- 0 Hasta tam - 1
		Escribir "Ingrese un Nombre"
		Leer nombres[i]
		longitudes[i] = longitud(nombres[i])
	FinPara
	Limpiar Pantalla
	Para i <- 0 Hasta tam - 1
		Escribir "Nombre: ", nombres[i], ", longitud: ", longitudes[i], " caracteres"
	FinPara
FinAlgoritmo
