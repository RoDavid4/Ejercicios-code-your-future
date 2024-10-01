// se reciben dos numeros, si ambos son pares se devuelve por pantalla "Ambos números son pares" caso contrario se devuelve
// "Los números no son pares, o uno de ellos no es par"

Algoritmo Comp_9
	
	Definir num1, num2 Como Entero
	
	Escribir "ingrese el primer numero"
	Leer num1
	Escribir "ingrese el segundo numero"
	Leer num2
	
	Si num1 mod 2 == 0 Y num2 mod 2 == 0
		Escribir "Ambos números son pares" 
	SiNo
		Escribir "Los números no son pares, o uno de ellos no es par"
	FinSi
	
	
FinAlgoritmo
