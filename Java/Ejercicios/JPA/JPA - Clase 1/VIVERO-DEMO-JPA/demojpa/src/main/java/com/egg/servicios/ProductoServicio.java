package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;
import java.util.List;

public class ProductoServicio {
  private final ProductoDAO daoProducto;

  public ProductoServicio() {
    this.daoProducto = new ProductoDAO();
  }

  public void crearProducto(
      int cantidadStock,
      String codigoProducto,
      String descripcion,
      String dimensiones,
      String nombre,
      int precioProveedor,
      int precioVenta,
      String proveedor,
      GamaProducto idGamaProducto) {

    try {
      Producto productoNvo = new Producto();

      productoNvo.setCantidadEnStock(cantidadStock);
      productoNvo.setCodigoProducto(codigoProducto);
      productoNvo.setDescripcion(descripcion);
      productoNvo.setDimensiones(dimensiones);
      productoNvo.setNombre(nombre);
      productoNvo.setPrecioProveedor(precioProveedor);
      productoNvo.setPrecioVenta(precioVenta);
      productoNvo.setProveedor(proveedor);
      productoNvo.setGamaProducto(idGamaProducto);

      daoProducto.guardarProducto(productoNvo);

    } catch (Exception e) {
      System.out.println(e.toString() + "No se guardo el nuevo producto de manera correcta");
    }
  }

  public Producto buscarProducto(int idProducto) {
    Producto producto = daoProducto.buscarProducto(idProducto);
    try {
      if (producto == null) {
        System.out.println("No existe una producto con el ID proporcionado: " + idProducto);
      }

      return producto;

    } catch (Exception e) {
      System.out.println("Ocurrió un error al buscar el producto: " + e.getMessage());
    }
    return null;
  }

  public void listarProductos() throws Exception {
    List<Producto> todosProductos = daoProducto.listarTodos();
    imprimirLista(todosProductos);
  }

  public void imprimirLista(List<Producto> listaRecibida) throws Exception {
    for (Producto unitarioProducto : listaRecibida) {
      System.out.println(
          unitarioProducto.getCodigoProducto()
              + " - "
              + unitarioProducto.getNombre()
              + " - "
              + unitarioProducto.getCantidadEnStock());
    }
  }
}