// El usuario ingresa un valor en METROS y se devuelve por pantalla el valor en centímetros, milímetros y pulgadas
Algoritmo Actividad_3
	
	Definir metros Como Real
	Escribir "Ingrese la cantidad de metros a calcular"
	Leer metros
	
	Escribir metros, "Es equivalente a ", metros * 100, " centímetros" 
	Escribir metros, "Es equivalente a ", metros * 1000, " milímetros"
	Escribir metros, "Es equivalente a ", (metros * 100) / 2.54, " pulgadas"
	
FinAlgoritmo
