package persistencia;

import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

  public void guardarCliente(Cliente cliente) throws Exception {

    if (cliente == null) {
      throw new Exception("Cliente no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto,"
              + " telefono, fax, ciudad, region, país, codigo_postal,id_empleado, limite_credito)"
              + " VALUES ('"
              + cliente.getCodigoCliente()
              + "', '"
              + cliente.getNombreCliente()
              + "','"
              + cliente.getApellidoContacto()
              + "','"
              + cliente.getTelefono()
              + "','"
              + cliente.getFax()
              + "','"
              + cliente.getCiudad()
              + "','"
              + cliente.getRegion()
              + "','"
              + cliente.getPais()
              + "','"
              + cliente.getCodigoPostal()
              + "','"
              + cliente.getIdEmpleado()
              + "','"
              + cliente.getLimiteCredito()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Cliente> listarTodosLosCLientes() throws Exception {

    String sql =
        "SELECT id_cliente, nombre_cliente, nombre_contacto, apellido_contacto FROM cliente";
    consultarDataBase(sql);
    List<Cliente> clientes = new ArrayList<>();
    while (resultSet.next()) {
      Cliente cliente = new Cliente();
      cliente.setIdCliente(resultSet.getInt("id_cliente"));
      cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
      cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
      cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
      clientes.add(cliente);
      System.out.println(cliente.toString());
      System.out.println(" ");
    }
    return clientes;
  }

  public void buscarClientePorCodigo(int codigo) throws Exception {
    String sql = "SELECT * FROM cliente WHERE codigo_cliente = " + codigo;
    consultarDataBase(sql);

    if (resultSet.next()) {
      Cliente cliente = new Cliente();
      cliente.setIdCliente(resultSet.getInt("id_cliente"));
      cliente.setCodigoCliente(resultSet.getInt("codigo_cliente"));
      cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
      cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
      cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
      cliente.setTelefono(resultSet.getString("telefono"));
      cliente.setFax(resultSet.getString("fax"));
      cliente.setCiudad(resultSet.getString("ciudad"));
      cliente.setRegion(resultSet.getString("region"));
      cliente.setPais(resultSet.getString("pais"));
      cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
      cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
      cliente.setLimiteCredito(resultSet.getFloat("limite_credito"));

      System.out.println(cliente.toString());
    }
  }

  // Eliminar un registro específico, recibiendo el id_cliente como parámetro.
  public void eliminarCliente(int idCliente) throws Exception {
    String sql = "DELETE FROM cliente WHERE id_cliente = " + idCliente;

    insertarModificarEliminarDataBase(sql);
  }

  // Listar los clientes vinculados a un id_empleado en particular, recibiendo como parámetro dicha
  // información.
  public List<Cliente> listarClientesPorEmpleado(int idEmpleado) throws Exception {
    String sql = "SELECT * FROM cliente WHERE id_empleado = " + idEmpleado;
    consultarDataBase(sql);
    List<Cliente> clientes = new ArrayList<>();
    while (resultSet.next()) {
      Cliente cliente = new Cliente();
      cliente.setIdCliente(resultSet.getInt("id_cliente"));
      cliente.setCodigoCliente(resultSet.getInt("codigo_cliente"));
      cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
      cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
      cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
      cliente.setTelefono(resultSet.getString("telefono"));
      cliente.setFax(resultSet.getString("fax"));
      cliente.setCiudad(resultSet.getString("ciudad"));
      cliente.setRegion(resultSet.getString("region"));
      cliente.setPais(resultSet.getString("pais"));
      cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
      cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
      cliente.setLimiteCredito(resultSet.getFloat("limite_credito"));

      clientes.add(cliente);

      System.out.println(cliente.toString());
    }
    return clientes;
  }

  // Incrementar en un 15% el límite de crédito de todos los clientes registrados.
  public void incrementarLimiteCredito() throws Exception {
    String sql =
        "UPDATE cliente SET limite_credito = limite_credito * 1.15 WHERE limite_credito IS NOT"
            + " NULL";
    insertarModificarEliminarDataBase(sql);
  }
  
}
