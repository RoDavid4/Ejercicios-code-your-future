package Java.Ejercicios.testing.pruebasParametrizadas.numerosAleatorios.src;

import java.util.Random;

public class Application {
  public static void main(String[] args) {}

  public static int numeroAleatorio() {
    Random rng = new Random();
    return rng.nextInt(1, 356);
  }
}