package persistencia;

import entidades.Comentarios;
import java.util.ArrayList;
import java.util.List;

public class ComentariosDAO extends DAO {

  public void guardarComentario(Comentarios comentario) throws Exception {

    if (comentario == null) {
      throw new Exception("comentario no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO comentarios (id_casa, comentario)"
              + " VALUES ('"
              + comentario.getIdCasa()
              + "', '"
              + comentario.getComentario()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Comentarios> listarTodosLosComentarios() throws Exception {

    String sql = "SELECT id_comentario, id_casa, comentario FROM comentarios";
    consultarDataBase(sql);
    List<Comentarios> Comentarios = new ArrayList<>();
    while (resultSet.next()) {
      Comentarios comentario = new Comentarios();
      comentario.setIdComentario(resultSet.getInt("id_comentario"));
      comentario.setIdCasa(resultSet.getInt("id_casa"));
      comentario.setComentario(resultSet.getString("comentario"));
      Comentarios.add(comentario);
      System.out.println(comentario.toString());
      System.out.println(" ");
    }
    return Comentarios;
  }

  public void buscarComentarioPorCodigo(int codigo) throws Exception {
    String sql = "SELECT * FROM comentarios WHERE id_comentario = " + codigo;
    consultarDataBase(sql);

    if (resultSet.next()) {
      Comentarios comentario = new Comentarios();
      comentario.setIdComentario(resultSet.getInt("id_comentario"));
      comentario.setIdCasa(resultSet.getInt("id_casa"));
      comentario.setComentario(resultSet.getString("comentario"));

      System.out.println(comentario.toString());
    }
  }

  // Eliminar un registro específico, recibiendo el id_comentario como parámetro.
  public void eliminarComentario(int idComentario) throws Exception {
    String sql = "DELETE FROM comentarios WHERE id_comentario = " + idComentario;

    insertarModificarEliminarDataBase(sql);
  }
}
