// El sistema tiene como contraseña "EUREKA", el usuario tiene como maximo 3 intentos, si falla 3 veces se muestra un mensaje indicando que se han agotado
// los intentos, en caso contrario se msotrar un mensaje indicando que se ha accedido al sistema correctamente

Algoritmo Actividad_1
	
	Definir clave, ingreso Como Cadena
	Definir contador Como Entero
	
	contador = 0
	clave = "EUREKA"
	ingreso = ""
	
	Repetir
		Escribir "Ingrese la contraseña."
		Leer ingreso
		contador = contador + 1 
		Si ingreso <> "EUREKA"
			Escribir "Contraseña INCORRECTA, le quedan ", 3 - contador, " intentos."
		SiNo
			Escribir "Se ha accedido al sistema correctamente."
		FinSi
	Mientras Que contador < 3 Y ingreso <> "EUREKA"
	
	Si contador = 3
		Escribir "Se han agotado los intentos, no se puede acceder al sistema."
	FinSi
FinAlgoritmo
