
//Crea un programa que cumpla con las siguientes condiciones:
//	
//	Define y dimensiona una matriz de 5x5 para almacenar datos numéricos enteros.
//		
//		* Rellena la matriz de manera aleatoria con números comprendidos entre 10 y 40.
//		
//		* Permite al usuario ingresar un número para buscarlo dentro de la matriz.
//			
//		* Si el número se encuentra, muestra en pantalla un mensaje adecuado junto con las coordenadas en la matriz (fila y columna). 
//		  En caso de que el número esté repetido, solo se mostrará la posición de la primera ocurrencia.
//				
//		* Si el número no se encuentra, informa por pantalla.

SubProceso cargarMatriz(matriz Por Referencia)
	Definir val Como Entero
	
	Para Cada val De matriz 
		val = Aleatorio(10, 40)
	FinPara
FinSubProceso

SubProceso mostrarMatriz (matriz)
	Definir i,j Como Entero
	
	Para i <- 0 Hasta 4 Hacer
		para j <- 0 Hasta 4 Hacer
			Escribir matriz[i,j], " | " Sin Saltar
		FinPara
		Escribir ""
	FinPara	
FinSubProceso

SubProceso  buscarNumero(matriz, num, rta Por Referencia)
	Definir i, j Como Entero
	Definir bandera Como Logico
	
	/// si no lo encuentra devuelve -1 en la primer posicion, sino devuelve el par [i,j] donde lo enceuntra
	rta[0] = -1
	i = 0
	
	bandera = falso
	Mientras i < 5 Y bandera = Falso 
		/// En cada vuelta se debe de inicializar la variable de control interna
		j = 0
		Mientras j < 5 y bandera = Falso
			Si matriz[i,j] = num Entonces
				bandera = Verdadero
				rta[0] = i
				rta[1] = j
			FinSi
			j = j + 1
		FinMientras
		i = i + 1
	FinMientras
	
FinFuncion
Algoritmo Actividad3_BuscarEnMatriz5x5
	Definir matriz, num, vecRTA Como Entero
	Dimension matriz[5,5], vecRTA[2]
	
	cargarMatriz(matriz)
	mostrarMatriz(matriz)
	Escribir "Ingrese el numero que desea buscar "
	Leer num
	buscarNumero(matriz, num, vecRTA)
	mostrarMatriz(matriz)
	Si vecRTA[0] <> -1
		Escribir "El numero ", num, " esta en: [", vecRTA[0], " , " ,vecRTA[1] "]"
	SiNo
		Escribir "El numero no se encuentra"
	FinSi
	
FinAlgoritmo
