package Java.Ejercicios.testing.actIntegradoraTesting.fibbo.src;

import java.util.Scanner;

public class fibboApp {

  public static void main(String[] args) {
    fibonacci();
  }

  public static void fibonacci() {
    Scanner sc = new Scanner(System.in);
    System.out.println("De qué número se quiere calcular el Fibonacci?");
    int n = sc.nextInt();
    System.out.println("El Fibonacci de " + n + " es: " + fiboAux(n));
    sc.close();
  }

  private static int fiboAux(int num) {
    if (num == 0) {
      return 0;
    } else if (num == 1) {
      return 1;
    } else {
      return fiboAux(num - 1) + fiboAux(num - 2);
    }
  }
}
