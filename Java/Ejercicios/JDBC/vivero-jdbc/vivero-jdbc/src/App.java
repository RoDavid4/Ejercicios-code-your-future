import entidades.*;
import persistencia.*;
import servicios.ClienteServicio;

public class App { 
    public static void main(String[] args) throws Exception {

        ClienteServicio cs = new ClienteServicio();
        String nulo = null;
        cs.buscarClientePorCodigo(2);

    }
}
