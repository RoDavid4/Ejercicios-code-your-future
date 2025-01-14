package Java.Ejercicios.testing.intro.ej1TuPrimerTest.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Java.Ejercicios.testing.intro.ej1TuPrimerTest.src.Ejercicio1;

public class Ejercicio1Test {
    @Test
    void testDoble() {
        Integer resultado = Ejercicio1.doble(2);
        Assertions.assertEquals(4, resultado);
    }
}
