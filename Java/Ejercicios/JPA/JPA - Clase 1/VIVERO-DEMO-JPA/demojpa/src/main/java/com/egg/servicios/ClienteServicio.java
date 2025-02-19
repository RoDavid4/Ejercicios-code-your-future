package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;
import java.util.List;

public class ClienteServicio {
  private final ClienteDAO daoCliente;

  public ClienteServicio() {
    this.daoCliente = new ClienteDAO();
  }

  public void crearCliente(
      String apellidoContacto,
      String ciudad,
      int codigoCliente,
      String codigoPostal,
      String fax,
      int idEmpleado,
      double limiteCredito,
      String nombreCliente,
      String nombreContacto,
      String pais,
      String region,
      String telefono) {

    try {
      Cliente cliente = new Cliente(); // Creamos un objeto de la clase Cliente

      cliente.setApellidoContacto(apellidoContacto);
      cliente.setCiudad(ciudad);
      cliente.setCodigoCliente(codigoCliente);
      cliente.setCodigoPostal(codigoPostal);
      cliente.setFax(fax);
      cliente.setIdEmpleado(idEmpleado);
      cliente.setLimiteCredito(limiteCredito);
      cliente.setNombreCliente(nombreCliente);
      cliente.setNombreContacto(nombreContacto);
      cliente.setPais(pais);
      cliente.setRegion(region);
      cliente.setTelefono(telefono);

      daoCliente.guardarCliente(cliente);

    } catch (Exception e) {
      System.out.println(e.toString() + "No se guardo el nuevo cliente de manera correcta");
    }
  }

  public void listarOficinas() throws Exception {
    List<Cliente> todosClientes = daoCliente.listarTodos();
    imprimirLista(todosClientes);
  }

  public void imprimirLista(List<Cliente> listaRecibida) throws Exception {
    for (Cliente unitarioCliente : listaRecibida) {
      System.out.println(
          unitarioCliente.getCodigoCliente()
              + " - "
              + unitarioCliente.getNombreCliente()
              + " - "
              + unitarioCliente.getPais());
    }
  }

  public void listarClientes(String nombreRecibido) throws Exception {
    List<Cliente> clientesNombre = daoCliente.listarClientesPorNombre(nombreRecibido);
    imprimirListaPN(clientesNombre);
  }

  // Imprimo solo lgunos datos de la BBDD
  private void imprimirListaPN(List<Cliente> listaRecibida) {
    for (Cliente unitarioCliente : listaRecibida) {
      System.out.println(
          unitarioCliente.getIdCliente()
              + "-"
              + unitarioCliente.getApellidoContacto()
              + "-"
              + unitarioCliente.getNombreContacto());
    }
  }
}
