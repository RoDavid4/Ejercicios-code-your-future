
// Procesar una secuencia de caracteres ingresada por el usuario y terminada en punto, luego codifique la palabra de la siguiente manera:
// a -> @
// e -> #
// i -> $
// o -> %
// u -> *

SubProceso codificar(frase, codificada Por Referencia)
	
	Definir letra Como Caracter
	Definir i Como Entero
	
	/// La frase debe de terminar en "."
	Si Subcadena(frase, Longitud(frase)-1, Longitud(frase)-1) == "."
		/// Se inicializa la variable codificada que se pasa por referencia
		codificada = ""
		/// Se recorre la frase caracter a caracter para codificarla
		Para i = 0 Hasta Longitud(frase) - 1
			letra = Subcadena(frase,i,i)
			/// Segun sea el caracter econtrado se guarda modificado o no en la variable "codificada"
			Segun letra
				"a":
					codificada = codificada + "@"
				"e":
					codificada = codificada + "#"
				"i":
					codificada = codificada + "$"
				"o":
					codificada = codificada + "%"
				"u":
					codificada = codificada + "*"
				De Otro Modo:
					codificada = codificada + letra
			FinSegun
		FinPara		
	SiNo
		codificada = "La frase no respeta el formato valido"
	FinSi
		
FinSubProceso

SubProceso decodificar(codificada, decodificada Por Referencia)
	
	Definir letra Como Caracter
	Definir i Como Entero
	
	/// La frase debe de terminar en "."
	Si Subcadena(codificada, Longitud(codificada)-1, Longitud(codificada)-1) == "."
		/// Se inicializa la variable decodificada que se pasa por referencia
		decodificada = ""
		/// Se recorre la frase caracter a caracter para decodificarla
		Para i = 0 Hasta Longitud(codificada) - 1
			letra = Subcadena(codificada,i,i)
			/// Segun sea el caracter econtrado se guarda modificado o no en la variable "decodificada"
			Segun letra
				"@":
					decodificada = decodificada + "a"
				"#":
					decodificada = decodificada + "e"
				"$":
					decodificada = decodificada + "i"
				"%":
					decodificada = decodificada + "o"
				"*":
					decodificada = decodificada + "u"
				De Otro Modo:
					decodificada = decodificada + letra
			FinSegun
		FinPara		
	SiNo
		decodificada = "La frase no respeta el formato valido"
	FinSi
	
FinSubProceso

Algoritmo codificarFrase
	
	Definir frase, fraseCod, fraseDeco Como Cadena
	
	Escribir "Ingrese la frase a codificar"
	Leer frase
	codificar(frase, fraseCod)
	Escribir "La frase codificada es: ", fraseCod
	Escribir "Decodificando..." 
	decodificar(fraseCod, fraseDeco)
	Escribir "La frase DECODIFICADA es: ", fraseDeco
	
FinAlgoritmo
