package Java.Ejercicios.testing.intro.impNomEd.test;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Java.Ejercicios.testing.intro.impNomEd.src.ImprimirNombreYEdad;

public class ImprimirNombreYEdadTest {

  // Configuracion output

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
  void testImprimir() {

    // Arrange
    String expected = "Nombre: Juan Edad: 30\r\n";
    ImprimirNombreYEdad imprimirNombreYEdad = new ImprimirNombreYEdad();
    String nombre = "Juan";
    int edad = 30;
    // Act
    imprimirNombreYEdad.imprimir(nombre, edad);
    // Assert
    String actual = outputStreamCaptor.toString();
    assertEquals(expected, actual);
  }
}
