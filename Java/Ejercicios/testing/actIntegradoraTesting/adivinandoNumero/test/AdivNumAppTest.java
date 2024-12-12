package Java.Ejercicios.testing.actIntegradoraTesting.adivinandoNumero.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Java.Ejercicios.testing.actIntegradoraTesting.adivinandoNumero.src.AdivNumApp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class AdivNumAppTest {

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
  void testAdivNum() {
    // Arrange
    String num = "13\n 14\n 15\n 16\n 17\n 18\n"   ; 
    ByteArrayInputStream in = new ByteArrayInputStream(( num.getBytes()));
    System.setIn(in);
    // Act
    AdivNumApp.adivNum();
    // Assert
    String salida = outputStreamCaptor.toString().trim(); 
    String[] lines = salida.split(System.lineSeparator()); 
    assertTrue(lines[lines.length - 1].contains("¡Lo has adivinado!"));
  }

  @Test
  void testMain() {}

  @RepeatedTest(25)
  void testNumeroAleatorio() {
    // Arrange
    int min = 13, max = 35;
    // Act
    int resultado = AdivNumApp.numeroAleatorio(min, max);
    // Assert
    assertTrue(resultado >= min && resultado <= max);
  }
}
