package Java.Ejercicios.pooAvanzado.introAColecciones.ej2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    /*
     * Actividad: Orden de mérito
     * Desarrolla un programa en Java que emplee un ArrayList para almacenar una
     * serie de notas enteras en el rango del 1 al 10.
     * 
     * El programa debe permitir al usuario ingresar varios números a la lista,
     * asegurándose de que cada número esté dentro del rango especificado. Luego,
     * ordenará estos números de manera descendente y los imprimirá por pantalla en
     * ambas direcciones.
     * 
     * Pasos a seguir:
     * 
     * Inicializa un ArrayList de tipo Integer para almacenar los números enteros.
     * 
     * Implementa un bucle que solicite al usuario ingresar números enteros uno por
     * uno. Puedes usar un bucle while o for que pregunte al usuario si desea
     * agregar un número en cada iteración.
     * 
     * En cada iteración del bucle, verifica que el número ingresado esté dentro del
     * rango del 1 al 10 y agrégalo al ArrayList utilizando el método add. Continúa
     * solicitando al usuario que ingrese números hasta que decida no agregar más.
     * 
     * Después de que el usuario haya ingresado todos los números, utiliza el método
     * sort para ordenar la lista de números de forma descendente.
     * 
     * Imprime por pantalla la lista ordenada tanto en orden ascendente como
     * descendente.
     */
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int valor=0;

        do {
            System.out.println("\033\143"); // limpia la pantalla
            System.out.println("Ingrese un número entero entre 1 y 10 (0 para salir");
            valor = scan.nextInt();
            if (valor >= 1 && valor <= 10) {
                if (lista.add(valor)) {
                    System.out.println("Número agregado con éxito");
                    System.out.println("Presione enter para continuar");
                    scan.nextLine();
                }
            }    
        } while (valor != 0);

        lista.sort(null);
        System.out.println("las notas en orden ascendiente son:");
        for (Integer nota : lista) {
            System.out.println(nota);
        }

        Collections.sort(lista, Collections.reverseOrder());

        System.out.println("las notas en orden descendiente son:");
        for (Integer nota : lista) {
            System.out.println(nota);
        }
        
        scan.close();
    }

}
