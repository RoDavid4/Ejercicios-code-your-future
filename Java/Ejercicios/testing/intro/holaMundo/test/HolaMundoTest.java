package Java.Ejercicios.testing.intro.holaMundo.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Java.Ejercicios.testing.intro.holaMundo.src.HolaMundo;

public class HolaMundoTest {
  private final PrintStream standarOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standarOut);
  }

  @Test
  void testMain() {
    // Arrange
    String expected = "Hola Mundo\r\n";
    // Act
    HolaMundo.main(new String[1]);
    // Assert
    String actual = outputStreamCaptor.toString();
    assertEquals(expected, actual);
  }
}
