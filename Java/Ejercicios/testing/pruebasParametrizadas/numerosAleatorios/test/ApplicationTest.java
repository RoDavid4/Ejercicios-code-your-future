package Java.Ejercicios.testing.pruebasParametrizadas.numerosAleatorios.test;

import static org.junit.Assert.assertTrue;

import Java.Ejercicios.testing.pruebasParametrizadas.numerosAleatorios.src.Application;
import org.junit.jupiter.api.RepeatedTest;

public class ApplicationTest {

  @RepeatedTest(10)
  void numeroAleatorio_en_rango() {
    int num = Application.numeroAleatorio();
    assertTrue(num >= 1); // Mayor que 0
    assertTrue(num <= 355); // Menor que 356
  }
}
