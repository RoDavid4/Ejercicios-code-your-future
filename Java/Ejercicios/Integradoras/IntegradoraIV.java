package Java.Ejercicios.Integradoras;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class IntegradoraIV {

    public static void factorial() {
        /*
         * Actividad: Cálculo del factorial
         * El objetivo de esta actividad es que desarrolles un programa que solicite al
         * usuario ingresar un número y posteriormente calcule su factorial mediante un
         * bucle do-while. El factorial de un número se define como el producto de todos
         * los enteros desde 1 hasta ese número. A continuación, te presentamos algunos
         * ejemplos para mayor claridad:
         * 
         * El factorial de 3 se calcula como 1 * 2 * 3, lo que resulta en 6.
         * 
         * El factorial de 5 se obtiene multiplicando 1 * 2 * 3 * 4 * 5, dando como
         * resultado 120.
         * 
         * Para calcular el factorial de 7, multiplicamos 1 * 2 * 3 * 4 * 5 * 6 * 7, que
         * da 5040.
         */
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        // Preguntarle al usuario por un número entero
        try {
            System.out.println("Buenas tardes, dame un número entero, y te entrego el factorial");
            int f = sc.nextInt();
            int factorial = 1;
            do {
                if (f == 1 || f == 0) {
                    factorial = 1;
                } else {
                    factorial = factorial * f;
                    f--;
                }
            } while (f > 1);
            System.out.printf("%d! = %d", f, factorial);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Amigo, hay que meter un número entero");
        }
        sc.close();
    }

    public static void fibbo() {
        /*
         * Actividad: Serie Fibonacci mejorada
         * En esta actividad, te propongo un desafío adicional relacionado con la serie
         * de Fibonacci. La tarea consiste en crear un programa que te permita ingresar
         * la posición de un número en la serie de Fibonacci y, a continuación, mostrar
         * el valor correspondiente a esa posición.
         * 
         * Recuerda que la serie de Fibonacci comienza con valores específicos para las
         * primeras posiciones:
         * 
         * Posición 0: 0
         * 
         * Posición 1: 1
         * 
         * Posición 2: 1
         * 
         * Posición 3: 2
         * 
         * Posición 4: 3
         * 
         * Tu objetivo es desarrollar un programa que sea capaz de calcular y mostrar el
         * valor de la serie de Fibonacci para cualquier posición ingresada por el
         * usuario. Este ejercicio te ayudará a consolidar tu comprensión sobre cómo
         * generar y trabajar con la serie de Fibonacci. ¡Anímate a enfrentar este reto
         * y sigue profundizando en tus habilidades de programación!
         */

        System.out.println("\033\143");
        int contador = 0;
        int num1 = 0; // Primer num
        int num2 = 1; // Segundo num
        System.out.println("Ingresa la posicion de la que quieras saber su fibonacci empezando desde la posicion 0");
        try (Scanner scan = new Scanner(System.in)) {
            int num = scan.nextInt();
            System.out.println("Los primeros n términos de la serie son:");
            while (contador < num) {
                int siguienteNumero = num1 + num2; // Suma de los dos num anteriores
                num1 = num2; // Actualiza el primer num
                num2 = siguienteNumero;
                contador++;
            }
            System.out.print(num1);
        }

    }

    public static void primosPlus() {
        /*
         * 1. Números primos plus
         * 
         * Siguiendo el ejemplo del ejercicio de “números primos”, ahora el desafío es
         * que desarrolles un programa que te solicite la cantidad deseada de números
         * primos que deseas obtener.
         * 
         * Tu programa deberá generar y mostrar la cantidad de números primos que hayas
         * solicitado.
         * 
         * 💡 Si estás comprobando si un número es divisible por todos los anteriores a
         * él, intenta pensar en formas de optimizar el algoritmo para reducir la
         * cantidad de divisiones necesarias.
         */

        System.out.println("\033\143");
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros primos que quieres buscar");

        int cantidadNumeros = scan.nextInt();

        int numero = 2;

        int numeroPrimo = 0;

        while (numeroPrimo < cantidadNumeros) {

            boolean esPrimo = true;

            if (numero % 2 != 0) {
                // Numero impar
                int i = 3;

                while (i <= Math.sqrt(numero) && esPrimo) {
                    esPrimo = esPrimo && numero % i != 0;
                    i = i + 2;
                }

            } else if (numero != 2) {
                // Ningun numero par distinto de 2 es primo
                esPrimo = false;
            }

            if (esPrimo) {
                System.out.print(numero + " ");
                numeroPrimo++;
            }

            numero++;
        }

        scan.close();
    }

    public static void dibCuadrado() {
        /*
         * 2. Dibujando cuadrados
         * 
         * Realiza un programa para crear un cuadrado de N elementos por lado utilizando
         * el carácter “*”.
         * 
         * Para ello simplemente dibuja una línea de N asteriscos. Repite este proceso N
         * veces para completar el cuadrado.
         * 
         * Por ejemplo, si el cuadrado tiene 4 elementos por lado se deberá dibujar lo
         * siguiente
         * 
         * image4
         * Observación: El cuadrado solo debe ser dibujado por sus lados.
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Introduce el número de elementos por lado del cuadrado: ");
        int n = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (j == 0 || j == n - 1 || i == 0 || i == n - 1) { // extremos
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void grafBarr() {
        /*
         * 3. Creando un gráfico de barras:
         * 
         * Escribe un programa que solicite al usuario ingresar 4 números entre 1 y 20.
         * Luego, imprime una representación visual de estos números en forma de gráfico
         * de barras utilizando asteriscos. Cada número ingresado corresponderá a la
         * longitud de una barra en el gráfico, donde cada asterisco representa una
         * unidad en la escala. A modo de ejemplo:
         * 
         * 2**
         * 
         * 5*****
         * 
         * 1*
         * 
         * 4****
         */

        System.out.println("\033\143");
        Scanner scanner = new Scanner(System.in);
        int[] longitudes = new int[4];
        int num;
        boolean noEsValido;
        for (int i = 0; i < 4; i++) {
            do {
                System.out.printf("Ingrese numero %d: ", i + 1);
                num = scanner.nextInt();
                scanner.nextLine();
                noEsValido = !(num > 0 && num < 21);
                if (noEsValido) {
                    System.out.println("El numero esta fuera de rango");
                }
            } while (noEsValido);
            longitudes[i] = num;
        }

        for (int i : longitudes) {
            System.out.print(i + "\t");
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
