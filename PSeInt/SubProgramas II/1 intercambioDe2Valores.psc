
// Intercambia el valor de dos variables de tipo ENTERO

SubProceso interC(num1 Por Referencia, num2 Por Referencia) 
	
	Definir aux Como Entero
	
	aux = num1
	num1 = num2
	num2 = aux
	
FinSubProceso


Algoritmo intercambioDe2Valores
	
	Definir num1, num2 Como Entero
	
	Escribir "Ingrese dos valores para ser intercambiados"
	Leer num1, num2
	Escribir "Primer valor: ", num1
	Escribir "Segundo valor: ", num2
	interC(num1, num2)
	Escribir "-------------------------------------------------------------------------"
	Escribir "Valores intercambiados"
	Escribir "-------------------------------------------------------------------------"
	Escribir "Nuevo primer valor: ", num1
	Escribir "Nuevo segundo valor: ", num2
	
FinAlgoritmo
