// El programa lee un numero entero (que reprecenta el tamaño del lado) y genera un cuadrado de asteriscos con ese tamaño, 
// los asteriscos solo se ubican en los bordes de el cuadrado, no así en el interior.

Algoritmo Actividad_3
	
	Definir lado, i, j Como Entero
	Definir escalon Como Cadena
	
	Escribir "Ingrese la longitud del lado del cuadrado a dibujar"
	Leer lado
	
	para i=1 Hasta lado
		escalon = ""
		para j=1 Hasta lado
			/// Siempre los bordes van a estar ubicados cuando j (borde lateral) sea 1 o lado, lo mismo pasa con i (bordes superior e inferior)
 			Si i == 1 o i == lado o j== 1 o j == lado
				escalon = escalon + "*"
			SiNo
				escalon = escalon + " "
			FinSi
		FinPara
		Escribir escalon
	FinPara
	
FinAlgoritmo
