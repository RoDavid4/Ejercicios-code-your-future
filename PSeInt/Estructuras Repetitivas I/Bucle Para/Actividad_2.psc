Algoritmo Actividad_2
	
	Definir frase, aux Como Cadena
	Definir i Como Entero
	
	aux = ""
	Escribir "ingrese una frase, la misma sera devuelta por pantalla con un espacio entre cada caracter"
	Leer frase
	
	Para i = 0 Hasta Longitud(frase) -1 Hacer		
		aux = aux + Subcadena(frase,i,i) + " "
	FinPara
	
	Escribir "Frase original: ",frase
	Escribir "Frase modificada: ",aux
	
FinAlgoritmo
