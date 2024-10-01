
// Un proedimiento que permita realizar la division entre dos numeros y muestre el cociente y el resto usando el metodo de restas sucesivas

SubProceso  restSuc(divisor, dividendo, residuo Por Referencia, cociente Por Referencia)
	
	cociente = 0
	/// mientras el divisor sea mayor o igual al dividendo se continua con las restas sucesivas
	Mientras divisor >= dividendo
		divisor = divisor - dividendo
		cociente = cociente + 1
	FinMientras
	
	residuo = divisor
	
FinSubProceso



Algoritmo restasSucesivas
	
	Definir divisor, dividendo, cociente, residuo Como Entero
	
	Escribir "Ingrese el divisor y el dividendo para realizar la operación"
	Leer divisor, dividendo
	
	restSuc(divisor, dividendo, residuo, cociente)
	Escribir "El residuo es: ", residuo, " y el cociente es: ", cociente
	
FinAlgoritmo
