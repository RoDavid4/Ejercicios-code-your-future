package servicios;

import entidades.Pedido;
import java.sql.Date;
import persistencia.PedidoDAO;

public class PedidoServicio {
  private PedidoDAO pedidoDAO;

  public PedidoServicio() {
    this.pedidoDAO = new PedidoDAO();
  }

  public Pedido guardarPedido(
      int codigoPedido,
      Date fechaPedido,
      Date fechaEsperada,
      Date fechaEntrega,
      String estado,
      String comentario,
      int idCliente)
      throws Exception {

    validarPedido(null, fechaPedido, null);

    Pedido pedidoR = new Pedido(
        codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado, comentario, idCliente);
        pedidoDAO.guardarPedido(pedidoR);
    return pedidoR;
  }

  private void validarPedido(Integer codigoPedido, Date fechaPedido, Integer idCliente)
      throws Exception {
    if (codigoPedido == null) {
      throw new Exception("El código del pedido no puede ser nulo");
    }
    if (codigoPedido <= 0) {
      throw new Exception("El código del pedido debe ser mayor a 0");
    }
    if (fechaPedido == null) {
      throw new Exception("La fecha del pedido no puede ser nula");
    }
    if (idCliente == null) {
      throw new Exception("El id del cliente no puede ser nulo");
    }
    if (idCliente <= 0) {
      throw new Exception("El id del cliente debe ser mayor a 0");
    }
  }
}
