package Java.Ejercicios.testing.intro.impNomEd2.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Java.Ejercicios.testing.intro.impNomEd2.src.ImprimirNombreYEdad2;

public class ImprimirNombreYEdad2Test {
  // Configuracion output

  private final PrintStream standarOut = System.out;
  private InputStream standarIn = System.in;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standarOut);
    System.setIn(standarIn);
  }

  @Test
  void testImprimir() {

    // Arrange
    String expected = "Nombre: Juan Edad: 30\r\n";
    String nombre = "Juan";
    int edad = 30;
    // Act
    ImprimirNombreYEdad2.imprimir(nombre, edad);
    // Assert
    String actual = outputStreamCaptor.toString();
    assertEquals(expected, actual);
  }

  @Test
  void testMain() {
    // Arrange
    Integer edadPrueba = 30;
    String nombrePrueba = "Juan";
    ByteArrayInputStream in = new ByteArrayInputStream("Juan\n30\n".getBytes());
    System.setIn(in);
    ImprimirNombreYEdad2.main(new String[1]);
    // Act
    String salida = outputStreamCaptor.toString();
    // Assert
    assertEquals("Nombre: " + nombrePrueba + " Edad: " + edadPrueba + "\r\n", salida);
  }

  @Test
  void testObtenerEdad() {
    // Arrange
    Integer esperado = 70;
    ByteArrayInputStream in = new ByteArrayInputStream("70\n".getBytes());
    System.setIn(in);
    // Act
    Integer edadI = ImprimirNombreYEdad2.obtenerEdad(new Scanner(System.in));
    // Assert
    assertEquals(esperado, edadI);
  }

  @Test
  void testObtenerNombre() {
    // Arrange
    ByteArrayInputStream in = new ByteArrayInputStream("Pedro\n".getBytes());
    System.setIn(in);
    // Act
    String nombreI = ImprimirNombreYEdad2.obtenerNombre(new Scanner(System.in));
    // Assert
    assertEquals("Pedro", nombreI);
  }
}
