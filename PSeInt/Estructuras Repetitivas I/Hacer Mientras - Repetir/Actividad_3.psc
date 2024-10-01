// El usuario debe de ingresar un numero entero positivo, luego se le consulta si quiere seguir y se repite hasta que el usuario responda
// "n" o "N"

Algoritmo Actividad_3
	
	Definir ingreso, suma Como Entero
	Definir consulta Como Caracter
	
	suma = 0
	
	Repetir
		Repetir
			Escribir "Ingrese un número ENTERO POSITIVO."
			Leer ingreso
			Si ingreso <= 0
				Escribir "los datos deben ser numeros enteros positivos."
			FinSi
		Mientras Que ingreso <=0
		suma = suma + ingreso
		Escribir "Ingrese n o N para salir, cualquier otra entrada para continuar ingresando numeros."
		Leer consulta
	Mientras Que Mayusculas(consulta) <> "N"
	
	Escribir "La suma de los numeros ingresados es: ", suma
	
FinAlgoritmo
