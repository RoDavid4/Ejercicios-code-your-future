
Algoritmo Es_Impar
	Definir num Como Entero
	
	Escribir "Ingrese un número para verificar si es par o impar"
	Leer num
	Si (esImpar(num))
		Escribir "El número es IMPAR"
	SiNo
		Escribir "El número es PAR"
	FinSi
FinAlgoritmo

Funcion bandera <- esImpar(num)
	Definir bandera Como Logico
 
	/// si el resto de la division por dos es 1 entonces el numero es impar	
		bandera = (num MOD 2 == 1) 
	
FinFuncion
	