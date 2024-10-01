
// Diseña un algoritmo que permita al usuario ingresar una frase.  Deberás asegurarte de que la longitud de la frase no exceda los 100 caracteres;
// en caso de superar este límite, se solicitará al usuario que vuelva a ingresar la frase hasta que cumpla con esta condición. 

// Una vez ingresada la frase, el programa separará los caracteres en dos vectores: uno para almacenar exclusivamente las vocales (A-E-I-O-U)
// y otro para las consonantes, así como para los caracteres especiales y los espacios. 

// Los elementos en cada vector se acomodarán inicialmente por orden de aparición en la frase.
// Además, se requiere la implementación de un subprograma que permita mostrar los vectores creados,
// así como el recuento total de elementos en cada uno de ellos.

SubProceso discriminarVocalesConsonantes(frase, vocales, consonantes, cantV Por Referencia, cantC Por Referencia) /// por default los vectores se pasan por referencia
	Definir i Como Entero
	Definir valM Como Caracter
	
	cantV = 0
	cantC = 0
	para i <- 0 Hasta Longitud(frase) -1 Hacer
		valM = Mayusculas(Subcadena(frase, i, i)) 
		Si valM == "A" O valM == "E" O valM == "I" O valM == "O" O valM == "U"
			vocales[cantV] = Subcadena(frase, i, i)
			cantV = cantV + 1
		SiNo
			consonantes[cantC] = Subcadena(frase, i, i)
			cantC = cantC + 1
		FinSi
	FinPara
FinSubProceso

SubProceso mostrarVector(vector, cant)
	Definir val Como Caracter
	Definir i Como Entero
	
	Para i <- 0 Hasta cant - 1 Hacer
		Escribir vector[i] Sin Saltar
	FinPara
	Escribir ""
	Escribir "La cantidad de letras y/o simbolos es: ", cant
FinSubProceso

Algoritmo TrabajandoUnaFrase
	Definir frase Como Cadena
	Definir vocales, consonantes Como Caracter
	Definir cantV, cantC Como Entero
	
	cantV = 0
	cantC = 0
	Repetir
		Limpiar Pantalla
		Escribir "Ingrese una frase"
		Leer frase
		Si Longitud(frase) > 100
			Escribir "La longitud es superior a la permitida, presione una tecla para continuar."
			Esperar Tecla
		FinSi
	Mientras Que Longitud(frase) > 100
	Dimension vocales[Longitud(frase)], consonantes[Longitud(frase)]
	discriminarVocalesConsonantes(frase, vocales, consonantes, cantV, cantC)
	Escribir "La frase es: ", frase
	Escribir "La cantidad de caracteres es: ", Longitud(frase)
	Escribir "El vector de vocales es: "
	mostrarVector(vocales, cantV)
	Escribir "El vector de consonantes es: "
	mostrarVector(consonantes, cantC)
FinAlgoritmo
