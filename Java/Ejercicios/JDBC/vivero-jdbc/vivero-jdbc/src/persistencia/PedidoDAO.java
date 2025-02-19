package persistencia;

import entidades.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO extends DAO {

  // Listar todos los pedidos con su detalle de un cliente específico que es pasado como parámetro.
  public List<Pedido> listarPedidosCliente(int idCliente) throws Exception {

    String sql = "SELECT * FROM pedido WHERE id_cliente = " + idCliente;
    consultarDataBase(sql);

    return listarPedidosAux();
  }

  // Listar todos los pedidos que han quedado en un estado que se recibe por parámetro.
  public List<Pedido> listarPedidosEstado(String estado) throws Exception {

    String sql = "SELECT * FROM pedido WHERE estado = '" + estado + "'";
    consultarDataBase(sql);

    return listarPedidosAux();
  }

  // Listar todos los pedidos que tengan un producto específico asociado, dato que se recibe  como
  // parámetro.
  public List<Pedido> listarPedidosProducto(int idProducto) throws Exception {
    String sql =
        "SELECT p.id_pedido, p.codigo_pedido, p.fecha_pedido, p.fecha_esperada, p.fecha_entrega,"
            + " p.estado, p.comentarios, p.id_cliente FROM pedido AS p JOIN detalle_pedido AS dp ON"
            + " p.id_pedido = dp.id_pedido WHERE dp.id_producto = "
            + idProducto;

    consultarDataBase(sql);

    return listarPedidosAux();
  }

  private List<Pedido> listarPedidosAux() throws Exception {
    List<Pedido> pedidos = new ArrayList<>();
    while (resultSet.next()) {
      Pedido pedido =
          new Pedido(
              resultSet.getInt("id_pedido"),
              resultSet.getInt("codigo_pedido"),
              resultSet.getDate("fecha_pedido"),
              resultSet.getDate("fecha_esperada"),
              resultSet.getDate("fecha_entrega"),
              resultSet.getString("estado"),
              resultSet.getString("comentarios"),
              resultSet.getInt("id_cliente"));
      pedidos.add(pedido);

      System.out.println(pedido.toString());
    }

    return pedidos;
  }

  public void guardarPedido(Pedido pedido) throws Exception {

    String query =
        "INSERT INTO Pedido (codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado,"
            + " comentarios, id_cliente) VALUES ("
            + pedido.getCodigoPedido()
            + ", '"
            + new java.sql.Date(pedido.getFechaPedido().getTime())
            + "', '"
            + new java.sql.Date(pedido.getFechaEsperada().getTime())
            + "', '"
            + new java.sql.Date(pedido.getFechaEntrega().getTime())
            + "', '"
            + pedido.getEstado()
            + "', '"
            + pedido.getComentario()
            + "', "
            + pedido.getIdCliente()
            + ");";

    insertarModificarEliminarDataBase(query);
  }
}
