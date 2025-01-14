package Java.Ejercicios.pooAvanzado.introAColecciones.ej3Sopa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SopaApp {

    /*
     * Actividad: Sopa de números
     * Desarrolla un programa que solicite al usuario ingresar una serie de valores
     * numéricos enteros desde el teclado y los guarde en un ArrayList de tipo
     * Integer. La lectura de números finalizará cuando se introduzca el valor -99.
     * Este valor no será almacenado en el ArrayList.
     * 
     * Una vez completada la entrada de datos, el programa mostrará por pantalla el
     * número total de valores ingresados, su suma y su media (promedio). Además, se
     * mostrará cuántos de los valores ingresados son mayores que la media.
     * 
     * Para abordar esta tarea, asegúrate de desarrollar al menos los siguientes
     * métodos:
     * 
     * Método leerValores(): Este método solicita por teclado los números y los
     * almacena en el ArrayList. La lectura finaliza cuando se introduce el valor
     * -99. El método devuelve el ArrayList con los valores introducidos.
     * 
     * Método calcularSuma(): Recibe como parámetro el ArrayList con los valores
     * numéricos y calcula su suma. Utiliza un Iterator para recorrer el ArrayList.
     * 
     * Método calcularPromedio(): Recibe como parámetro el ArrayList con los valores
     * numéricos y calcula su media. Utiliza un Iterator para recorrer el ArrayList.
     * 
     * Método mostrarResultados(): Recibe como parámetro el ArrayList, la suma y la
     * media aritmética. Este método muestra por pantalla todos los valores, su suma
     * y su media, y calcula y muestra cuántos números son superiores a la media.
     */

    public static void main(String[] args) {
        System.out.println("\033\143"); // limpia la pantalla
        ArrayList<Integer> listaNumeros = leerValores();
        System.out.println("\033\143"); // limpia la pantalla
        mostrarResultados(listaNumeros, calcularSuma(listaNumeros), calcularPromedio(listaNumeros));
    }

    private static ArrayList<Integer> leerValores() {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Ingrese un número entero (para terminar ingrese -99):");
            numero = scanner.nextInt();
            scanner.nextLine();
            if (numero != -99) {
                listaNumeros.add(numero);
            }
        } while (numero != -99);
        scanner.close();
        return listaNumeros;
    }

    private static int calcularSuma(ArrayList<Integer> listaNumeros) {
        int suma = 0;
        // se debe de recorrer con Iterator
        Iterator<Integer> iterator = listaNumeros.iterator();
        while (iterator.hasNext()) {
            suma += iterator.next();
        }
        return suma;
    }

    private static double calcularPromedio(ArrayList<Integer> listaNumeros) {
        return (double) calcularSuma(listaNumeros) / listaNumeros.size();
    }

    private static void mostrarResultados(ArrayList<Integer> listaNumeros, int suma, double promedio) {
        System.out.println("Lista de números: " + listaNumeros);
        System.out.println("Suma de los números: " + suma);
        System.out.println("Media aritmética: " + promedio);
        System.out.println(
                "Cantidad de números superiores a la media: " + cantidadSuperioresMedia(listaNumeros, promedio));
    }

    private static int cantidadSuperioresMedia(ArrayList<Integer> listaNumeros, double media) {
        int cantidadSuperioresMedia = 0;
        Iterator<Integer> iterator = listaNumeros.iterator();
        while (iterator.hasNext()) {
            int numero = iterator.next();
            if (numero > media) {
                cantidadSuperioresMedia++;
            }
        }
        return cantidadSuperioresMedia;
    }
}
