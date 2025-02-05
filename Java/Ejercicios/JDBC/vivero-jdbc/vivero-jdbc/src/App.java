import entidades.*;
import persistencia.*;

public class App { 
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.listarPedidosProducto(5);

    }
}
