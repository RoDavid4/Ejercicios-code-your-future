package Java.Ejercicios.introMetodos;

import java.util.Scanner;

public class IntroMetodos {

    public static Scanner sc = new Scanner(System.in);

    public static void imprimeNombre(String unNombre) {
        /*
         * Imprimir nombre: Crea un método llamado imprimeNombre() que reciba por
         * parámetro un nombre y luego imprima el mensaje "Mi nombre es [nombre]".
         * Invocar dicho método desde el método main para ver el mensaje por consola
         */

        System.out.println("El nombre es: " + unNombre);
    }

    public static void imprimeNombre(String unNombre, int unaEdad) { // parámetros
        /*
         * Imprimir nombre y edad: Crea el método imprimeNombreYEdad(String nombre, int
         * edad) que reciba dos parámetros, el nombre y la edad, y luego imprima el
         * mensaje "Me llamo [nombre] y tengo [edad] años".
         */

        System.out.println("Me llamo " + unNombre + " y tengo " + unaEdad + " años");
        // Otra forma:
        // System.out.printf("Me llamo %s y tengo %d años ", unNombre, unaEdad);
    }

    /*
     * 1. Obtener datos: Perfeccionando la actividad de “imprimir datos”, no solo
     * crea el método imprimeNombreYEdad(String nombre, int edad) que reciba dos
     * parámetros, el nombre y la edad, sino a su vez, crea dos métodos para obtener
     * el nombre y la edad, respectivamente. Ambos métodos deben recibir por
     * parámetro un objeto de tipo "Scanner".
     */

    /*
     * 2. Usar una variable global: Modifica los métodos "obtenerNombre()" y
     * "obtenerEdad()" para que no necesiten recibir el Scanner por parámetro. En su
     * lugar, utiliza una variable global para acceder al Scanner y obtener los
     * datos necesarios.
     */

    public static String ingreseNombre() {
        System.out.println("Ingrese un nombre: ");
        String nombre = sc.nextLine();
        return nombre;

    }

    public static int ingreseEdad() {
        System.out.println("Ingrese su edad: ");
        return sc.nextInt();

    }

    /*
     * 1. Tabla de multiplicar
     * 
     * En esta actividad, vas a crear un programa que solicita al usuario que
     * ingrese un número (incluida la lógica en un método llamado pedirNumero()) y
     * luego imprime la tabla de multiplicar de ese número del 1 al 10 (incluida la
     * lógica en un método llamado imprimirTablaMultiplicar()). Para ello,
     * implementarás un método que reciba el número ingresado por el usuario y que
     * imprima la tabla de multiplicar correspondiente.
     */

    public static int pedirNumero(Scanner sc) {

        System.out.print("Ingrese un numero ");
        return sc.nextInt();
    }

    public static void imprimirTablaMultiplicar(int numero) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + numero * i);
        }
    }

    /*
     * 2. Tabla de multiplicar 2.0
     * 
     * En esta actividad, vas a crear un programa que solicita al usuario que
     * ingrese 3 números (incluida la lógica en un método llamado pedirNumeros()) y
     * luego imprime la tabla de multiplicar de cada uno de ellos 1 al 10 (incluida
     * la lógica en un método llamado imprimirTablasMultiplicar(int[] numeros)).
     * Para ello, implementarás un un array para almacenar los números ingresados y
     * luego invocarás el método para cada uno de ellos.
     */

    public static int[] pedirNumeros(Scanner sc) {
        int[] arreglo = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("\n Ingrese un numero ");
            arreglo[i] = sc.nextInt();
        }

        return arreglo;
    }

    public static void imprimirTablaMultiplicar(int[] numeros) {

        for (int j = 0; j < numeros.length; j++) {
            System.out.println("\n Tabla de multiplicar del " + numeros[j] + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numeros[j] + " x " + i + " = " + numeros[j] * i);
            }
        }
    }

}
