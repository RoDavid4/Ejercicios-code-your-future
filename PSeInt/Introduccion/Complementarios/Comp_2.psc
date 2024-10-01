// Se ingresa un numero de dos cifras y se debe de devolver el numero invertido, es decir si la entrada es 32 se devuelve 23

Algoritmo Comp_2
	Definir num Como Entero
	Escribir "Ingrese el numero de dos digitos a invertir"
	Leer num
	/// x MOD y devuelve el valor ENTERO resultante del RESTO de la division de x por y, en este caso al dividir por 10 si la entrada fuera 32 devolveria 2
	/// ya que x = 32 e y = 10, 32/10 = 3,2 por lo tanto el resto es 2
	/// TRUNC(OPERACION) devuelve la parte entera de la operacion, de nuevo 32/10 = 3,2, entonces devuelve 3
	/// Para obtener el resultado al primer valor se lo multiplica por 10 para que este ubicado en la decena y se le suma el segundo valor, el entero de la division
	Escribir ((num MOD 10) * 10) + TRUNC(num/10)
FinAlgoritmo
