// El sistema solicita al usuario que ingrese el mes y el importe por una compra, en los meses de septiembre, octubre y noviembre se efectua un 
// descuento del 10%. el programa devuelve por pantalla el monto a pagar.

Algoritmo Comp_8
	
	Definir mes Como Cadena
	Definir importe Como Entero
	
	Escribir "Ingrese el mes en el que se realiza la compra"
	Leer mes
	Escribir "ingrese el importe de la compra previo al descuento"
	Leer importe
	
	Si mes == "septiembre" O mes == "octubre" O mes == "noviembre"
		Escribir "Recibe descuento."
		importe = importe - (importe * .1)
	SiNo
		Escribir "NO recibe descuento."
	FinSi
	
	Escribir "el monto a pagar es: ", importe
	
FinAlgoritmo
