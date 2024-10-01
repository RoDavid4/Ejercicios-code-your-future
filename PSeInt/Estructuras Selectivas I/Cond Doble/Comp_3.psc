// Se recibe una cadena, si la misma tiene exactamente 4 caracteres se le concatena "!", caso contrario se le concatena "?"
// Al final se devuelve por pantalla la cadena

Algoritmo Comp_3
	
	Definir nombre Como Cadena
	
	Escribir "Ingrese nompre para la competencia"
	Leer nombre
	/// Longitud recibe como parametro una cadena y devuelve la cantidad de caracteres,
	/// Concatenar recibe como parametros dos cadenas para devolver una concatenacion de la primera seguido de la segunda.
	Si Longitud(nombre) == 4
		nombre = Concatenar(nombre, "!")
	SiNo
		nombre = Concatenar(nombre, "?")
	FinSi
	
	Escribir nombre
FinAlgoritmo
