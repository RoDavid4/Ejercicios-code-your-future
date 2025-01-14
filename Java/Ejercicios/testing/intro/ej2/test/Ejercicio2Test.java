package Java.Ejercicios.testing.intro.ej2.test;

import Java.Ejercicios.testing.intro.ej2.src.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ejercicio2Test {
  @Test
  void testDoble() {
    Integer resultado = Ejercicio2.doble(2);
    Assertions.assertEquals(4, resultado);
  }

  @Test
  void testTripe() {
    Integer resultado = Ejercicio2.tripe(2);
    Assertions.assertEquals(6, resultado);
  }
}
