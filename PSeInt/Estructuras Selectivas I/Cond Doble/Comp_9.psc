// se reciben dos numeros, si ambos son pares se devuelve por pantalla "Ambos n�meros son pares" caso contrario se devuelve
// "Los n�meros no son pares, o uno de ellos no es par"

Algoritmo Comp_9
	
	Definir num1, num2 Como Entero
	
	Escribir "ingrese el primer numero"
	Leer num1
	Escribir "ingrese el segundo numero"
	Leer num2
	
	Si num1 mod 2 == 0 Y num2 mod 2 == 0
		Escribir "Ambos n�meros son pares" 
	SiNo
		Escribir "Los n�meros no son pares, o uno de ellos no es par"
	FinSi
	
	
FinAlgoritmo
