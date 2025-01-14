package com.equipo3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ApplicationTest {

  @Test
  void createMockObject() {
    List<String> mockedList = Mockito.mock(List.class);

    // Agregamos a la lista
    mockedList.add("Hola mundo");

    // verificamos el comportamiento
    verify(mockedList).add("Hola mundo");
    int resultado = mockedList.size();
    assertEquals(0, resultado);
    
    // modicicamos comportamiento del .size()
    int expectedSize = 5;
    when(mockedList.size()).thenReturn(expectedSize);
  }

  @Test
  void shouldAnswerWithTrue() {
    assertTrue(true);
  }
}
