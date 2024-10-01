// Se recibe un numero de 3 cifras correspondiente a una formacion válida de fútbol 11, se devuelve por pantalla si la formacion es capicua o no, 
// caso que la formacion no sea valida, es decir que la suma de defensores + medios + delanteros sea mayor a 10 se devuelve el mensaje de error.

Algoritmo Comp_1
	
	Definir num Como Entero
	
	Escribir "Ingrese un número de tres cifras correspondiente a una formacion de fútbol 11"
	Leer num
	/// (TRUNC(num/100)) MOD 10 -> Centena / (TRUNC(num/10)) MOD 10 -> Decena / num MOD 10 -> Unidad
	/// Se toma como correcta una formacion de tres cifras, de la manera Def/Med/Del donde la suma de sus cifras debe de ser EXACTAMENTE 10.
	SI num MOD 10 + (TRUNC(num/10)) MOD 10 + (TRUNC(num/100)) MOD 10 <> 10
		/// Si la suma de las cifras es DISTINTA de 10 el numero NO es aceptado.
		Escribir "No es una formacion posible para FUTBOL 11"
	SiNo 
		/// Si la suma de las cifras NO es DISTINTA de 10 el numero es aceptado para su analisis.
		/// Si la Centena es igual a la Unidad en un numero de tres cifras entonces es capicua.
		SI (num MOD 10) == ((TRUNC(num/100)) MOD 10)
			Escribir "Es una formacion capicua"
		SiNo
			Escribir "No es una formacion capicua"
		FinSi
	FinSi
	
FinAlgoritmo
