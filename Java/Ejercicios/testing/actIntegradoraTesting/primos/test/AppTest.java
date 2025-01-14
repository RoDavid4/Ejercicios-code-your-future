package Java.Ejercicios.testing.actIntegradoraTesting.primos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Java.Ejercicios.testing.actIntegradoraTesting.primos.src.App;

public class AppTest {
  @CsvSource({"0,false", "5,true", "6,false", "7,true", "8,false", "9,false", "10,false"})
  @ParameterizedTest
  void testEsPrimo(int entrada, boolean esperado) {
    assertEquals(esperado, App.esPrimo(entrada));
  }

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
  void testNumPrimos() {
    // arrange
    String entrada = "4\n5\n";
    ByteArrayInputStream in = new ByteArrayInputStream((entrada.getBytes()));
    System.setIn(in);
    // act
    App.numPrimos();
    // assert
    String salida = outputStreamCaptor.toString().trim();
    String[] lineasSalida = salida.split(System.lineSeparator());
    String[] esperado = {
      "Ingrese un número: ", "El número no es primo", "Ingrese un número: ", "El número es primo"
    };

    assertEquals(esperado.length, lineasSalida.length, "La cantidad de líneas no coincide");

    for (int i = 0; i < esperado.length; i++) {
      assertEquals(esperado[i].trim(), lineasSalida[i].trim());
    }
  }
}
