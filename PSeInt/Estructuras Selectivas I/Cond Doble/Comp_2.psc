// La entrada al cine tieen un valor de 5 dolares por persona, con un descuento del 30% para menores de 12 a�os (no inclusive)
// Recibir la edad y devolver por pantalla el valor de la entrada

Algoritmo Comp_2
	
	Definir edad Como Entero
	
	Escribir"Ingrese la edad para calcular el monto"
	Leer edad
	
	si edad < 12 Entonces
		Escribir "El precio de la entrada es de ", 5 - 5*.3," D�lares"
	SiNo
		Escribir "El precio de la entrada es de 5 D�lares"
	FinSi
	
FinAlgoritmo
