package Java.Ejercicios.IntroClases;

import java.util.Scanner;

public class Wrappers {

    public static void cadIsNum() {
        /*
         * ✏️ Actividad: Verificando si una cadena representa un número válido
         * Pídele al usuario que introduzca una cadena. Intenta convertir la cadena a un
         * número decimal usando Double.valueOf(). Si la cadena no representa un número
         * válido, Double.valueOf() lanzará una excepción. Captura esta excepción y
         * muestra un mensaje al usuario indicando que la entrada no es un número
         * válido.
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033\143");
        System.out.println("Introduce una cadena: ");
        String input = scanner.nextLine();
        try {
            double num = Double.valueOf(input);
            System.out.println("La cadena representa un número: " + num);
        } catch (NumberFormatException e) {
            System.out.println("La cadena no representa un número válido");
        }
        scanner.close();
    }

    public static void cadANum() {
        /*
         * ✏️ Actividad: Conversión de cadena a número
         * Escribe un programa que lea una cadena que represente un número entero como
         * entrada utilizando la clase Scanner. Luego, convierte la cadena en un número
         * entero utilizando la clase de envoltura Integer.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Introduce una cadena: ");
        String input = scanner.nextLine();
        try {
            int num = Integer.parseInt(input);
            System.out.println("La cadena representa un número entero: " + num);
        } catch (NumberFormatException e) {
            System.out.println("La cadena no representa un número entero");
        }
        scanner.close();
    }

    public static void soloLetras() {
        /*
         * ✏️ Actividad: Verificando si una cadena contiene solo letras
         * Pide al usuario que introduzca una cadena. Crea un bucle que recorra cada
         * carácter en la cadena y utiliza Character.isLetter() para verificar si todos
         * los caracteres son letras. Muestra un mensaje al usuario indicando si la
         * cadena contiene solo letras o no.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Introduce una cadena: ");
        String input = scanner.nextLine();
        boolean soloLetras = true;
        int i = 0;
        while (soloLetras && i < input.length()) {
            if (!Character.isLetter(input.charAt(i))) {
                soloLetras = false;
            }
            i++;
        }
        if (soloLetras) {
            System.out.println("La cadena contiene solo letras");
        } else {
            System.out.println("La cadena no contiene solo letras");
        }
        scanner.close();
    }

    public static void contEspBlanc() {
        /*
         * ✏️ Actividad: Contando los espacios en blanco en una cadena
         * Pídele al usuario que introduzca una cadena. Crea un bucle que recorra cada
         * carácter en la cadena y utiliza Character.isWhitespace() para contar el
         * número de espacios en blanco en la cadena. Muestra el recuento al usuario.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Introduce una cadena: ");
        String input = scanner.nextLine();
        int contEspBlancos = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                contEspBlancos++;
            }
        }
        System.out.println("La cadena contiene " + contEspBlancos + " espacios en blanco");
        scanner.close();
    }

    public static void sumaNum() {
        /*
         * ✏️ Actividad: Suma de números
         * Pídele al usuario que introduzca una cadena que represente un número entero y
         * luego otra cadena que represente un número decimal. Convierte cada cadena al
         * tipo de dato correspondiente utilizando los métodos valueOf, suma sus valores
         * e imprímelos por consola.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Introduce una cadena que represente un número entero: ");
        String entero = scanner.nextLine();
        System.out.println("Introduce una cadena que represente un número decimal: ");
        String decimal = scanner.nextLine();
        int enteroInt = Integer.parseInt(entero);
        double decimalDouble = Double.parseDouble(decimal);
        double suma = (double) enteroInt + decimalDouble;
        System.out.println("La suma de los números es: " + suma);
        scanner.close();
    }

    public static void contDigit() {
        /*
         * ✏️ Actividad: Contando los dígitos en un número
         * Pídele al usuario que introduzca un número. Convierte el número en una cadena
         * y luego utiliza un bucle y Character.isDigit() para contar el número de
         * dígitos en el número.
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Introduce un número: ");
        int input = scanner.nextInt();
        String numero = String.valueOf(input);
        int contDigitos = 0;
        for (int i = 0; i < numero.length(); i++) {
            if (Character.isDigit(numero.charAt(i))) {
                contDigitos++;
            }
        }
        System.out.println("El número tiene " + contDigitos + " dígitos");
        scanner.close();
    }
}
