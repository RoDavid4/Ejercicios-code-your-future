

Algoritmo comp6FibonacciRECURSIVO
	Definir num Como Entero
	
	Escribir "Ingrese un numero para calcular su valor en Fibonacci"
	Leer num
	Escribir "El valor de ", num, " en la serie de Fibonacci es: ",fibonacciRec(num)
	
FinAlgoritmo

Funcion val <- fibonacciR(num)
	Definir val Como Entero
	
	/// En esta version de Fibonacci la regla es:
	/// f(x) = 
	///         1 si 					x <= 1
	///			f(x-1) + f(x-2) si 		x > 1
	
	/// f(0) = 1, f(1) = 1, f(2) = f(1) + f(0) = 2, f(3) = 3, f(4) = 5, f(5) = 8, ... , f(x) = f(x-1) + f(x-2)
	///     1,       1,        1 + 1  =  2,            3,        5,        8,          
	
		/// Fib(1) es 1, por lo tanto es un caso base
		Si num <= 1
			val = 1
			/// Si no es 1 entonces Fib(x) = Fib(x-1) + Fib(x-2)
		SiNo
			val = fibonacciR(num - 1) + fibonacciR(num - 2)
		FinSi
		
FinFuncion

Funcion val <- fibonacciRec(num)
	Definir val Como Entero
	
	/// En la Sucesion de Fibonacci la regla es:
	/// f(x) = 
	///			0 si					x = 0
	///         1 si 					x = 1
	///			f(x-1) + f(x-2) si 		x > 1
	
	/// f(0) = 0, f(1) = 1, f(2) = f(1) + f(0) = 1, f(3) = 2, f(4) = 3, f(5) = 5, ... , f(x) = f(x-1) + f(x-2)
	///     0,       1,        0 + 1  =  1,            2,        3,        5,
	
	/// Fib(0) es 0, por lo tanto es un caso base
	Si num == 0
		val = 0
	SiNo
		/// Fib(1) es 1, por lo tanto es un caso base
		Si num ==1
			val = 1
			/// Si no es ni 0 ni 1 entonces Fib(x) = Fib(x-1) + Fib(x-2)
		SiNo
			val = fibonacciRec(num - 1) + fibonacciRec(num - 2)
		FinSi
	FinSi
	
FinFuncion