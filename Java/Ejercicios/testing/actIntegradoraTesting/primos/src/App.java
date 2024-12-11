package Java.Ejercicios.testing.actIntegradoraTesting.primos.src;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    numPrimos();
  }

  public static void numPrimos() {
    //System.out.println("\033\143");
    Scanner sc = new Scanner(System.in);
    int num;
    boolean esPrimo = false;
    do {
      System.out.println("Ingrese un número: ");
      num = sc.nextInt();
      esPrimo = esPrimo(num);
      if (esPrimo) {
        System.out.println("El número es primo");
      } else {
        System.out.println("El número no es primo");
      }
    } while (!esPrimo);
    sc.close();
  }

  public static boolean esPrimo(int numero) {
    boolean esPrimo = true; // Variable de bandera

    if (numero <= 1) {
      esPrimo = false; // 0 y 1 no son primos
    } else if (numero == 2) {
      esPrimo = true; // 2 es el único número par primo
    } else if (numero % 2 == 0) {
      esPrimo = false; // Ningún número par distinto de 2 es primo
    } else {
      for (int i = 3; i <= Math.sqrt(numero); i += 2) {
        if (numero % i == 0) {
          esPrimo = false;
          break; // Encontrado un divisor, no es primo
        }
      }
    }
    return esPrimo; // Devolver el resultado de la variable de bandera
  }


}
