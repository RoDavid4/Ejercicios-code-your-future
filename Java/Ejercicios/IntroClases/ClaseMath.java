package Java.Ejercicios.IntroClases;

import java.util.Scanner;

public class ClaseMath {

    public static void valAbs() {
        /*
         * 1 Actividad: Calculando el valor absoluto
         * Escribe un programa que pida al usuario un número entero y muestra en
         * pantalla su valor absoluto utilizando el método abs() de la clase Math.
         */
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int num = sc.nextInt();
        System.out.println("El valor absoluto de " + num + " es " + Math.abs(num));
        sc.close();
    }

    public static void redondNum() {
        /*
         * 2 Actividad: Redondeo de números
         * Escribe un programa que pida al usuario un número decimal y muestra en
         * pantalla su valor redondeado utilizando el método round() de la clase Math.
         */
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número decimal: ");
        double num = sc.nextDouble();
        long redondeado = Math.round(num);
        System.out.println("El número redondeado es: " + redondeado);
        sc.close();

    }

    public static void genRandomNum() {
        /*
         * 3 Actividad: Generando números aleatorios
         * Escribe un programa que genere y muestre en pantalla un número aleatorio en
         * el rango del 1 al 355 utilizando el método random() de la clase Math. Puedes
         * utilizar el método floor() para redondear el número aleatorio hacia abajo.
         */

        System.out.println("\033\143");
        double numeroRandom = Math.random() * 355 + 1;
        double numeroRedondeado = Math.floor(numeroRandom);
        System.out.println("El número aleatorio es: " + (long) numeroRedondeado);

        System.out.println("El número aleatorio es: " + (long) Math.floor(Math.random() * 355 + 1));

    }

    public static void calcPot() {
        /*
         * Actividad: Calculando la potencia
         * Escribe un programa que pida al usuario dos números enteros, representando la
         * base y el exponente, y calcula el resultado de elevar la base al exponente
         * utilizando el método pow() de la clase Math. Muestra el resultado en
         * pantalla.
         */
        System.out.println("\033\143");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la base: ");
        double base = scanner.nextDouble();
        System.out.println("Ingresa el exponente: ");
        double expo = scanner.nextDouble();
        double resultado = Math.pow(base, expo);
        System.out.println("El resultado de elevar " + base + " a la potencia " + expo + " es: " + resultado);
        scanner.close();

    }

    public static void calcRaizCuad() {
        /*
         * Actividad: Calculando la raíz cuadrada
         * Escribe un programa que pida al usuario un número positivo y calcule su raíz
         * cuadrada utilizando el método sqrt() de la clase Math. Si el número ingresado
         * es negativo, muestra un mensaje adecuado en pantalla.
         */

        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un número positivo: ");
        double num = sc.nextDouble();
        if (num < 0) {
            System.out.println("El numero ingresado debe de ser positivo");
        } else {
            double raizCuadrada = Math.sqrt(num);
            System.out.println("La raíz cuadrada de " + num + " es: " + raizCuadrada);
        }
        sc.close();

    }

    public static void rngAcotado() {
        /*
         * 1. Generando un número aleatorio entre dos límites
         * 
         * Escribe un programa que pida al usuario ingresar dos números enteros: un
         * límite inferior y un límite superior. Luego, utiliza el método random() de la
         * clase Math para generar y mostrar en pantalla un número aleatorio dentro del
         * rango especificado por los límites ingresados.
         */

        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el límite inferior: ");
        int inferior = sc.nextInt();
        System.out.println("ingresa el limite superior: ");
        int superior = sc.nextInt();
        double aleatorio = (Math.random() * (superior - inferior + 1));
        System.out.println("El número aleatorio entre " + inferior + " y " + superior + " es: " + aleatorio);
        sc.close();
    }

    public static void genAnSQRT() {
        /*
         * 2. Generación aleatoria y análisis de raíz cuadrada
         * 
         * Escribe un programa que cumpla con las siguientes condiciones:
         * 
         * Pide al usuario que ingrese un número entre 1 y 30. Este número será
         * almacenado en una variable llamada numeroLimite .
         * 
         * Utiliza la clase Math para generar un número aleatorio entre 1 y el
         * numeroLimite recibido del usuario.
         * 
         * Utiliza el método Math.sqrt() para calcular la raíz cuadrada del número
         * aleatorio generado y muéstralo en pantalla.
         * 
         * Analiza si el número aleatorio generado es primo y muestra un mensaje en
         * pantalla indicando si lo es o no.
         * 
         * Finalmente, muestra el número aleatorio generado y su raíz cuadrada en
         * pantalla.
         */
        System.out.println("\033\143");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un número entre 1 y 30: ");
        int numeroLimite = sc.nextInt();
        if (numeroLimite < 1 || numeroLimite > 30) {
            System.out.println("El número ingresado no está dentro del rango permitido");
        } else {
            int aleatorio = (int) (Math.random() * numeroLimite + 1);
            double raizCuadrada = Math.sqrt(aleatorio);
            if (esPrimo(aleatorio)) {
                System.out.println("\nEl número generado es: " + aleatorio + " y es primo");
            } else {
                System.out.println("El número generado es: " + aleatorio + " y no es primo");
            }
            System.out.println("La raíz cuadrada del número aleatorio es: " + raizCuadrada);
        }
        sc.close();
    }

    public static boolean esPrimo(int numero) {
        /*
         * Recibe un numero por parametro y devuelve true si el numero es un numero
         * primo
         * y false si el numero NO es un numero primo
         */
        boolean bandera = true;
        if (numero > 1) {
            int numAux = numero - 1;
            while (bandera && numAux > 1) {
                if (numero % numAux == 0) {
                    bandera = false;
                } else {
                    numAux--;
                }
            }
        } else {
            bandera = false;
        }
        return bandera;
    }

}
