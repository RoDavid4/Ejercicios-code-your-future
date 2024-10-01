Algoritmo es_Multiplo
	
	Definir num1, num2 Como Entero
	
	Escribir "Ingrese dos numeros, se devolvera si el primero es multiplo del segundo"
	Leer num1, num2
	
	Escribir esMultiplo(num1, num2)
	
FinAlgoritmo

Funcion bandera <- esMultiplo(num1, num2)
	
	Definir bandera Como Logico
	Si num1 <> 0 Y num2 <> 0
		bandera = (num1 mod num2 == 0)
	SiNo
		bandera = Falso
	FinSi
	
	
FinFuncion
