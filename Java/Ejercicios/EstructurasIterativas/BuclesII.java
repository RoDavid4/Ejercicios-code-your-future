package Java.Ejercicios.EstructurasIterativas;

import java.util.Scanner;
import java.util.InputMismatchException;
public class BuclesII {

    public static void menuWhile() {

        /*
         * ✏️ Actividad: Menú interactivo con while
         * Crea un menú interactivo con 5 opciones para que el usuario elija, como por
         * ejemplo:
         * 
         * Comprar producto.
         * 
         * Realizar devolución.
         * 
         * Ver mis pedidos.
         * 
         * Preguntas frecuentes.
         * 
         * Salir.
         * 
         * Luego, solicita al usuario que elija una opción del menú mostrado en
         * pantalla. El menú debe seguir apareciendo hasta que el usuario elija la
         * opción para salir del programa. En este ejercicio, no es necesario que las
         * opciones del menú realicen acciones reales, simplemente muestra un mensaje
         * que indique qué opción eligió el usuario.
         */
        System.out.println("\033\143");
        int opcion = 0;
        Scanner scan = new Scanner(System.in);

        while (opcion != 5) {
            System.out.println("Elija una opción");
            System.out.println("1-Comprar producto");
            System.out.println("2-Realizar devolución");
            System.out.println("3-Ver mis pedidos");
            System.out.println("4-Preguntas frecuentes");
            System.out.println("5-Salir");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste comprar producto");

                    break;
                case 2:
                    System.out.println("Seleccionaste realizar devolución");

                    break;
                case 3:
                    System.out.println("Seleccionaste ver mis pedidos");

                    break;
                case 4:
                    System.out.println("Seleccionaste preguntas frecuentes");

                    break;
                case 5:
                    System.out.println("Seleccionaste salir");

                    break;

                default:
                    System.out.println("Selecciona una opción correcta");
                    break;
            }
        }
        scan.close();
    }

    public static void adivNum() {
        /*
         * ✏️ Actividad: Adivinando un número
         * Escribe un programa que genere un número aleatorio entre 1 y 20, y muestra
         * por consola un mensaje pidiéndote que adivines ese número utilizando un bucle
         * do-while. El programa te indicará si el número que ingresas es mayor o menor
         * que el número aleatorio, y seguirá pidiéndote que adivines hasta que lo hagas
         * correctamente.
         */
        Scanner scanner = new Scanner(System.in);
        int numeroAleatorio = (int) (Math.random() * 20) + 1;
        int numero;
        boolean flag = false; // las variables de tipo boolean toman valores true o false (verdadero o falso)
        System.out.println("\033\143");
        do {
            System.out.println("Adivina un número entre 1 y 20");
            numero = scanner.nextInt();
            if (numero == numeroAleatorio) {
                System.out.println("¡Lo has adivinado!");
                flag = true;
            } else if (numero > numeroAleatorio) {
                System.out.println("El número que has introducido es mayor que el número aleatorio");
            } else {
                System.out.println("El número que has introducido es menor que el número aleatorio");
            }
        } while (!flag); // mientras flag es falso repite !flag -> flag == false
        scanner.close();
    }

    public static void validPass() {
        /*
         * ✏️ Actividad: Validación de contraseña
         * Escribe un programa que solicite que ingreses una contraseña y la valide
         * utilizando un bucle while. La contraseña correcta es "secreto". Continuará
         * pidiéndote que ingreses la contraseña hasta que sea correcta.
         */
        // Clave correcta
        final String CLAVE_CORRECTA = "secreto";

        // Objeto scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        String claveIngresada;

        System.out.println("\033\143");
        System.out.println("Ingrese clave");
        claveIngresada = scanner.nextLine();

        while (!claveIngresada.equals(CLAVE_CORRECTA)) {
            System.out.println("Contraseña incorrecta, Ingrese clave de nuevo: ");
            claveIngresada = scanner.nextLine();
        }

        System.out.println("Contraseña correcta!! ");

        scanner.close();
    }

    public static void numDeDig() {
        /*
         * ✏️ Actividad: Número de dígitos
         * Escribe un programa que te pida que ingreses un número entero y utilice un
         * bucle while para calcular la cantidad de dígitos de ese número. Por ejemplo,
         * el número 4578 tiene 4 dígitos. El programa debe tener en cuenta que el 0
         * tiene una cifra y también contar las cifras de números negativos.
         */
        System.out.println("\033\143");
        try (Scanner snn = new Scanner(System.in)) {
            int digitos = 0;
            System.out.println("Ingresa un numero entero:");
            int numero = snn.nextInt();
            if (numero == 0) {
                digitos = 1;
            } else {
                while (numero != 0) {
                    numero = numero / 10;
                    digitos++;
                }
            }
            System.out.println("El numero tiene " + digitos + " digitos.");
        } catch (InputMismatchException e) {
            System.out.println("Tiene que ser un numero usuario. Y entero.");
        }
    }

    /*
     * ✏️ Actividad: Ejercicios Complementarios
     * ✨ Estos ejercicios son de tipo complementario. Esto quiere decir que te
     * ayudará a avanzar en profundidad en el tema visto, pero no son obligatorios.
     * Te recomendamos intentar con tu equipo trabajar al menos uno de ellos.
     */

    public static void tablaMult() {
        /*
         * Tabla de multiplicar
         * 
         * Escribe un programa que solicite al usuario un número entero y muestre la
         * tabla de multiplicar de ese número utilizando un bucle while. El programa
         * debe seguir solicitando números hasta que el usuario ingrese un valor igual a
         * cero, en cuyo caso debería salir del bucle.
         */
        Scanner snn = new Scanner(System.in);
        int cont, num = -1;
        System.out.println("\033\143");
        while (num != 0) {
            System.out.println("Ingresa un numero entero:");
            num = snn.nextInt();
            if (num != 0) {
                cont = 1;
                System.out.println("Tabla de multiplicar del " + num + ":");
                while (cont <= 10) {
                    System.out.println(num + " x " + cont + " = " + num * cont);
                    cont++;
                }
            }
        }
        snn.close();
    }

    public static void contParImpar() {
        /*
         * Contador de números pares e impares
         * 
         * Escribe un programa que solicite al usuario ingresar una serie de números
         * enteros. Utiliza un bucle while para contar la cantidad de números pares e
         * impares ingresados hasta que el usuario decida terminar la entrada de
         * números. Al finalizar, muestra la cantidad de números pares e impares
         * ingresados
         */

        Scanner snn = new Scanner(System.in);
        int contPar = 0, contImpar = 0, num = -1;
        System.out.println("\033\143");
        while (num != 0) {
            System.out.println("Ingresa un numero entero (0 para salir):");
            num = snn.nextInt();
            if (num != 0) {
                if (num % 2 == 0) {
                    contPar++;
                } else {
                    contImpar++;
                }
            }
        }
        snn.close();
        System.out.println("Cantidad de números pares: " + contPar);
        System.out.println("Cantidad de números impares: " + contImpar);
    }

    public static void calcSumAcum() {
        /*
         * Calculadora de suma acumulada
         * 
         * Crea un programa que solicite al usuario ingresar una serie de números
         * enteros positivos. Utiliza un bucle do-while para ir acumulando la suma de
         * los números ingresados. Después de cada entrada de número, pregunta al
         * usuario si desea ingresar otro número. Si el usuario responde
         * afirmativamente, continúa solicitando números; de lo contrario, muestra la
         * suma acumulada de todos los números ingresados y termina el programa.
         */

        Scanner snn = new Scanner(System.in);
        int num = 0, suma = 0; 
        System.out.println("\033\143");
        do {
            System.out.println("Ingresa un número entero positivo (0 para salir):");
            num = snn.nextInt();
            if (num > 0) {
                suma += num;
            }
        } while (num != 0);
        snn.close();
        System.out.println("La suma acumulada de los números ingresados es: " + suma);
    }

}
