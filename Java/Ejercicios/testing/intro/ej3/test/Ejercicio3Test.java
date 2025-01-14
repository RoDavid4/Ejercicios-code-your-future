package Java.Ejercicios.testing.intro.ej3.test;

// import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Java.Ejercicios.testing.intro.ej3.src.Ejercicio3;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Ejercicio3Test {
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
  void testMain() {
    Ejercicio3.main(new String[1]);
    String salida = outputStreamCaptor.toString();
    // OPCION 3: Creo un arreglo, indicando que provoca "dividir" los elementos,
    // para poder
    // contemplar TODAS las entradas del System.out. En esta oportunidad, \r\n es mi
    // "separador"
    String[] salidas = salida.split("\r\n");
    assertEquals(
        "El doble de 15 es:30",
        salidas[0]); // Comparo la cadena, con la primer posicion del arreglo
    // OPCION 2:Analizo si.. existe dentro del objeto, una cadena especifica
    // assertTrue(salida.contains("El doble de 15 es:30\r\n"));
    // assertTrue(salida.contains("El triple de 15 es:45\r\n"));
    // OPCION 1:Esta opcion, verifica "Todas las salidas del objeto System.out"
    // assertEquals("El doble de 15 es:30\r\n", salida);//Se contempla los saltos de
    // linea.
  }

  @Test
  void testDoble() {
    Integer resultado = Ejercicio3.doble(3);
    Assertions.assertEquals(6, resultado);
  }

  @Test
  void testTriple() {
    Integer resultado = Ejercicio3.triple(3);
    Assertions.assertEquals(9, resultado);
  }
}
