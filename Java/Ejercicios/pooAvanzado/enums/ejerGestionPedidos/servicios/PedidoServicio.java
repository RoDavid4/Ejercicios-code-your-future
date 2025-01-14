package Java.Ejercicios.pooAvanzado.enums.ejerGestionPedidos.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Java.Ejercicios.pooAvanzado.enums.ejerGestionPedidos.enums.EstadoPedido;
import Java.Ejercicios.pooAvanzado.enums.ejerGestionPedidos.modelos.Pedido;

public class PedidoServicio {
    static Scanner sc = new Scanner(System.in);
    private static List<Pedido> listaPedidos;
 
 
    public PedidoServicio() {
        listaPedidos = new ArrayList<>();
    }
 
 
    public PedidoServicio(List<Pedido> lista) {
        listaPedidos = lista;
    }
 
 
    public static void crearNuevoPedido(){
        // Pedir info
        System.out.println("Ingrese el Num. de Pedido");
        int numPedido = sc.nextInt();
 
 
        System.out.println("Ingrese el cliente");
        String cliente = sc.nextLine();
 
 
        listaPedidos.add(new Pedido(numPedido,cliente , EstadoPedido.PENDIENTE));
        System.out.println(" Se agrego ");
 
 
    }
    public static List<Pedido> buscarPedido(EstadoPedido estado){
        
        List<Pedido> aux = new ArrayList<>();
        for (Pedido p : listaPedidos){
            if (p.getEstadoDelPedido().equals(estado)) aux.add(p);
        }
        return aux;
    }
 
 
    public static List<Pedido> obtenerListaPedidos(){
        return listaPedidos;
    }
 
 
    public static void actualizarEstadoPedido(int numeroDePedido, EstadoPedido estadoNuevo){
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < listaPedidos.size()){
            if (listaPedidos.get(i).getNumeroDePedido() == numeroDePedido) {
                encontrado = true;
                listaPedidos.get(i).setEstadoDelPedido(estadoNuevo);
                System.out.println(" Se actualizo ");
            }else{
                i++;
            }
        }
    }
 }
 
