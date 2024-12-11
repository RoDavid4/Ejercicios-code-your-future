package Java.Ejercicios.testing.pruebasParametrizadas.calificacion.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Java.Ejercicios.testing.pruebasParametrizadas.calificacion.src.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {
  @Test
  void testLeeNota() {}

  @Test
  void testMain() {}

  @ParameterizedTest
  @CsvSource({"30, F", "99, A", "78, C", "64, D", "81, B", "-100, Valor ingresado incorrecto"})
  void testObtieneNota(int nota, String valorEsperado) {
    assertEquals(valorEsperado, App.obtieneNota(nota));
  }
}
