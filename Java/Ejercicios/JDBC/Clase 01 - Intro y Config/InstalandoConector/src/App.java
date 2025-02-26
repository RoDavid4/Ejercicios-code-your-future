import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("\033\143"); // Limpia la pantalla
    Connection conexion = getConnection();

    buscarClientePorCodigo(5, conexion);
    buscarClientePorCodigo(4, conexion);
    buscarClientePorCodigo(1, conexion);
    buscarClientePorCodigo(19, conexion);

    buscarClientePorEmpleado(11, conexion);

    cerrarConexion(conexion);
  }

  public static Connection getConnection() {
    String host = "127.0.0.1"; // localhost
    String port = "3306"; // por defecto es el puerto que utiliza
    String name = "root"; // usuario de la base de datos
    String password = "root"; // password de la base de datos
    String database = "vivero"; // nombre de la base de datos recien creada, en este caso vivero.
    // Esto especifica una zona horaria, no es obligatorio de utilizar, pero en
    // algunas zonas genera conflictos de conexión si no existiera
    String zona =
        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-3";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
    // esto indica la ruta de conexion, que es la combinacion de
    // host,usuario,puerto, nombre de la base de datos a la cual queremos
    // conectarnos y la zona horaria (si se precisara).

    Connection conexion = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      conexion = DriverManager.getConnection(url, name, password);
      System.out.println("Conexión exitosa a la base de datos.");
    } catch (ClassNotFoundException e) {
      System.out.println("Error al cargar el conector JDBC: " + e.getMessage());
    } catch (SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
    }
    return conexion;
  }

  public static void cerrarConexion(Connection conexion) {
    if (conexion != null) {
      try {
        conexion.close();
        System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
      } catch (SQLException e) {
        System.out.println("Error al cerrar la conexión:" + e.getMessage());
      }
    }
  }

  public static void buscarClientes(Connection conexion) {
    String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente ";
    try {
      Statement stmt = conexion.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      int count = 0;
      while (rs.next()) {
        String nombre = rs.getString("nombre_contacto");
        String apellido = rs.getString("apellido_contacto");
        String telefono = rs.getString("telefono");
        count++;
        System.out.println(count + " - " + nombre + " " + apellido + " - " + telefono);
      }
      // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      System.out.println("Error en la consulta: " + e.getMessage());
    }
  }

  /* Realiza un método llamado buscarClientePorCodigo(codigo) que reciba como parámetro el código 
  del cliente y muestre por pantalla los datos que tiene el cliente guardado en la base de datos. */
  // los campos de la tabla son: String codigo_cliente 
  public static void buscarClientePorCodigo(int codigo, Connection connection) {
    String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente WHERE id_cliente = '"+ codigo +"'";

    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String nombre = rs.getString("nombre_contacto");
            String apellido = rs.getString("apellido_contacto");
            String telefono = rs.getString("telefono");
            System.out.println("id: " + codigo + " - " + nombre + " " + apellido + " - " + telefono);
        }

        stmt.close();
        rs.close();
    } catch (SQLException e) {
        // TODO: handle exception
    }
  }

  /* Realiza un método llamado  buscarClientesPorEmpleado(codigo) que reciba el código del empleado 
  como parámetro y muestre todos los clientes asociados a un empleado en particular. Puedes elegir qué 
  campos mostrar en tu método. */

  public static void buscarClientePorEmpleado(int codigo, Connection connection) {
    String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente WHERE id_empleado = '"+ codigo +"'";

    try {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String nombre = rs.getString("nombre_contacto");
            String apellido = rs.getString("apellido_contacto");
            String telefono = rs.getString("telefono");
            System.out.println("id del empleado: " + codigo + " datos del cliente " +" - " + nombre + " " + apellido + " - " + telefono);
        }

        stmt.close();
        rs.close();
    } catch (SQLException e) {
        // TODO: handle exception
    }
  }

}
