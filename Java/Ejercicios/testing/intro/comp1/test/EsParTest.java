package Java.Ejercicios.testing.intro.comp1.test;

import static org.junit.Assert.assertEquals;

import Java.Ejercicios.testing.intro.comp1.src.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class EsParTest {

  private InputStream standarIn = System.in;

  @AfterEach
  public void tearDown() {
    System.setIn(standarIn);
  }

  @Test
  void testEsPar() {
    // Arrange
    int numeroT = 4;
    int numeroF = 3;
    boolean esperadoT = true;
    boolean esperadoF = false;
    // Act
    boolean resultadoT = EsPar.esPar(numeroT);
    boolean resultadoF = EsPar.esPar(numeroF);
    // Assert
    assertEquals(esperadoT, resultadoT);
    assertEquals(esperadoF, resultadoF);
  }

  @Test
  void testSolicitarNumero() {
    // Arrange
    Integer esperado = 4;
    ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
    System.setIn(in);
    // Act
    Integer resultado = EsPar.solicitarNumero();
    // Assert
    assertEquals(esperado, resultado);
  }
}
