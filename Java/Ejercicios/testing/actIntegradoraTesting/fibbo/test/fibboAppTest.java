package Java.Ejercicios.testing.actIntegradoraTesting.fibbo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Java.Ejercicios.testing.actIntegradoraTesting.fibbo.src.fibboApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class fibboAppTest {

  @CsvSource({
    "0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21", "9, 34", "10, 55"
  })
  @ParameterizedTest
  void testFibonacci(int entrada, int esperado) {
    assertEquals(esperado, fibboApp.fiboAux(entrada));
  }

  @Test
  void testFibonacci() {}

  @Test
  void testMain() {}
}
