package Java.Ejercicios.testing.intro.impNomEd2.src;

import java.util.Scanner;

public class ImprimirNombreYEdad2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String nombre = ImprimirNombreYEdad2.obtenerNombre(sc);
    int edad = ImprimirNombreYEdad2.obtenerEdad(sc);

    ImprimirNombreYEdad2.imprimir(nombre, edad);
  }

  public static void imprimir(String nombre, Integer edad) {

    System.out.println("Nombre: " + nombre + " Edad: " + edad);
  }

  public static Integer obtenerEdad(Scanner objetoScanner) {
    return objetoScanner.nextInt();
  }

  public static String obtenerNombre(Scanner objetoScanner) {
    return objetoScanner.next();
  }
}
