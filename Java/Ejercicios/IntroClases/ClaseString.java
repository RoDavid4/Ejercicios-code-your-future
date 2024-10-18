package Java.Ejercicios.IntroClases;

import java.util.Scanner;

public class ClaseString {
    public static void longCad() {
        Scanner almacenador = new java.util.Scanner(System.in);

        // ✏️ Actividad: Longitud de Cadena
        
        System.out.println("Ingrese una cadena para saber su longitud");
        String cadena = almacenador.nextLine();
        int longitudCadena = cadena.length();
        System.out.println("La longitud de la cadena es: " + cadena.length());
        System.out.println("La longitud de la cadena es: " + longitudCadena);
        almacenador.close();
    }

    public static void concatCar() {
        Scanner almacenador = new java.util.Scanner(System.in);
        // ✏️ Actividad:Concatenación de Cadenas

        System.out.println("Ingrese su nombre");
        String nombre = almacenador.nextLine();
        System.out.println("Ingrese su apellido");
        String apellido = almacenador.nextLine();
        String nombreApellido = nombre.concat(" " + apellido);
        System.out.println("Su nombre y apellido es: " + nombre.concat(" " + apellido));
        System.out.println("Su nombre y apellido es: " + nombreApellido);
        almacenador.close();
    }

    public static void extractSubcad() {
        java.util.Scanner almacenador = new java.util.Scanner(System.in);
        // ✏️ Actividad:Extracción de Subcadena

        System.out.println("Ingrese una frase");
        String frase = almacenador.nextLine();
        System.out.println("Ingrese el num de indice inicial");
        int inicio = almacenador.nextInt();
        System.out.println("Ingrese el num de indice final");
        int finalCadena = almacenador.nextInt();

        String subcadena = frase.substring(inicio, finalCadena);
        System.out.println("la frase extraida es:" + subcadena);
        System.out.println("la frase extraida es:" + frase.substring(inicio, finalCadena));
        almacenador.close();
    }

    public static void buscarCaracter() {
        /*
         * Escribe un programa que pida al usuario ingresar una palabra y un carácter,
         * y determine si el carácter ingresado se encuentra en la palabra utilizando el
         * método indexOf() de la clase String.
         * Muestra un mensaje adecuado en pantalla indicando si el carácter se encuentra
         * o no en la palabra
         */

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese una palabra :");
        String palabra = teclado.nextLine();
        System.out.println("Ingrese el caracter que queiras buscar: ");
        char caracter = teclado.next().charAt(0);

        if (palabra.indexOf(caracter) != -1) {
            System.out.println(
                    "El caracter ingresado se encuentra en la palabra en la posición: " + palabra.indexOf(caracter));

        } else {
            System.out.println(" El caracter no se encuentra en la palabra");
        }
        teclado.close();
    }

    public static void mayYMin() {
        // Escribe un programa que pida al usuario ingresar una cadena de texto y
        // muestre en pantalla la misma cadena, pero con todos los caracteres en
        // mayúsculas o minúsculas.
        // Utiliza los métodos toUpperCase() y toLowerCase() de la clase String para
        // realizar la conversión.

        Scanner entrada = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Che, deicme una palabra");
        try {
            String palabra1 = entrada.nextLine();
            System.out.println("la palabra es " + palabra1);
            System.out.println("En minuscula quedaria... " + palabra1.toLowerCase());
            System.out.println("En mayuscula quedaria... " + palabra1.toUpperCase());
        } catch (Exception e) {
            System.out.println("error");
        }
        entrada.close();
    }

