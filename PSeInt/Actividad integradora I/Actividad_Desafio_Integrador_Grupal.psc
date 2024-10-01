
Algoritmo Actividad_Desafio_Integrador_Grupal
	
	Definir id, password, entrada, opVenta Como Cadena
	Definir login Como Logico
	Definir contador, saldo, i, botella, saldoParcial, precioUnitario Como Entero
	
	login = Falso
	id = "Albus_D"
	password = "caramelosDeLimon"
	saldo = 0
	
	Repetir
		Escribir "Ingrese nombre de usuario."
		Leer entrada
		/// Si el nombre de usuario es CORRECTO se pide la contraseña, con un maximo de 3 intentos
		Si entrada = id
			contador = 0
			/// El bucle se repite hasta que el contador llegue a 3 intentos equivocados o
			/// hasta que la contraseña sea correcta
			Mientras contador < 3 Y login == Falso Hacer
				Escribir "Ingrese contraseña."
				Leer entrada
				contador = contador + 1
				Si entrada = password
					login = Verdadero
				SiNo
					Escribir "Contraseña equivocada, le quedan ",3 - contador, " intentos"
				FinSi
			FinMientras
		FinSi
		/// Si login tiene como valor Falso entonces no es correcto el login, 
		/// caso contrario es correcto y continúa la ejecucion del programa
		Si login == Falso
			Escribir "Los datos ingresados son INCORRECTOS."
		SiNo
			Escribir "Login correcto."
		FinSi		
	Mientras Que login = Falso
				/// Menu del programa
	Repetir
		
		/// Se muestran las opciones del Menu
		Escribir "Ingrese:"
		Escribir "I para INGRESAR botellas"
		Escribir "C para Consultar saldo"
		Escribir "S para Salir"
		Leer entrada
		
		Segun Mayusculas(entrada)
			"I":
				Escribir "¿Cuántas botellas desea ingresar?"
				Leer contador
				saldoParcial = 0
				
				para i=1 Hasta contador
					/// Se genera el peso de la botella de manera aleatoria en el intervalo [100,3000]
					botella = Aleatorio(100,3000)
					
					Si botella <= 500
						precioUnitario = 50
					SiNo
						Si botella <= 1500
							precioUnitario = 125
						SiNo
							precioUnitario = 200
						FinSi
					FinSi
					SaldoParcial = saldoParcial + precioUnitario
					
					Escribir "la botella numero ",i," pesa ",botella," gramos y su valor es de ", precioUnitario
				FinPara
				
				Escribir "El valor de las botellas es de ", saldoParcial
				
				Repetir					
					Escribir "ingrese 1 para concretar la venta o 2 para cancelar"
					Leer opVenta
					si opVenta <> "1" Y opVenta <> "2"
						Escribir "Entrada INCORRECTA"
					FinSi
				Mientras Que opVenta <> "1" Y opVenta <> "2"
				
				Si opVenta == "1" Entonces
					saldo = saldo + saldoParcial
				SiNo
					Escribir "Devolviendo material"
				FinSi
			
			"C":
				Escribir "El saldo acumulado es de: ", saldo
			De Otro Modo:
				Escribir "Opción INCORRECTA"
		FinSegun
		
	Mientras Que Mayusculas(entrada) <> "S"
	
	
FinAlgoritmo
