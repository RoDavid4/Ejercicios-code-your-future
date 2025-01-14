package Java.Ejercicios.pooAvanzado.introAColecciones.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* 
Desarrolla un programa en Java que haga uso de una lista de tipo ArrayList para almacenar un 
conjunto de nombres de ciudades. El objetivo es permitir al usuario ingresar nombres de ciudades y 
luego mostrar la lista completa de ciudades ingresadas.

Pasos a seguir:
Inicializa un ArrayList de tipo String para almacenar los nombres de las ciudades.

Implementa un bucle que solicite al usuario ingresar nombres de ciudades uno por uno. 
Puedes usar un bucle while o un bucle for que pregunte al usuario si desea agregar una ciudad en cada iteración.

En cada iteración del bucle, solicita al usuario que ingrese el nombre de una ciudad y agrega ese nombre
 al ArrayList utilizando el método add.

Continúa solicitando al usuario que ingrese nombres de ciudades hasta que decida no agregar más.

Finalmente, muestra por consola la lista completa de ciudades almacenadas en el ArrayList.

Esta actividad te permitirá practicar la manipulación de ArrayLists en Java, así como también 
te brindará la oportunidad de repasar cómo interactuar con datos ingresados por el usuario. */

public class App {

    public static void main(String[] args) {
        List<String> ciudades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String ciudad;
        boolean aux = true;

        do {
            System.out.println("Agregue el nombre de una ciudad");
            ciudad = scanner.nextLine();
            ciudades.add(ciudad);
            System.out.println("Desea agregar otra ciudad?");
            System.out.println("1- SI 2- NO");
            int option = scanner.nextInt();
            if (option == 2) {
                aux = false;
            }
            scanner.nextLine();
        } while (aux);
        
        System.out.println("Las ciudades son: ");
        for (String nombre : ciudades) {
            System.out.println(nombre);
        }

        scanner.close();
    }
}
