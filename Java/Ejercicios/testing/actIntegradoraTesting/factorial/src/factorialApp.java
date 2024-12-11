package Java.Ejercicios.testing.actIntegradoraTesting.factorial.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class factorialApp {

  public static void main(String[] args) {
    factorial();
  }

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
}
