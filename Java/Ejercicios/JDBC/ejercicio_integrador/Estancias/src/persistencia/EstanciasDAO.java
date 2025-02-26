package persistencia;

import entidades.Estancias;
import java.util.ArrayList;
import java.util.List;

public class EstanciasDAO extends DAO {

  public void guardarEstancia(Estancias estancia) throws Exception {

    if (estancia == null) {
      throw new Exception("estancia no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta)"
              + " VALUES ('"
              + estancia.getIdCliente()
              + "', '"
              + estancia.getIdCasa()
              + "','"
              + estancia.getNombreHuesped()
              + "','"
              + estancia.getFechaDesde()
              + "','"
              + estancia.getFechaHasta()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Estancias> listarTodasLasEstancias() throws Exception {

    String sql = "SELECT id_estancia, nombre_huesped, fecha_desde, fecha_hasta FROM estancias";
    consultarDataBase(sql);
    List<Estancias> Estancias = new ArrayList<>();
    while (resultSet.next()) {
      Estancias estancia = new Estancias();
      estancia.setIdEstancia(resultSet.getInt("id_estancia"));
      estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
      estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
      estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));
      Estancias.add(estancia);
      System.out.println(estancia.toString());
      System.out.println(" ");
    }
    return Estancias;
  }

  public void buscarEstanciaPorCodigo(int codigo) throws Exception {
    String sql = "SELECT * FROM estancias WHERE id_estancia = " + codigo;
    consultarDataBase(sql);

    if (resultSet.next()) {
      Estancias estancia = new Estancias();
      estancia.setIdEstancia(resultSet.getInt("id_estancia"));
      estancia.setIdCliente(resultSet.getInt("id_cliente"));
      estancia.setIdCasa(resultSet.getInt("id_casa"));
      estancia.setNombreHuesped(resultSet.getString("nombre_huesped"));
      estancia.setFechaDesde(resultSet.getDate("fecha_desde"));
      estancia.setFechaHasta(resultSet.getDate("fecha_hasta"));

      System.out.println(estancia.toString());
    }
  }

  // Eliminar un registro específico, recibiendo el id_estancia como parámetro.
  public void eliminarEstancia(int idEstancia) throws Exception {
    String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia;

    insertarModificarEliminarDataBase(sql);
  }
}
