package persistencia;

import entidades.Clientes;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO extends DAO {

  public void guardarCliente(Clientes cliente) throws Exception {

    if (cliente == null) {
      throw new Exception("Cliente no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email)"
              + " VALUES ('"
              + cliente.getNombre()
              + "', '"
              + cliente.getCalle()
              + "','"
              + cliente.getNumero()
              + "','"
              + cliente.getCodigoPostal()
              + "','"
              + cliente.getCiudad()
              + "','"
              + cliente.getPais()
              + "','"
              + cliente.getEmail()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Clientes> listarTodosLosCLientes() throws Exception {

    String sql = "SELECT id_cliente, nombre, email FROM clientes";
    consultarDataBase(sql);
    List<Clientes> clientes = new ArrayList<>();
    while (resultSet.next()) {
      Clientes cliente = new Clientes();
      cliente.setIdCliente(resultSet.getInt("id_cliente"));
      cliente.setNombre(resultSet.getString("nombre"));
      cliente.setEmail(resultSet.getString("email"));
      clientes.add(cliente);
      System.out.println(cliente.toString());
      System.out.println(" ");
    }
    return clientes;
  }

  public void buscarClientePorCodigo(int codigo) throws Exception {
    String sql = "SELECT * FROM clientes WHERE id_cliente = " + codigo;
    consultarDataBase(sql);

    if (resultSet.next()) {
      Clientes cliente = new Clientes();
      cliente.setIdCliente(resultSet.getInt("id_cliente"));
      cliente.setNombre(resultSet.getString("nombre"));
      cliente.setCalle(resultSet.getString("calle"));
      cliente.setNumero(resultSet.getInt("numero"));
      cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
      cliente.setCiudad(resultSet.getString("ciudad"));
      cliente.setPais(resultSet.getString("pais"));
      cliente.setEmail(resultSet.getString("email"));

      System.out.println(cliente.toString());
    }
  }

  // Eliminar un registro específico, recibiendo el id_cliente como parámetro.
  public void eliminarCliente(int idCliente) throws Exception {
    String sql = "DELETE FROM clientes WHERE id_cliente = " + idCliente;

    insertarModificarEliminarDataBase(sql);
  }
}
