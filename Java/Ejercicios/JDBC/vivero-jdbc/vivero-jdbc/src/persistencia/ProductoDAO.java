package persistencia;

import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO extends DAO {

  public void eliminarProductoPorCodigo(int codigo) throws Exception {
    // Eliminar el producto de la base de datos
    String sql = "DELETE FROM producto WHERE id_producto = " + codigo;

    insertarModificarEliminarDataBase(sql);
  }

  public void guardarProducto(Producto producto) throws Exception {

    if (producto == null) {
      throw new Exception("producto no puede ser nulo");
    } else {

      String sql =
          "INSERT INTO producto (codigo_producto, nombre, id_gama, dimensiones,"
              + " proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor)"
              + " VALUES ('"
              + producto.getCodigoProducto()
              + "', '"
              + producto.getNombre()
              + "','"
              + producto.getIdGama()
              + "','"
              + producto.getDimensiones()
              + "','"
              + producto.getProveedor()
              + "','"
              + producto.getDescripcion()
              + "','"
              + producto.getCantidadEnStock()
              + "','"
              + producto.getPrecioVenta()
              + "','"
              + producto.getPrecioProveedor()
              + "')";

      insertarModificarEliminarDataBase(sql);
    }
  }

  public List<Producto> listarTodosLosProductos() throws Exception {

    String sql = "SELECT id_producto, nombre, descripcion, cantidad_en_stock FROM producto";
    consultarDataBase(sql);
    List<Producto> productos = new ArrayList<>();
    while (resultSet.next()) {
      Producto producto = new Producto();
      producto.setIdProducto(resultSet.getInt("id_producto"));
      producto.setNombre(resultSet.getString("nombre"));
      producto.setDescripcion(resultSet.getString("descripcion"));
      producto.setCantidadEnStock(resultSet.getInt("cantidad_en_stock"));
      productos.add(producto);
      System.out.println(
          "ID Producto: "
              + producto.getIdProducto()
              + ", Nombre: "
              + producto.getNombre()
              + ", Descripción: "
              + producto.getDescripcion()
              + ", Cantidad en Stock: "
              + producto.getCantidadEnStock());
      System.out.println(" ");
    }
    return productos;
  }

  // Modificar un registro específico, recibiendo el id_producto como parámetro.
  public void modificarProducto(Producto producto, int idProducto) throws Exception {

    if (producto != null) {
      String sql =
          "UPDATE producto SET nombre = '"
              + producto.getNombre()
              + "', dimensiones ='"
              + producto.getDimensiones()
              + "', proveedor = '"
              + producto.getProveedor()
              + "', descripcion ='"
              + producto.getDescripcion()
              + "', cantidad_en_stock = "
              + producto.getCantidadEnStock()
              + "', precio_venta = '"
              + producto.getPrecioVenta()
              + "', precio_proveedor = '"
              + producto.getPrecioProveedor()
              + " WHERE id_producto = "
              + idProducto;
      insertarModificarEliminarDataBase(sql);
    } else { // si se modifica por un producto null entonces se elimina
      eliminarProductoPorCodigo(idProducto);
    }
  }

  // Listar el/los productos con la menor cantidad_en_stock disponible.
  public List<Producto> listarProductosConMenorCantidadEnStock() throws Exception {
    List<Producto> productos = new ArrayList<>();

    String sql = "SELECT * FROM producto ORDER BY cantidad_en_stock ASC LIMIT 10";
    consultarDataBase(sql);

    while (resultSet.next()) {
      Producto producto = new Producto();
      producto.setIdProducto(resultSet.getInt("id_producto"));
      producto.setNombre(resultSet.getString("nombre"));
      producto.setDescripcion(resultSet.getString("descripcion"));
      producto.setCantidadEnStock(resultSet.getInt("cantidad_en_stock"));

      productos.add(producto);

      System.out.println(
          "ID Producto: "
              + producto.getIdProducto()
              + ", Nombre: "
              + producto.getNombre()
              + ", Descripción: "
              + producto.getDescripcion()
              + ", Cantidad en Stock: "
              + producto.getCantidadEnStock());
      System.out.println(" ");
    }
    return productos;
  }

  // Listar el/los productos con el menor precio_venta.
  public List<Producto> listarProductosConMenorPrecioVenta() throws Exception {
    List<Producto> productos = new ArrayList<>();
    String sql = "SELECT * FROM producto ORDER BY precio_venta ASC LIMIT 10";
    consultarDataBase(sql);
    while (resultSet.next()) {
      Producto producto = new Producto();
      producto.setIdProducto(resultSet.getInt("id_producto"));
      producto.setNombre(resultSet.getString("nombre"));
      producto.setDescripcion(resultSet.getString("descripcion"));
      producto.setPrecioVenta(resultSet.getFloat("precio_venta"));
      producto.setCantidadEnStock(resultSet.getInt("cantidad_en_stock"));
      productos.add(producto);
      System.out.println(
          "ID Producto: "
              + producto.getIdProducto()
              + ", Nombre: "
              + producto.getNombre()
              + ", Descripción: "
              + producto.getDescripcion()
              + ", Precio de Venta: "
              + producto.getPrecioVenta()
              + ", Cantidad en Stock: "
              + producto.getCantidadEnStock());
      System.out.println(" ");
    }
    return productos;
  }
}
