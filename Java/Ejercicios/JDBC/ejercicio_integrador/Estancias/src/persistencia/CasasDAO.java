package persistencia;

import entidades.Casas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CasasDAO extends DAO {

  public void guardarCasa(Casas casa) throws Exception {

    if (casa == null) {
      throw new Exception("casa no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta,"
              + " tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES ('"
              + casa.getCalle()
              + "','"
              + casa.getNumero()
              + "','"
              + casa.getCodigoPostal()
              + "','"
              + casa.getCiudad()
              + "','"
              + casa.getPais()
              + "','"
              + casa.getFechaDesde()
              + "','"
              + casa.getFechaHasta()
              + "','"
              + casa.getTiempoMinimo()
              + "','"
              + casa.getTiempoMaximo()
              + "','"
              + casa.getPrecioHabitacion()
              + "','"
              + casa.getTipoVivienda()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Casas> listarTodasLasCasas() throws Exception {

    String sql =
        "SELECT id_casa, calle, numero, ciudad, pais, fecha_desde, fecha_hasta, "
            + "tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda FROM casas";
    consultarDataBase(sql);
    List<Casas> Casas = new ArrayList<>();
    while (resultSet.next()) {
      Casas casa = new Casas();
      casa.setIdCasa(resultSet.getInt("id_casa"));
      casa.setCalle(resultSet.getString("calle"));
      casa.setNumero(resultSet.getInt("numero"));
      casa.setCiudad(resultSet.getString("ciudad"));
      casa.setPais(resultSet.getString("pais"));
      casa.setFechaDesde(resultSet.getDate("fecha_desde"));
      casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
      casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
      casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
      casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
      casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

      Casas.add(casa);
      System.out.println(casa.toString());
      System.out.println(" ");
    }
    return Casas;
  }

  public void buscarCasaPorCodigo(int codigo) throws Exception {
    String sql = "SELECT * FROM casas WHERE id_casa = " + codigo;
    consultarDataBase(sql);

    if (resultSet.next()) {
      Casas casa = new Casas();
      casa.setIdCasa(resultSet.getInt("id_casa"));
      casa.setCalle(resultSet.getString("calle"));
      casa.setNumero(resultSet.getInt("numero"));
      casa.setCodigoPostal("codigo_postal");
      casa.setCiudad(resultSet.getString("ciudad"));
      casa.setPais(resultSet.getString("pais"));
      casa.setFechaDesde(resultSet.getDate("fecha_desde"));
      casa.setFechaHasta(resultSet.getDate("fecha_hasta"));
      casa.setTiempoMinimo(resultSet.getInt("tiempo_minimo"));
      casa.setTiempoMaximo(resultSet.getInt("tiempo_maximo"));
      casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
      casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));

      System.out.println(casa.toString());
    }
  }

  // Eliminar un registro específico, recibiendo el id_casa como parámetro.
  public void eliminarCasa(int idcasa) throws Exception {
    String sql = "DELETE FROM casas WHERE id_casa = " + idcasa;

    insertarModificarEliminarDataBase(sql);
  }

  public List<Casas> listarCasasDisponibles(LocalDate fechaInicial, LocalDate fechaFinal) throws Exception {
        String sql = "SELECT id_casa, calle, numero, ciudad, pais, precio_habitacion, tipo_vivienda FROM casas WHERE (fecha_desde <= '"
        + fechaInicial + "' AND fecha_hasta <= '" + fechaFinal + "') AND (id_casa NOT IN (SELECT id_casa FROM estancias"
        + " WHERE ('" + fechaInicial + "' <= fecha_hasta AND '" + fechaFinal + "' >= fecha_desde)))";
        consultarDataBase(sql);

        List<Casas> casas = new ArrayList<>();
        while (resultSet.next()) {
            Casas casa = new Casas();
            casa.setIdCasa(resultSet.getInt("id_casa"));
            casa.setCalle(resultSet.getString("calle"));
            casa.setNumero(resultSet.getInt("numero"));
            casa.setCiudad(resultSet.getString("ciudad"));
            casa.setPais(resultSet.getString("pais"));
            casa.setPrecioHabitacion(resultSet.getDouble("precio_habitacion"));
            casa.setTipoVivienda(resultSet.getString("tipo_vivienda"));
            casas.add(casa);
            System.out.println(casa.toString());
        }
        return casas;
    }
}
