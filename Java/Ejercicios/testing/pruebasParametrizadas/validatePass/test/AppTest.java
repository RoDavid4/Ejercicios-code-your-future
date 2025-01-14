package Java.Ejercicios.testing.pruebasParametrizadas.validatePass.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Java.Ejercicios.testing.pruebasParametrizadas.validatePass.src.*;

public class AppTest {
    
    @ParameterizedTest
    @CsvSource({"Casa123!, true", "casa123!, false" , "Casa1234, false" ,"CASA123!, false"})// El primer valor es el input y el segundo es el esperado
    void testEsPasswordSegura(String pass, boolean resultado) {
        assertEquals(resultado, App.esPasswordSegura(pass), "la contraseña no es segura");
    }
}
