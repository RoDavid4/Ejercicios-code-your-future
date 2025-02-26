package persistencia;

import entidades.Oficina;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO extends DAO {

  public void eliminarOficinaPorCodigo(int codigo) throws Exception {
    // Eliminar la oficina de la base de datos
    String sql = "DELETE FROM oficina WHERE id_oficina = " + codigo;

    insertarModificarEliminarDataBase(sql);
  }

  public void guardaroficina(Oficina oficina) throws Exception {

    if (oficina == null) {
      throw new Exception("oficina no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO oficina (codigo_oficina, ciudad, pais, region,"
              + " codigo_postal, telefono)"
              + " VALUES ('"
              + oficina.getCodigoOficina()
              + "', '"
              + oficina.getCiudad()
              + "','"
              + oficina.getPais()
              + "','"
              + oficina.getRegion()
              + "','"
              + oficina.getCodigoPostal()
              + "','"
              + oficina.getTelefono()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Oficina> listarOficinas() throws Exception {
    String sql = "SELECT * FROM oficina";
    consultarDataBase(sql);

    return listarOficinasAux();
  }

  private List<Oficina> listarOficinasAux() throws Exception {
    List<Oficina> Oficinas = new ArrayList<>();
    while (resultSet.next()) {
      Oficina Oficina =
          new Oficina(
              resultSet.getInt("id_oficina"),
              resultSet.getString("codigo_oficina"),
              resultSet.getString("ciudad"),
              resultSet.getString("pais"),
              resultSet.getString("region"),
              resultSet.getString("codigo_postal"),
              resultSet.getString("telefono"));
      Oficinas.add(Oficina);

      System.out.println(Oficina.toString());
    }

    return Oficinas;
  }
}
