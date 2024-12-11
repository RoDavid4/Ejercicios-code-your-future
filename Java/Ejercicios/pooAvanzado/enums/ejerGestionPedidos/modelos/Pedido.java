package Java.Ejercicios.pooAvanzado.enums.ejerGestionPedidos.modelos;

import Java.Ejercicios.pooAvanzado.enums.ejerGestionPedidos.enums.*;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
   private List<String> listadoProductos;
   private int numeroDePedido;
   private String cliente;
   private EstadoPedido estadoDelPedido;


   public Pedido(int numeroDePedido, String cliente, EstadoPedido estadoDelPedido) {
       this.numeroDePedido = numeroDePedido;
       this.cliente = cliente;
       this.listadoProductos = new ArrayList<String>();
       this.estadoDelPedido = estadoDelPedido;
   }


   public int getNumeroDePedido() {
       return numeroDePedido;
   }


   public void setNumeroDePedido(int numeroDePedido) {
       this.numeroDePedido = numeroDePedido;
   }


   public String getCliente() {
       return cliente;
   }


   public void setCliente(String cliente) {
       this.cliente = cliente;
   }


   public List<String> getListadoProductos() {
       return listadoProductos;
   }


   public void setListadoProductos(List<String> listadoProductos) {
       this.listadoProductos = listadoProductos;
   }


   public EstadoPedido getEstadoDelPedido() {
       return estadoDelPedido;
   }


   public void setEstadoDelPedido(EstadoPedido estadoDelPedido) {
       this.estadoDelPedido = estadoDelPedido;
   }
}

