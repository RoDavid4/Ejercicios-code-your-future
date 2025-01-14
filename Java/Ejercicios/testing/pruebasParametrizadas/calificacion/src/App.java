package Java.Ejercicios.testing.pruebasParametrizadas.calificacion.src;

import java.util.Scanner;

public class App {
  /*     Actividad: Calificación
  Tu programa solicita al usuario una puntuación entre 0 y 100. Luego, muestra en pantalla la calificación
  correspondiente según la siguiente escala:

  Si la puntuación está entre 90 y 100, muestra "A".

  Si la puntuación está entre 80 y 89, muestra "B".

  Si la puntuación está entre 70 y 79, muestra "C".

  Si la puntuación está entre 60 y 69, muestra "D".

  Si la puntuación es menor a 60, muestra "F".

  Crea un método "obtenerNota()" que reciba por parámetro un "int" y devuelva un "String".
  El método debe utilizar la estructura de control "switch expression".

  Crea una clase para testear esa actividad, incluyendo cada uno de los métodos.  */

  public static Scanner tcld = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("su calificacion es: " + obtieneNota(leeNota()));
  }

  public static int leeNota() {
    int nota;
    System.out.println("Ingrese un numero");
    nota = tcld.nextInt();
    return nota;
  }

  public static String obtieneNota(int nota) {
    int caso =
        (nota >= 90 && nota <= 100
            ? 1
            : nota < 90 && nota >= 80
                ? 2
                : nota < 80 && nota >= 70
                    ? 3
                    : nota < 70 && nota >= 60 ? 4 : nota < 60 && nota >= 0 ? 5 : 6);
    return switch (caso) {
      case 1 -> "A";
      case 2 -> "B";
      case 3 -> "C";
      case 4 -> "D";
      case 5 -> "F";
      default -> "Valor ingresado incorrecto";
    };
  }
}