    public static void reemplazoDeCaracteres() {
        // 1. Reemplazo de Caracteres

        // Escribe un programa que solicite al usuario ingresar una frase y dos
        // caracteres. Utiliza el método replace() de la clase String para reemplazar
        // todas las ocurrencias del primer carácter con el segundo carácter en la frase
        // ingresada por el usuario. Muestra la frase resultante en pantalla.

        Scanner entrada = new Scanner(System.in);
        System.out.println("\033\143");
        System.out.println("Che, deicme una frase");
        try {
            String frase = entrada.nextLine();
            System.err.println("La frase original es: " + frase);
            System.err.println("ingrese caracter a modificar");
            char caracter1 = entrada.nextLine().charAt(0);
            System.err.println("ingrese cual caracter se va a modificar");
            char caracter2 = entrada.nextLine().charAt(0);
            System.out.println("La frase modificada es: " + frase.replace(caracter1, caracter2));
        } catch (Exception e) {
            System.out.println("error");
        }
        entrada.close();
    }

    public static void reempCar() {
        // 1. Reemplazo de Caracteres
        java.util.Scanner almacenador = new java.util.Scanner(System.in);
        System.out.print("\033\143");// limpia la consola
        System.out.println("Ingrese una cadena");
        String cadena2 = almacenador.nextLine();
        System.out.println("Ingrese el caracter a reemplazar");
        char caracter1 = almacenador.next().charAt(0);
        almacenador.nextLine(); // Consumir el salto de línea que quedó después de `next()`
        System.out.println("Ingrese el caracter de reemplazo");
        char caracter2 = almacenador.next().charAt(0);
        almacenador.nextLine(); // Consumir el salto de línea que quedó después de `next()`
        String cadenaReemplazada = cadena2.replace(caracter1, caracter2);
        System.out.println("La cadena reemplazada es: " + cadenaReemplazada);
        System.out.println("La cadena reemplazada es: " + cadena2.replace(caracter1, caracter2));
        almacenador.close();
    }

    public static void elimEsp() {
        // 2. Eliminación de Espacios en Blanco
        java.util.Scanner almacenador = new java.util.Scanner(System.in);
        System.out.print("\033\143");// limpia la consola
        System.out.println("Ingrese una cadena");
        String cadena3 = almacenador.nextLine();
        String cadenaLimpia = cadena3.trim();
        System.out.println("La cadena sin espacios es: " + cadenaLimpia + "la longitud de la cadena es: "
                + cadenaLimpia.length() + "la longitud de la cadena es: " + cadena3.length());
        System.out.println("La cadena sin espacios es: " + cadena3.trim());
        almacenador.close();
    }

    public static void compCad() {
        // 3. Comparación de Cadenas
        java.util.Scanner almacenador = new java.util.Scanner(System.in);
        System.out.print("\033\143");// limpia la consola
        System.out.println("Ingrese una cadena");
        String cadena4 = almacenador.nextLine();
        System.out.println("Ingrese otra cadena");
        String cadena5 = almacenador.nextLine();
        boolean sonIguales = cadena4.equals(cadena5);
        if (sonIguales) {
            System.out.println("Las cadenas son iguales");
        } else {
            System.out.println("Las cadenas son diferentes");
        }

        if (cadena4.equals(cadena5)) {
            System.out.println("Las cadenas son iguales");
        } else {
            System.out.println("Las cadenas son diferentes");
        }
        almacenador.close();
    }

    public static void loncCadSinEspacio() {
        java.util.Scanner almacenador = new java.util.Scanner(System.in);
        System.out.print("\033\143");// limpia la consola

        // 4. Calculando la Longitud de Cadenas sin Espacios:
        System.out.println("Ingrese una cadena");
        String cadena6 = almacenador.nextLine();
        int longitudCadena = cadena6.length();
        int longitudCadenaSinEspacios = cadena6.replace(" ", "").length();
        System.out.println("La cadena es: " + cadena6);
        System.out.println("La cadena es: " + cadena6.replace(" ", ""));
        System.out.println("La longitud de la cadena es: " + longitudCadena);
        System.out.println("La longitud de la cadena sin espacios es: " + longitudCadenaSinEspacios);
        System.out.println("La longitud de la cadena sin espacios es: " + cadena6.replace(" ", "").length());
        almacenador.close();
    }
}
