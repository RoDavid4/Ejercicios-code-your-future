
//Crea una funci�n que convierta una temperatura de grados Celsius a grados Fahrenheit. 
//Luego, en el programa principal, solicita al usuario una temperatura en Celsius y utiliza la funci�n para convertirla y mostrar el resultado. 
//F�rmula de conversi�n: F = C * 9/5 + 32

Funcion resultado <- celAFah(num)
	Definir resultado Como Real
	
	resultado = (num * 9/5) + 32
	
FinFuncion

Algoritmo CompCelAFah
	Definir num Como Real
	
	Escribir "Ingrese la temperatura en grados Celsius"
	Leer num
	
	Escribir "La temperatura en grados Fahrenheit es: ", celAFah(num)
	
FinAlgoritmo
