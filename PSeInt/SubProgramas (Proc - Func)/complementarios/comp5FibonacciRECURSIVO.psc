
Algoritmo comp5FibonacciRECURSIVO
	Definir num Como Entero
	
	Escribir "Ingrese un numero para calcular su valor en Fibonacci"
	Leer num
	Escribir "El valor de ", num, " en la serie de Fibonacci es: ",fibonacciR(num)
	
FinAlgoritmo

Funcion val <- fibonacciR(num)
	Definir val Como Entero
	
	/// Fib(0) es 0, por lo tanto es un caso base
	Si num == 0
		val = 0
	SiNo
		/// Fib(1) es 1, por lo tanto es un caso base
		Si num ==1
			val = 1
		/// Si no es ni 0 ni 1 entonces Fib(x) = Fib(x-1) + Fib(x-2)
		SiNo
			val = fibonacciR(num - 1) + fibonacciR(num - 2)
		FinSi
	FinSi
	
FinFuncion

Funcion val <- fibonacci(num)
	Definir val, valAnt, valAux, i Como Entero
	
	valAnt = 0
	/// 0 1 1 2 3 5 8 13 
	/// Fib(0) es 0, por lo tanto es un caso base
	Para i = 0 Hasta num
		Si i == 0
			val = 0
		SiNo
			/// Fib(1) es 1, por lo tanto es un caso base
			Si i == 1
				val = 1
				/// Si no es ni 0 ni 1 entonces Fib(x) = Fib(x-1) + Fib(x-2)
			SiNo
				valAux = val
				val = val + valAnt
				valAnt = valAux
			FinSi
		FinSi
	FinPara
		
FinFuncion

	