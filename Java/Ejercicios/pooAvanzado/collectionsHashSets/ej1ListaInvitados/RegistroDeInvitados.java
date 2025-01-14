package Java.Ejercicios.pooAvanzado.collectionsHashSets.ej1ListaInvitados;

import java.util.HashSet;
import java.util.Iterator;

public class RegistroDeInvitados {
  private HashSet<String> invitados;

  public RegistroDeInvitados() {
    this.invitados = new HashSet<>();
  }

  public RegistroDeInvitados(HashSet<String> invitados) {
    this.invitados = invitados;
  }

  public boolean agregarInvitado(String nombreInvitado) {
    return invitados.add(nombreInvitado);
  }

  public boolean eliminarInvitado(String nombreInvitado) {
    return invitados.remove(nombreInvitado);
  }

  public void mostrarInvitados() {
    Iterator<String> iter = invitados.iterator();
    System.out.println("Lista de invitados: ");
    while (iter.hasNext()) {
      System.out.println("- " + iter.next());
    }
  }
}
