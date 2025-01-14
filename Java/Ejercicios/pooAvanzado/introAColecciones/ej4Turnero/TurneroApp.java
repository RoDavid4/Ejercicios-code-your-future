package Java.Ejercicios.pooAvanzado.introAColecciones.ej4Turnero;

import java.util.ArrayList;
import java.util.Iterator;

public class TurneroApp {

  /*  Actividad: Turnero
  Te han encomendado desarrollar un sistema de asignación de turnos para un
  servicio al cliente en Java.

  El procedimiento es el siguiente: los clientes obtienen un número de turno al
  llegar y se colocan en una lista en el orden en que llegaron. Además del
  servicio habitual, donde se atiende al cliente que ha estado esperando por
  más tiempo, periódicamente se realiza un sorteo. En este sorteo, se
  selecciona un número aleatorio y el cliente con ese número es atendido de
  inmediato.

  Para lograr esto, necesitas:

  Guardar una lista de números de turno en el orden en que fueron emitidos.

  Buscar eficientemente un número de turno específico en la lista cuando se
  selecciona en el sorteo. Para buscar eficientemente un número de turno
  específico en la lista cuando se selecciona en el sorteo, debes tener en
  cuenta cómo manejar la situación cuando un número ha sido sorteado. En este
  caso, es importante considerar qué sucede con su posición inicial en la
  lista. ¿Los datos se mueven o permanecen en su lugar?


  Implementa esta funcionalidad utilizando un ArrayList. Este tipo de lista
  permite mantener los elementos en el orden de inserción y realizar búsquedas
  eficientes por índice cuando se realiza el sorteo. */
  public static void main(String[] args) {
    ArrayList<Integer> turnos = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      turnos.add(i);
    }
    System.out.println("\033\143"); // limpia la pantalla
    Iterator<Integer> iterator = turnos.iterator();
    int cont = 1;

    while (iterator.hasNext()) {
      if (cont % 5 == 0) { // Cada 5 turnos sortea uno
        Integer turno = turnos.get(sortearTurno(turnos));
        System.out.println("Turno sorteado: " + turno);   
        turnos.remove(turno); // Elimina el turno sorteado de la lista
        iterator = turnos.iterator(); // Reinicia el iterador después de modificar la lista
      } else {
        Integer turno = iterator.next();
        System.out.println("se procesa el turno: " + turno);
        iterator.remove(); // Elimina el turno actual de la lista usando el iterador
      }
      cont++;
    }
  }

  private static int sortearTurno(ArrayList<Integer> turnos) {
    // ahora se sortea un numero entre 0 y la cantidad de elementos de la lista de turnos
    return (int) (Math.random() * turnos.size());
  }
}
