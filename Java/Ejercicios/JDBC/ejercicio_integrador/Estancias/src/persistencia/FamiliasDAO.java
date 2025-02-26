package persistencia;

import entidades.Familias;
import java.util.ArrayList;
import java.util.List;

public class FamiliasDAO extends DAO {

  public void guardarFamilia(Familias familia) throws Exception {

    if (familia == null) {
      throw new Exception("familia no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email,"
              + " id_casa_familia) VALUES ('"
              + familia.getNombre()
              + "', '"
              + familia.getEdadMinima()
              + "','"
              + familia.getEdadMaxima()
              + "','"
              + familia.getNumHijos()
              + "','"
              + familia.getEmail()
              + "','"
              + familia.getIdCasaFamilia()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Familias> listarTodasLasFamilias() throws Exception {

    String sql = "SELECT id_familia, nombre, email FROM familias";
    consultarDataBase(sql);
    List<Familias> Familias = new ArrayList<>();
    while (resultSet.next()) {
      Familias familia = new Familias();
      familia.setIdFamilia(resultSet.getInt("id_familia"));
      familia.setNombre(resultSet.getString("nombre"));
      familia.setEdadMinima(resultSet.getInt("edad_minima"));
      familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
      familia.setNumHijos(resultSet.getInt("num_hijos"));
      familia.setEmail(resultSet.getString("email"));
      Familias.add(familia);
      System.out.println(familia.toString());
      System.out.println(" ");
    }
    return Familias;
  }

  public void buscarFamiliaPorCodigo(int codigo) throws Exception {
    String sql = "SELECT * FROM familias WHERE id_familia = " + codigo;
    consultarDataBase(sql);

    if (resultSet.next()) {
      Familias familia = new Familias();
      familia.setIdFamilia(resultSet.getInt("id_familia"));
      familia.setNombre(resultSet.getString("nombre"));
      familia.setEdadMinima(resultSet.getInt("edad_minima"));
      familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
      familia.setNumHijos(resultSet.getInt("num_hijos"));
      familia.setEmail(resultSet.getString("email"));
      familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));

      System.out.println(familia.toString());
    }
  }

  // Eliminar un registro específico, recibiendo el id_familia como parámetro.
  public void eliminarFamilia(int idfamilia) throws Exception {
    String sql = "DELETE FROM familias WHERE id_familia = " + idfamilia;

    insertarModificarEliminarDataBase(sql);
  }

  public List<Familias> listarMinHijosEdadesMaximas(int minHijos, int edadMaxima) throws Exception {

    String sql = "SELECT * FROM familias WHERE num_hijos >= " + minHijos + " AND edad_maxima < " + edadMaxima;
    consultarDataBase(sql);
    List<Familias> familias = new ArrayList<>();
    while (resultSet.next()) {
        Familias familia = new Familias();
        familia.setIdFamilia(resultSet.getInt("id_familia"));
        familia.setNombre(resultSet.getString("nombre"));
        familia.setEdadMinima(resultSet.getInt("edad_minima"));
        familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
        familia.setNumHijos(resultSet.getInt("num_hijos"));
        familia.setEmail(resultSet.getString("email"));
        familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        familias.add(familia);
        System.out.println(familia.toString());
        System.out.println(" ");
    }
    return familias;
}
}
