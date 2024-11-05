package Java.Ejercicios;

import Java.Ejercicios.Integradoras.*;
import Java.Ejercicios.Introductorios.IntroActividad1;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("\033\143");
        imprimirTablaMultiplicar(pedirNumeros(sc));
        sc.close();
    }

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
