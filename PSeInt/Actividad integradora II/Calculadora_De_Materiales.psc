Algoritmo Calculadora_De_Materiales
	menu
FinAlgoritmo

SubProceso menu
	Definir op Como Caracter
	Repetir
		Escribir "1 Calcular muro de ladrillo"
		Escribir "2 Calcular viga de hormigon"
		Escribir "3 Calcular columnas de hormigón"
		Escribir "4 Calcular contrapisos"
		Escribir "5 Calcular techo"
		Escribir "6 Calcular pisos"
		Escribir "7 Calcular pintura"
		Escribir "8 Calcular iluminación"
		Escribir "9 Salir"
		Leer op
		Segun op
			"1":
				Escribir "------------------CALCULAR MURO-------------------"
				Escribir ""
				calcularMuro
			"2":
				Escribir "------------------CALCULAR VIGA-------------------"
				Escribir ""
				calcularViga
			"3":
				Escribir "------------------CALCULAR COLUMNA-------------------"
				Escribir ""
				calcularColumna
			"4":
				Escribir "------------------CALCULAR CONTRAPISOS-------------------"
				Escribir ""
				calcularContrapisos
			"5":
				Escribir "------------------CALCULAR TECHO-------------------"
				Escribir ""
				calcularTecho
			"6":
				Escribir "------------------CALCULAR PISOS-------------------"
				Escribir ""
				calcularPisos
			"7":
				Escribir "------------------CALCULAR PINTURA-------------------"
				Escribir ""
				calcularPintura
			"8":
				Escribir "------------------CALCULAR ILUMINACION-------------------"
				Escribir ""
				calcularIluminacion
			"9":
				Escribir "Finalizando el programa..."
			De Otro Modo:
				Escribir "Entrada incorrecta, ingrese una opcion del 1 al 9 inclusive: "
		FinSegun
	Mientras Que op <> "9"
FinSubProceso

Funcion volumen<- calcularVolumen (alto, ancho, largo)
	definir volumen como Real
	volumen = alto*ancho*largo
FinFuncion

Funcion superficie<- calcularSuperficie (alto, largo)
	definir superficie como Real
	superficie = alto*largo
FinFuncion

SubProceso calcularMuro
	Definir espesor,alto, largo, cemento, arena, ladrillos, superficie Como Real
	Escribir "Ingrese los datos de alto y"," ancho en metros "
	Leer alto, largo
	superficie =calcularSuperficie(alto, largo)
	Escribir "La superficie es: ", superficie
	
	Repetir
		
		Escribir "Ingrese el espesor del muro, de 30 o de 20"
		Leer espesor
		Segun espesor
			20:
				cemento = superficie * 10.9
				arena = superficie * 0.09
				ladrillos = superficie * 90
			30:
				cemento = superficie * 15.2
				arena = superficie * 0.115
				ladrillos = superficie * 120
			De Otro Modo:
				Escribir "Opcion invalida"
		FinSegun
	Mientras Que espesor <>20 y espesor <>30
	
	Escribir "La cantidad de cemento necesaria es de :", cemento, " kg"
	Escribir "La cantidad de arena necesaria es de :", arena, " m3"
	Escribir "La cantidad de ladrillos necesaria es de :", ladrillos " unidades"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularViga
	Definir largo, cemento, arena, piedras, hierro8, hierro4 Como Real
	Escribir "Ingrese el largo de la viga en metros: "
	Leer largo
	cemento = largo * 9
	arena = largo * 0.02
	piedras = largo * 0.02
	hierro8 = largo * 4
	hierro4 = largo * 3
	
	Escribir "La cantidad de cemento necesaria es de: ", cemento, " kg"
	Escribir "La cantidad de arena necesaria es de: ", arena, " m3"
	Escribir "La cantidad de piedras necesaria es de: ", piedras " m2"
	Escribir "La cantidad de hierro del 8 necesaria es de: ", hierro8, " m"
	Escribir "La cantidad de hierro del 4 necesaria es de: ", hierro4 " m"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularColumna
	Definir largo, cemento, arena, piedras, hierro10, hierro4 Como Real
	Escribir "Ingrese el largo de la columna en metros: "
	Leer largo
	cemento = largo * 7.5
	arena = largo * 0.016
	piedras = largo * 0.016
	hierro10 = largo * 6
	hierro4 = largo * 3
	
	Escribir "La cantidad de cemento necesaria es de: ", cemento, " kg"
	Escribir "La cantidad de arena necesaria es de: ", arena, " m3"
	Escribir "La cantidad de piedras necesaria es de: ", piedras " m2"
	Escribir "La cantidad de hierro del 10 necesaria es de: ", hierro10, " m"
	Escribir "La cantidad de hierro del 4 necesaria es de: ", hierro4 " m"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularContrapisos
	Definir espesor,ancho,largo, volumen, cemento, arena, piedras Como Real
	Escribir "Ingrese el espesor del contrapiso en metros: "
	Leer espesor
	Escribir "Ingrese el ancho y el largo del contrapiso en metros:"," "
	Leer ancho, largo
	volumen = calcularVolumen(ancho, largo, espesor)
	cemento = volumen * 105
	arena = volumen * 0.45
	piedras = volumen * 0.9
	
	Escribir "La cantidad de cemento necesaria es de: ", cemento, " kg"
	Escribir "La cantidad de arena necesaria es de: ", arena, " m3"
	Escribir "La cantidad de piedras necesaria es de: ", piedras " m3"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularTecho
	Definir ancho, espesor, largo, volumen, cemento, arena, piedras, hierro8, hierro6 Como Real
	
	Escribir "Ingrese el espesor del techo en metros: "
	Leer espesor
	Escribir "Ingrese el ancho y el largo del techo en metros:"," "
	Leer ancho, largo
	volumen = calcularVolumen(ancho, largo, espesor)
	cemento = volumen * 33
	arena = volumen * 0.072
	piedras = volumen * 0.072
	hierro8 = volumen * 7
	hierro6 = volumen * 4
	
	Escribir "La cantidad de cemento necesaria es de: ", cemento, " kg"
	Escribir "La cantidad de arena necesaria es de: ", arena, " m3"
	Escribir "La cantidad de piedras necesaria es de: ", piedras " m2"
	Escribir "La cantidad de hierro del 8 necesaria es de: ", hierro8, " m"
	Escribir "La cantidad de hierro del 6 necesaria es de: ", hierro6 " m"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularPisos
	Definir ancho, largo, superficie Como Real
	
	Escribir "Ingrese el ancho y el largo del piso en metros: "
	Leer ancho, largo
	superficie = calcularSuperficie(ancho, largo)
	
	Escribir "La cantidad de piso requerido teniendo en cuenta recortes es de: ", superficie*1.1, " m2"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularPintura
	Definir superficie Como Real
	
	Escribir "Ingrese la superficie del muro en metros: "
	Leer superficie
	
	Escribir "La cantidad de pintura requerida es de: ", superficie/6, " litros"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

SubProceso calcularIluminacion
	Definir superficie Como Real
	
	Escribir "Ingrese la superficie de la habitación en metros: "
	Leer superficie
	
	Escribir "La iluminación requerida es de: ", superficie*0.2, " metros cuadrados de fuentes de iluminacion"
	
	Escribir ""
	Escribir "Pulsar tecla para continuar"
	Esperar Tecla
	Limpiar Pantalla
	
FinSubProceso

